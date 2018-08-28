package com.jake;

/**
 * @author: chenliang.wang
 * @Date: 2018年08月16日 下午5:40
 * @company: 易宝支付(YeePay)
 */
public class MyTest {

    private static int a = 1;
    private static Test test = new Test();

    static {
        System.out.println("static  a= "+ a);
        System.out.println("static come on");
    }

    public MyTest() {
        System.out.println("构造方法 a = "+a);
        System.out.println("构造方法 come on");
    }

    public static void test1(){
        System.out.println("test1 a = "+ a);
    }

    public static void main(String[] args) throws Exception {
        MyTest myTest = new MyTest();
        System.out.println("main come on");
    }
}

class Test{

    public Test() {
        System.out.println("test gouzao come on");
    }
}
