package com.jake.jvm.Object_load;

import java.util.Random;

/**
 * @author: chenliang.wang
 * @Date: 2018:08:21 上午10:45
 * @company: 易宝支付(YeePay)
 */
public class LoadModel {

    public static int a = 1;

    public static final int b = 0;

    public static final int c = new Random().nextInt(10);

    static {
        System.out.println("This is LoadModel static block init");
    }

    public LoadModel() {
        System.out.println("This is LoadModel constructor");
        a++;
    }

    public int getA() {
        return a;
    }
}
