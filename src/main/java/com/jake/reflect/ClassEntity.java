package com.jake.reflect;

/**
 * @author: chenliang.wang
 * @Date: 2018年07月26日 PM1:56
 * @company: 易宝支付(YeePay)
 */
public class ClassEntity {

    private String name;
    private int age;

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

    public void setNameAndAge(String name ,int age){
        this.name = name;
        this.age = age;
    }

    public ClassEntity() {
    }

    public ClassEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
