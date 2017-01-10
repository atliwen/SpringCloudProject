package com.thoth.web;

import com.thoth.Interface.webapi.OrderApiInterface;
import com.thoth.domain.RequestData;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: OrderController </p>
 * <p>@Description: webapi 项目   客户B  OrderApi 接口方法实现类 </p>
 * <p>Company:  </p>
 *
 * @author 李文
 * @date 2016年9月19日 下午3:39:38
 */
@RestController
public class OrderController implements OrderApiInterface
{
    /**
     * 成功 数据响应
     *
     * @param body
     * @return
     */
    @Override
    public String success(RequestData body) {
        // 成功 数据响应
        return "成功";
    }
    /**
     * 失败 数据响应
     * @param state  0 是  数据验证失败   1 是  基础数据 验证
     * @param body
     * @return
     */
    @Override
    public String failure(Integer state, RequestData body) {
        return "失败";
    }
    /**
     * 验证数据
     *        对客户数据的校验
     *
     * @param body
     * @return ok 是成功  否则 都是失败
     */
    @Override
    public String check(RequestData body) {
        // 验证数据 ok 是成功 否则 都是失败
        return "ok";
    }
    /**
     *  基础数据 验证
     *      对用户数据做基础数据验证  确保接收到的数据满足最低标准处理
     *
     * @param body
     * @return
     */
    @Override
    public String dataVerification(RequestData body) {
        // 基础数据验证 ok 是成功 否则 都是失败
        return "ok";
    }

    /**
     * 数据转换方法
     *        数据存在特殊情况下 需要添加特殊逻辑的时候  人工编写转换方法
     * @param body
     * @return
     */
    @Override
    public String dataConversion(RequestData body) {
        return null;
    }

}