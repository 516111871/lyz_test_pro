package com.demo.check.IService.impl;

import com.demo.check.IService.ICheck;
import com.demo.common.untils.AjaxResult;

public class Share implements ICheck {
    @Override
    public AjaxResult addIntegral(Integer integral) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setMsg("分享加积分"+integral);
        return result;
    }
}
