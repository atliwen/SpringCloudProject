package com.thoth.Interface.webapi;

import com.thoth.domain.RequestData;
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
     * 失败 数据响应
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "failure", method = RequestMethod.POST)
    String failure(@RequestBody RequestData body);

    /**
     * 验证数据
     *
     * @param body
     * @return ok 是成功  否则 都是失败
     */
    @RequestMapping(value = "Check", method = RequestMethod.POST)
    String check(@RequestBody RequestData body);

    /**
     * 验证失败数据响应
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "Check/failure", method = RequestMethod.POST)
    String checkfailure(@RequestBody RequestData body);


    /**
     * 数据转换方法
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "data/conversion", method = RequestMethod.POST)
    String dataConversion(@RequestBody RequestData body);

}
