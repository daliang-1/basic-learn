package com.jake.jdk.jdk8.stream.Lambda;

/**
 * Lambda表达式—函数式编程(匿名内部类的传递)
 *
 * 1.在JDK8之前,Java是不支持函数式编程的,所谓的函数编程,即可理解是将一个函数(也称为"行为")作为一个参数进行传递。
 *   通常我们提及得更多的是面向对象编程,面向对象编程是对数据的抽象(各种各样的POJO类),而函数式编程则是对行为的抽象(将行为作为一个参数进行传递)。
 *
 * 2.什么场景可以使用Lambda表达式?
 *   只包含一个函数(abstract)的接口—"函数接口"。
 *
 *   注意点：
 *
 *      **** 默认方法(default修饰)、静态方法(static修饰)、重写顶级父级方法 不会破坏函数式接口的定义
 *
 * 3.Lambda表达式格式
 *   无参
 *   () -> System.out.println("hello");
 *   () -> {
 *      System.out.println("hello")
 *    };
 *
 *   有参
 *   (str) -> System.out.println("hello");
 *   (str) -> {
 *      System.out.println("hello")
 *    };
 *
 *
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午4:21
 * @company: 易宝支付(YeePay)
 */
public class LambdaModel {

    public static void main(String[] args) {
//        before();
        now();
    }

    /**
     * jdk8之前
     */
    public static void before(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("jdk8 before");
            }
        }).start();
    }

    /**
     * jdk8之后
     */
    public static void now(){
        new Thread(()-> System.out.println("jdk8 now 不带大括号")).start();
//        new Thread(()->{System.out.println("jdk8 now 带大括号");}).start();
    }
}
