package com.thoth.messagelistener;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.currencyboot.service.rocketmq.messagelistener.Interface.MessageListenerConsumerInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoth.domain.ResultBean;
import com.thoth.domain.ThSnOrder;
import com.thoth.domain.ThothOrder;
import com.thoth.messagelistener.mongodb.ThothOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: ConsumableMessageListenerConsumer </p>
 * <p>@Description:  内销    </p>
 * <p>Company:  </p>
 *
 * @author 李文
 * @date 2016年9月25日 上午10:06:08
 */
public class ConsumableMessageListenerConsumer implements MessageListenerConsumerInterface
{

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ConsumableMessageListenerConsumer.class);

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    @Autowired
    private ThothOrderRepository tOrder;

    @Autowired
    private Edi_SuNingFeignServer feignServer;
    @Autowired
    private CallApi callApi;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(String strBody, MessageExt msg,
                                                    ConsumeConcurrentlyContext context) {
        LOGGER.info("\n 当前线程是" + Thread.currentThread().getId() + "  \n 数据是" + strBody);

        //TODO 进行数据整理
        ThothOrder order ;
        try {
            order = jsonMapper.readValue(strBody, ThothOrder.class);
        } catch (IOException e) {
            LOGGER.error("  原始 数据转换类型 异常      数据是 " + strBody, e);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

        // TODO   -1 旧标准模式



        //TODO    0 标准模式数据转换




        //TODO    1 自定义转换模式




        //TODO    2 特殊微服务模式





        callApi.setServerID(order.getCheckID());
        String thSnOrders = callApi.bodyApi("data/conversion", order.getDataOrder());
        LOGGER.info(" 微服务 " + order.getCheckID() + " " + order.getId() + " 响应 的 消息 是：   " + thSnOrders);
        long a = System.currentTimeMillis();
        ThSnOrder thSnOrder = null;
        try {
            thSnOrder = jsonMapper.readValue(thSnOrders, ThSnOrder.class);
        } catch (IOException e) {
            LOGGER.error(" 微服务 " + order.getCheckID() + " " + order.getId() + " 响应 数据转换类型 异常    数据是 " + thSnOrders, e);
            order.setRemark("  微服务响应 数据转换类型 " + thSnOrders);
            order.setIsSend(8);
            tOrder.save(order);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }


        //TODO  等待重构
        List<ThSnOrder> list = new ArrayList<>();
        list.add(thSnOrder);
        ResultBean resultBean;
        try {
            resultBean = feignServer.saveTask(list);
            LOGGER.info(" 响应时间 " + (System.currentTimeMillis() - a));

        } catch (Exception e) {
            LOGGER.error(" 微服务 " + order.getCheckID() + " " + order.getId() + "thoth 响应 数据转换类型 异常    数据是 " + thSnOrders, e);
            order.setRemark("  thoth 响应 数据转换类型 " + thSnOrders);
            order.setIsSend(6);
            // TODO 回填 客户单号   运单号
            tOrder.save(order);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        try {
            LOGGER.info(" 微服务 " + order.getCheckID() + " " + order.getId() + "  响应的数据  是：  " + jsonMapper.writeValueAsString(resultBean));
        } catch (JsonProcessingException e) {
            LOGGER.error(" 微服务 " + order.getCheckID() + " " + order.getId() + "   thoth   响应 数据转换类型 异常    数据是 " + thSnOrders, e);
            order.setRemark("  thoth响应 数据转换类型 ");
            order.setIsSend(7);
            // TODO 回填 客户单号   运单号  标准数据
            tOrder.save(order);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        return updateOrderState(order, resultBean);

    }


    /**
     * 修改mongodb 数据状态
     */
    private ConsumeConcurrentlyStatus updateOrderState(ThothOrder order, ResultBean resultBean) {
        if ("E".equals(
                resultBean.getStatus())) {
            order.setIsSend(9);
            order.setRemark("处理失败");
            // TODO 回填 客户单号   运单号 标准数据
            tOrder.save(order);
            LOGGER.info(" 微服务 " + order.getCheckID() + " " + order.getId() + "    处理失败 ");
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }

        if ("Y".equals(resultBean.getStatus()) || "UE".equals(resultBean.getStatus())) {
            order.setIsSend(1);
            order.setRemark("处理成功");
            // TODO 回填 客户单号   运单号 标准数据
            tOrder.save(order);
            LOGGER.info(" 微服务 " + order.getCheckID() + " " + order.getId() + "    处理成功 ");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }


}
