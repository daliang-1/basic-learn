package com.jake.jdk.jdk8.stream.entity;

/**
 * 测试实体类
 * @author: chenliang.wang
 * @Date: 2018:09:10 上午10:20
 * @company: 易宝支付(YeePay)
 */
public class Product {

    private int id;

    private String type;

    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product(int id, String type, String value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
