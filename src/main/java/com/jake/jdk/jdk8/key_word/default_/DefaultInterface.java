package com.jake.jdk.jdk8.key_word.default_;

/**
 * default关键字-JDK8新特性
 *  1）default修饰时，接口中函数可以有函数体
 *  2）子类也可重写对应default修饰的函数，执行时调用子类重新方法。
 *
 *
 * @author: chenliang.wang
 * @Date: 2018:09:06 上午11:31
 * @company: 易宝支付(YeePay)
 */
public interface DefaultInterface {

    void method();

    default void test(){
        System.out.println("test print in interface...");
    }

    default void inte(){
        System.out.println("inte print in interface...");
    }

}
