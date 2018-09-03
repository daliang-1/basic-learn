package com.jake.model.Factory.factory_1.enum_;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午2:12
 * @company: 易宝支付(YeePay)
 */
public enum ProgressType {

    SAY_HELLO("sayHelloProgress"),
    GOOD_BYE("sayGoodByeProgress");

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ProgressType(String desc) {
        this.desc = desc;
    }
}
