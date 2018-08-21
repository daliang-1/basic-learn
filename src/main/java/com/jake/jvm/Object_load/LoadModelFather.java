package com.jake.jvm.Object_load;

/**
 * @author: chenliang.wang
 * @Date: 2018年08月09日 PM6:12
 * @company: 易宝支付(YeePay)
 */
public class LoadModelFather {

    // 成员1
//    public static LoadModelFather loadModelFather = new LoadModelFather();
//    public static int a;
//    public static int b = 0;
//    public static final int c = 1;

    // 成员2
    public static int a;
    public static int b = 0;
    public static final int c = 0;
    public static LoadModelFather loadModelFather = new LoadModelFather();

    static {
        System.out.println("This is LoadModelFather init");
    }

    public LoadModelFather() {
        a++;
        b++;
    }
}
