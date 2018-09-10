package com.jake.jdk.jdk8.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 基础练习
 * @author: chenliang.wang
 * @Date: 2018:09:10 下午4:26
 * @company: 易宝支付(YeePay)
 */
public class BaseTest {

    /**
     * 一对多
     */
    @Test
    public void test3(){
        Stream<List<Integer>> stream = Stream.of(
            Arrays.asList(1),
            Arrays.asList(2,3),
            Arrays.asList(4,5)
        );
        stream.flatMap(integers -> integers.stream()).forEach(System.out::println);
    }

    /**
     * 数流值的构造
     */
    @Test
    public void test2(){
        // 数值数组
        IntStream.of(1,2,3).forEach(System.out::println);
        // 含头不含尾
        IntStream.range(1,5).forEach(System.out::println);
        // 含头又含尾
        IntStream.rangeClosed(1,4).forEach(System.out::println);
    }

    /**
     * 流构造常见方式
     */
    @Test
    public void test1(){
        // 1)
        Stream stream = Stream.of("a","b","c");
        // 2)
        String[] strs = new String[]{"a","b","c"};
        stream = Stream.of(strs);
        // 3)
        stream = Arrays.stream(strs);
        // 4)
        List<String> list = Lists.newArrayList();
        stream = list.stream();
    }
}
