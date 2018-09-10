package com.jake.jdk.jdk8.stream;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional练习
 * @author: chenliang.wang
 * @Date: 2018:09:10 下午5:03
 * @company: 易宝支付(YeePay)
 */
public class OptionalTest {

    public static void main(String[] args) {
        String a = "123";
        String b = "";
        String c = null;

        System.out.println(Optional.ofNullable(a).isPresent());
        System.out.println(Optional.ofNullable(b).isPresent());
        System.out.println(Optional.ofNullable(c).isPresent());

        System.out.println(Optional.of(a).isPresent());
        System.out.println(Optional.of(b).isPresent());
        // NPE
//        System.out.println(Optional.of(c).isPresent());

        Optional.ofNullable(a).ifPresent(s -> System.out.println(s + "ceshi"));
        Optional.ofNullable(b).ifPresent(s -> System.out.println(s + "ceshi"));
        Optional.ofNullable(c).ifPresent(s -> System.out.println(s + "ceshi"));
    }

    /**
     * Optional例子
     */
    @Test
    public void test4(){
        String strA = " 123 ";
        String strB = null;
        print(strA);
        print("");
        print(strB);
        System.out.println(getLength(strA));
        System.out.println(getLength(""));
        System.out.println(getLength(strB));
    }

    private int getLength(String str) {
        return Optional.ofNullable(str).map(s -> s.length()).orElse(-1);
    }

    private void print(String str) {
        Optional.ofNullable(str).ifPresent(System.out::println);
    }

}
