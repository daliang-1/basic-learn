package com.jake.collection.arraylist;

import com.google.common.collect.Lists;
import com.yeepay.g3.utils.common.json.JSONUtils;

import java.util.List;

/**
 * retailAll
 * <p>
 * boolean a.retailAll(b);
 * 理解1 : a和b集合取交集，并将交集结果赋值给a，a中数据有部分不存在于b则返回true，a中数据全存在于b返回false
 * 理解2 : 剔除a中不存在于b中数据，a中数据有部分不存在于b则返回true，a中数据全存在于b返回false
 *
 * @author: chenliang.wang
 * @Date: 2019:06:17 上午11:16
 * @company: 易宝支付(YeePay)
 */
public class RetailAll {

    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList();
        List<Integer> list2 = Lists.newArrayList();

        for (int i = 0; i < 4; i++) {
            list1.add(i);
            list2.add(i);
        }
        list1.add(5);

        list2.add(4);
        list2.add(6);

        // 原始
        System.out.println(JSONUtils.toJsonString(list1));
        System.out.println(JSONUtils.toJsonString(list2));
        // 批清处理
        System.out.println(list1.retainAll(list2));
        // 结果
        System.out.println(JSONUtils.toJsonString(list1));
        System.out.println(JSONUtils.toJsonString(list2));
    }
}
