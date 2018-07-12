package com.jake.guava.Splitter;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;

import java.util.Map;

/**
 * Splitter
 *
 * @author: chenliang.wang
 * @Date: 2018年07月11日 PM5:54
 * @company: 易宝支付(YeePay)
 */
public class StringSplitter {

    private static final String COMMON = ",";
    private static final String EQUALS = "=";

    public static void main(String[] args) throws NoSuchMethodException {

        String str = "one,two,,,   three,four   ,five";
        String strMap = "a=one,b=two,,,c=three";

        /**
         * on
         */
        System.out.println("on:" + JSONObject.toJSONString(on(str)));

        /**
         * omitEmptyStrings
         */
        System.out.println("omitEmptyStrings:" + JSONObject.toJSONString(omitEmptyStrings(str)));

        /**
         * trimResults
         */
        System.out.println("trimResults:" + JSONObject.toJSONString(trimResults(str)));

        /**
         * limit
         */
        System.out.println("limit:" + JSONObject.toJSONString(limit(str, 3)));

        /**
         * withKeyValueSeparator
         */
        System.out.println("withKeyValueSeparator:" + JSONObject.toJSONString(withKeyValueSeparator(strMap)));
    }

    public static Iterable on(String str) {
        return Splitter.on(COMMON).split(str);
    }

    public static Iterable omitEmptyStrings(String str) {
        return Splitter.on(COMMON).omitEmptyStrings().split(str);
    }

    public static Iterable trimResults(String str) {
        return Splitter.on(COMMON).omitEmptyStrings().trimResults().split(str);
    }

    public static Iterable limit(String str, int limit) {
        return Splitter.on(COMMON).omitEmptyStrings().limit(limit).trimResults().split(str);
    }

    public static Map withKeyValueSeparator(String str) {
        return Splitter.on(COMMON).omitEmptyStrings().withKeyValueSeparator(EQUALS).split(str);
    }
}