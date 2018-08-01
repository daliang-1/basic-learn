package com.jake.jvm.Transfer;

/**
 * @author: chenliang.wang
 * @Date: 2018年08月01日 AM10:58
 * @company: 易宝支付(YeePay)
 */
public class TransferEntity {

    public String name;

    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TransferEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
