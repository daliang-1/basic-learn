package com.jake.jdk.jdk8.key_word.default_;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:06 上午11:32
 * @company: 易宝支付(YeePay)
 */
public class DefaultInterfaceImpl implements DefaultInterface {

    @Override
    public void method() {
        System.out.println("method print in class...");
    }

    @Override
    public void test() {
        System.out.println("test print in class...");
    }

    public static void main(String[] args) {
        DefaultInterface defaultInterface = new DefaultInterfaceImpl();
        defaultInterface.test();
        defaultInterface.method();
        defaultInterface.inte();
    }
}

