package com.edi.thoth.service;

import com.edi.thoth.domain.ClientUsers;
import com.edi.thoth.service.mongodb.ThothOrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoth.domain.RequestData;
import com.thoth.domain.ThothOrder;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 数据保存类
 *
 * @author 李文
 * @create 2017-01-09 15:55
 **/
@Service
public class DataSaveServcie
{

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSaveServcie.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Value("${Topic}")
    private String Topic;

    @Value("${Tags}")
    private String Tags;
    @Autowired
    private ThothOrderRepository tOrder;

    @Autowired
    private MqProducer mq;

    /**
     * 保存数据并生产消息
     *
     * @param user
     * @return
     */
    public void saveDate(RequestData requestData, ClientUsers user) throws Exception {
        try {

            // 保存数据
            // 这里只做数据 记录
            //  如后期 有日志管理  这里可以取消
            ThothOrder thothOrder = new ThothOrder();
            thothOrder.setId(ObjectId.get().toString());
            thothOrder.setClientFlag(user.getClientFlag());
            thothOrder.setDataOrder(requestData);
            thothOrder.setIsSend(0);
            thothOrder.setCheckID(user.getCheckID());
            thothOrder.setRemark("接收数据成功");
            thothOrder.setVerifyData(user.getVerifyData());
            tOrder.save(thothOrder);
            // 添加MQ
            mq.send(Topic, Tags, OBJECT_MAPPER.writeValueAsString(thothOrder));

        } catch (Exception e) {
            LOGGER.error(" 保存数据 失败 ", e);
            throw new Exception("  保存数据 失败 " + e.getMessage());
        }
    }

}
