package com.jake.jdk.jdk8.stream.Lambda.NoParam_NoReturn;

/**
 * 无参无返回值
 *
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午4:57
 * @company: 易宝支付(YeePay)
 */
public interface Interface_1 {

    public void run();

}

class Test{
    public static void main(String[] args) {
        test(()->{
            System.out.println("Interface_1 No Param No Return");
        });
    }

    public static void test(Interface_1 interface_1){
        interface_1.run();
    }
}
