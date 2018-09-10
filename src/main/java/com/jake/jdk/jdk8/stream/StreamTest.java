package com.jake.jdk.jdk8.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Stream
 *
 * @author: chenliang.wang
 * @Date: 2018:09:07 下午5:41
 * @company: 易宝支付(YeePay)
 */
public class StreamTest {


    /**
     * 发现 type 为 化妆品 的所有产品，然后返回以 value 降序排序好的交易 id 集合
     */
    @Test
    public void test2_8(){
        List<Product> list = new ArrayList();
        Random random = new Random();
        for (int i = 1; i < 100; i++) {
            list.add(new Product(i,i % 2 ==0 ? "化妆品" : "服装",String.valueOf(random.nextInt(100))));
        }

        List<Integer> ids = list.stream().filter(product -> product.getType()
                .equals("化妆品"))
                .sorted(comparing(Product::getValue).reversed())
                .map(Product::getId)
                .collect(toList());
        System.out.println(ids);
    }

    /**
     * 发现 type 为 化妆品 的所有产品，然后返回以 value 降序排序好的交易 id 集合
     */
    @Test
    public void test2_7(){
        List<Product> list = new ArrayList();
        Random random = new Random();
        for (int i = 1; i < 100; i++) {
            list.add(new Product(i,i % 2 ==0 ? "化妆品" : "服装",String.valueOf(random.nextInt(100))));
        }

        List<Product> products = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType().equals("化妆品")){
                products.add(list.get(i));
            }
        }
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = products.size() - 1; i >= 0; i--) {
            System.out.println("Value = "+products.get(i).getValue());
            System.out.println("ID = " + products.get(i).getId());
        }
    }


    /**
     * jdk8
     */
    @Test
    public void test1_8() {
        System.out.println("==========Java 7===========");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("列表: " + strings);

        // 计算空字符串个数
        System.out.println("Java8 emptyCount = " + strings.stream().filter(s -> s.isEmpty()).count());

        // 计算字符串长度=3个数
        System.out.println("Java8 3LengthCount = " + strings.stream().filter(s -> s.length() == 3).count());

        // 删除空字符串
        System.out.println("Java8 deleteEmptyString = " + strings.stream().filter(s -> !s.isEmpty()).collect(toList()));

        // 删除空字符串，并使用逗号把它们合并起来
        System.out.println("Java8 getMergedStringUsingJava8 = " +strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(",")));


        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        // 获取列表元素平方数列表
        System.out.println("Java8 getSquares = " + numbers.stream().map(number -> number * number).distinct().collect(toList()));


        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

        System.out.println("Java8 列表: " +integers);
        System.out.println("Java8 列表中最大的数 : " + integers.stream().mapToInt(i -> i).summaryStatistics().getMax());
        System.out.println("Java8 列表中最小的数 : " + integers.stream().mapToInt(Integer::intValue).summaryStatistics().getMin());
        System.out.println("Java8 所有数之和 : " + integers.stream().mapToInt(Integer::intValue).summaryStatistics().getSum());
        System.out.println("Java8 平均数 : " + integers.stream().mapToInt(Integer::intValue).summaryStatistics().getAverage());
    }
    /**
     * jdk7
     */
    @Test
    public void test1_7() {
        System.out.println("==========Java 7===========");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("列表: " + strings);

        // 计算空字符串个数
        System.out.println("Java7 emptyCount = " + getCountEmptyStringUsingJava7(strings));

        // 计算字符串长度=3个数
        System.out.println("Java7 3LengthCount = " + get3LengthStringUsingJava7(strings));

        // 删除空字符串
        System.out.println("Java7 deleteEmptyString = " + deleteEmptyStringUsingJava7(strings));

        // 删除空字符串，并使用逗号把它们合并起来
        System.out.println("Java7 getMergedStringUsingJava7 = " + getMergedStringUsingJava7(strings));


        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        // 获取列表元素平方数列表
        System.out.println("Java7 getSquares = " + getSquares(numbers));


        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

        System.out.println("Java7 列表: " +integers);
        System.out.println("Java7 列表中最大的数 : " + getMax(integers));
        System.out.println("Java7 列表中最小的数 : " + getMin(integers));
        System.out.println("Java7 所有数之和 : " + getSum(integers));
        System.out.println("Java7 平均数 : " + getAverage(integers));
    }

    private Integer getMax(List<Integer> integers) {
        Integer max = integers.get(0);
        for (Integer integer : integers) {
            if (integer > max){
                max = integer;
            }
        }
        return max;
    }
    private Integer getMin(List<Integer> integers) {
        Integer max = integers.get(0);
        for (Integer integer : integers) {
            if (integer < max){
                max = integer;
            }
        }
        return max;
    }
    private Integer getSum(List<Integer> integers) {
        Integer max = 0;
        for (Integer integer : integers) {
            max = max + integer;
        }
        return max;
    }
    private Integer getAverage(List<Integer> integers) {
        return getSum(integers) / integers.size();
    }

    private List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> list = Lists.newArrayList();
        for (Integer number : numbers) {
            int num = number * number;
            if (!list.contains(num)){
                list.add(num);
            }
        }
        return list;
    }

    private String getMergedStringUsingJava7(List<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            if (!str.isEmpty()){
                stringBuilder.append(str).append(",");
            }
        }
        return stringBuilder.toString().substring(0,stringBuilder.toString().length()-1);
    }

    private List<String> deleteEmptyStringUsingJava7(List<String> strings) {
        List<String> list = Lists.newArrayList();
        for (String str : strings) {
            if (!str.isEmpty()){
                list.add(str);
            }
        }
        return list;
    }

    private long get3LengthStringUsingJava7(List<String> strings) {
        long count = 0;
        for (String str : strings) {
            if (str.length() == 3) {
                count++;
            }
        }
        return count;
    }

    public long getCountEmptyStringUsingJava7(List<String> strings) {
        long count = 0;
        for (String str : strings) {
            if (str.isEmpty()) {
                count++;
            }
        }
        return count;
    }


}
