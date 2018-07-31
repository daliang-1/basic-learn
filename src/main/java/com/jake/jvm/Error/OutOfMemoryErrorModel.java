package com.jake.jvm.Error;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 内存溢出Error: OutOfMemoryError(OOM)
 * 线程申请内存时,虚机无法再分配新的内存时,导致出现内存溢出
 *
 * @author: chenliang.wang
 * @Date: 2018年07月31日 PM3:18
 * @company: 易宝支付(YeePay)
 */
public class OutOfMemoryErrorModel {

    public static void main(String[] args) {
        List<Object> list = Lists.newArrayList();
        int num = 0;
        while (true) {
            // 无限制的新增数据量,线程无限制申请内存,导致内存溢出
            list.add(new byte[1024 * 1024]); // 每次新增1M大小的数据对象
            System.out.println(++num);
        }
    }
}
