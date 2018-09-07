package com.jake.jdk.jdk8.lambda.Param_Return;

/**
 * 有参有返回值
 * 1)如果主体没有大括号只有一个表达式返回值，则编译器会自动返回
 * 2)如果主体有大括号，则需要指定return返回数值
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

        // 主体有大括号
//        test((str)->{
//            System.out.println(str + " Interface_1 Have Param No Return");
//            if (str.equals("Tom")){
//                return 1;
//            }
//            return 0;
//        },"Tom");

        // 主体没有大括号
        test(str -> 1,"TOM");
    }

    public static void test(Interface_3 interface_3, String name){
        System.out.println("返回值 = "+interface_3.run(name));
    }
}
