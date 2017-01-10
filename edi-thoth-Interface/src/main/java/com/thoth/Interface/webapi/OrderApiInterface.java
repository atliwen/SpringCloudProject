package com.thoth.Interface.webapi;

import com.thoth.domain.RequestData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Title: OrderApiInterface </p>
 * <p>@Description: webapi 项目 OrderApi 接口方法 </p>
 * <p>Company:  </p>
 *
 * @author 李文
 * @date 2016年9月19日 下午3:38:17
 */
public interface OrderApiInterface
{
    /**
     * 成功 数据响应
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "success", method = RequestMethod.POST)
    String success(@RequestBody RequestData body);

    /**
     * 失败 数据响应    0 是  数据验证失败   1 是  基础数据 验证
     * @param state
     * @param body
     * @return
     */
    @RequestMapping(value = "failure/{state}", method = RequestMethod.POST)
    String failure(@PathVariable("state") Integer state, @RequestBody RequestData body);

    /**
     * 验证数据
     *        对客户数据的校验
     *
     * @param body
     * @return ok 是成功  否则 都是失败
     */
    @RequestMapping(value = "Check", method = RequestMethod.POST)
    String check(@RequestBody RequestData body);


    /**
     *  基础数据 验证
     *      对用户数据做基础数据验证  确保接收到的数据满足最低标准处理
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "data/verification", method = RequestMethod.POST)
    String dataVerification(@RequestBody RequestData body);

    /**
     * 数据转换方法
     *        数据存在特殊情况下 需要添加特殊逻辑的时候  人工编写转换方法
     * @param body
     * @return
     */
    @RequestMapping(value = "data/conversion", method = RequestMethod.POST)
    String dataConversion(@RequestBody RequestData body);






}
