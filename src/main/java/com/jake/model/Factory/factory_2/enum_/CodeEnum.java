package com.jake.model.Factory.factory_2.enum_;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午3:20
 * @company: 易宝支付(YeePay)
 */
public enum CodeEnum {

    CODE_1("CODE1"),
    CODE_2("CODE2");

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    CodeEnum(String desc) {
        this.desc = desc;
    }
}
