package com.jake.jdk.jdk8.stream.Lambda.Param_Return;

/**
 * 有参有返回值
 *
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午4:57
 * @company: 易宝支付(YeePay)
 */
public interface Interface_3 {

    public int run(String name);

}

class Test{
    public static void main(String[] args) {
        test((str)->{
            System.out.println(str + " Interface_1 Have Param No Return");
            if (str.equals("Tom")){
                return 1;
            }
            return 0;
        },"Tom");
    }

    public static void test(Interface_3 interface_3, String name){
        System.out.println("返回值 = "+interface_3.run(name));
    }
}
