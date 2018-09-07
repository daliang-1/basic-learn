package com.jake.jdk.jdk8.lambda.Param_NoReturn;

/**
 * 有参无返回值
 *
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午4:57
 * @company: 易宝支付(YeePay)
 */
public interface Interface_2 {

    public void run(String name);

}

class Test{
    public static void main(String[] args) {
        test((str)->{
            System.out.println(str + " Interface_1 Have Param No Return");
        },"Tom");
    }

    public static void test(Interface_2 interface_2,String name){
        interface_2.run(name);
    }
}
