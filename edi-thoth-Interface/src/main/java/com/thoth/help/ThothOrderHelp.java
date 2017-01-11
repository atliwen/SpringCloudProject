package com.thoth.help;

import com.thoth.domain.ThSnOrder;
import org.springframework.util.StringUtils;

/**
 * @author 李文
 * @create 2017-01-11 10:53
 **/
public class ThothOrderHelp
{

    /**
     * 验证包裹完整  0 完整  1 不完整
     *
     * @param thSnOrder
     * @return
     */
    public static Integer verificationPagefull(ThSnOrder thSnOrder) {
        if (StringUtils.isEmpty(thSnOrder.getTotalpalnumber())
                || StringUtils.isEmpty(thSnOrder.getTotalweight())
                || StringUtils.isEmpty(thSnOrder.getCustomename())
                || StringUtils.isEmpty(thSnOrder.getMobilephone())
                || StringUtils.isEmpty(thSnOrder.getProvincename())
                || StringUtils.isEmpty(thSnOrder.getCityname())
                || StringUtils.isEmpty(thSnOrder.getCityname())
                || StringUtils.isEmpty(thSnOrder.getAreaname())
                || StringUtils.isEmpty(thSnOrder.getAreaname())
                || StringUtils.isEmpty(thSnOrder.getAdress())
                || StringUtils.isEmpty(thSnOrder.getWeakid())
                || StringUtils.isEmpty(thSnOrder.getAgentnumber())) {
            return 0;
        } else return 1;
    }


}
