package com.jake.jdk.jdk8.stream;

import com.google.common.collect.Lists;
import com.jake.jdk.jdk8.stream.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 基础练习
 *
 * @author: chenliang.wang
 * @Date: 2018:09:10 下午4:26
 * @company: 易宝支付(YeePay)
 */
public class BaseTest {

    List<String> list1 = Lists.newArrayList();
    List<Integer> list2 = Lists.newArrayList();
    List<Product> list3 = Lists.newArrayList();

    @Before
    public void init() {
        list1.add("a");
        list1.add("c");
        list1.add("B");
        list1.add("d");

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        for (int i = 0; i < 5; i++) {
            list3.add(new Product(i, i % 2 == 0 ? "化妆品" : "首饰", String.valueOf(new Random().nextInt(100))));
        }
    }

    /**
     * findFirst:输出Stream的第一个元素
     */
    @Test
    public void test9(){
        System.out.println(list3.stream().findFirst());
    }

    /**
     * allMatch
     * anyMatch
     * noneMatch
     */
    @Test
    public void test8() {
        System.out.println("allMatch = " + list2.stream().allMatch(integer -> integer > 0));
        System.out.println("anyMatch = " + list2.stream().anyMatch(integer -> integer > 2));
        System.out.println("noneMatch = " + list2.stream().noneMatch(integer -> integer > 3));
    }

    /**
     * min
     * max/distinct
     */
    @Test
    public void test7() throws FileNotFoundException {
        BufferedReader bf = new BufferedReader(new FileReader("/Users/Lucky/Desktop/code/my/jake/src/main/resources/text.txt"));
        // 最长行数长度
        System.out.println(bf.lines().mapToInt(String::length).max().getAsInt());
        System.out.println("===================");

        BufferedReader bf1 = new BufferedReader(new FileReader("/Users/Lucky/Desktop/code/my/jake/src/main/resources/text.txt"));
        // 输出所有行长度
        bf1.lines().mapToInt(String::length).distinct().forEach(System.out::println);

        // 找出全文的单词，转大写，并排序
        System.out.println("===================");
        BufferedReader bf2 = new BufferedReader(new FileReader("/Users/Lucky/Desktop/code/my/jake/src/main/resources/text.txt"));
        bf2.lines().flatMap(line -> Stream.of(line.split(" "))).filter(s -> s.length() > 0).map(s -> s.toUpperCase()).forEach(System.out::println);
    }

    /**
     * limit: 返回 Stream 的前面 n 个元素，含头含尾
     * skip: 则是扔掉前 n 个元素，含尾
     * sorted: 排序，顺序
     */
    @Test
    public void test6() {
        list2.stream().limit(3).skip(2).forEach(System.out::println);
        System.out.println(list3);
        // 先截取后排序
        list3.stream().limit(3).sorted((p1, p2) -> p1.getValue().compareTo(p2.getValue())).forEach(System.out::println);
        // 先排序后截取
        list3.stream().sorted((p1, p2) -> p1.getValue().compareTo(p2.getValue())).limit(3).forEach(System.out::println);
    }

    /**
     * forEach:循环
     */
    @Test
    public void test5() {
        list3.stream().forEach(product -> System.out.println(product.getValue()));
    }

    /**
     * filter:过滤
     */
    @Test
    public void test4() {
        System.out.println(list3);
        list3.stream().filter(product -> product.getType().equals("化妆品")).map(Product::getValue).forEach(System.out::println);
        System.out.println();
        list3.stream().filter(product -> product.getType().equals("化妆品")).forEach(product -> System.out.println(product.getValue()));
    }


    /**
     * map:用来做一些转换 or 逻辑运算操作
     * flatMap:把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字
     */
    @Test
    public void test3() {

        // map
        list1.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        list2.stream().map(s -> s * s).forEach(System.out::println);

        // flatMap
        Stream<List<Integer>> stream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5)
        );
        stream.flatMap(integers -> integers.stream()).forEach(System.out::println);
    }

    /**
     * 数流值的构造
     */
    @Test
    public void test2() {
        // 数值数组
        IntStream.of(1, 2, 3).forEach(System.out::println);
        // 含头不含尾
        IntStream.range(1, 5).forEach(System.out::println);
        // 含头又含尾
        IntStream.rangeClosed(1, 4).forEach(System.out::println);
    }

    /**
     * 流构造常见方式
     */
    @Test
    public void test1() {
        // 1)
        Stream stream = Stream.of("a", "b", "c");
        // 2)
        String[] strs = new String[]{"a", "b", "c"};
        stream = Stream.of(strs);
        // 3)
        stream = Arrays.stream(strs);
        // 4)
        List<String> list = Lists.newArrayList();
        stream = list.stream();
    }
}
