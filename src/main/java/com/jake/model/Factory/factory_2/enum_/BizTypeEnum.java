package com.jake.model.Factory.factory_2.enum_;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午3:23
 * @company: 易宝支付(YeePay)
 */
public enum BizTypeEnum {

    SAY_HELLO("Hello"),
    SAY_GOODBYE("GoodBye");


    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    BizTypeEnum(String desc) {
        this.desc = desc;
    }
}
