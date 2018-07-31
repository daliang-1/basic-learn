package com.jake.reflect;

/**
 * @author: chenliang.wang
 * @Date: 2018年07月26日 PM2:02
 * @company: 易宝支付(YeePay)
 */
public class SubClassEntity extends ClassEntity {

    public String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private SubClassEntity() {
    }

    private SubClassEntity(String name){
        super.setName(name);
    }

    public SubClassEntity(String name, int age) {
        super(name, age);
    }
}
