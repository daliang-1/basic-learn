package com.jake.jvm.Transfer;

/**
 * 值传递
 * 基本数据类型全是值传递
 * byte/char/short/int/float/long/double/boolean
 *
 * @author: chenliang.wang
 * @Date: 2018年08月01日 AM10:35
 * @company: 易宝支付(YeePay)
 */
public class ValueTransfer {

    public static void main(String[] args) {
        int beginNum = 1;
        System.out.println("main beginNum = " + beginNum);
        changeValue(beginNum);
        System.out.println("main endNum = " + beginNum);
    }

    public static void changeValue(int num) {
        System.out.println("changeValue begin num = " + num);
        num = 10;
        System.out.println("changeValue end num = " + num);
    }
}
