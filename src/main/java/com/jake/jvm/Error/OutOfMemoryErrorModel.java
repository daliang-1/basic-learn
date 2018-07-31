package com.jake.jvm.Error;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 内存溢出Error
 *
 * @author: chenliang.wang
 * @Date: 2018年07月31日 PM3:18
 * @company: 易宝支付(YeePay)
 */
public class OutOfMemoryErrorModel {

    public static void main(String[] args) {
        List<Object> list = Lists.newArrayList();
        while(true){
            list.add(new int[1000000]);
        }
    }
}
