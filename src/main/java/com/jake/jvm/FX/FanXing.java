package com.jake.jvm.FX;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 泛型-参数化类型
 *
 * @author: chenliang.wang
 * @Date: 2019:06:17 下午2:32
 * @company: 易宝支付(YeePay)
 */
public class FanXing {

    public static void main(String[] args) {
        // 数组协变
//        arrayError();

        // 泛型类-指定类型
//        classTest();
        // 泛型类-不指定类型
//        class2Test();

        // 泛型接口-实现类不指定类型
//        interface1();
        // 泛型接口-实现类指定类型
        interface2();

        // 同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的
        compatible();

        // 泛型通配符?
//        wildcard();
    }

    /**
     * 数组是协变的
     * List底层实现为数组,所以该例编译时不会报错,运行时会报ClassCastException(类型转换异常)
     */
    public static void arrayError() {
        List list = Lists.newArrayList();
        list.add("1");
        list.add(2);
        for (Object o : list) {
            System.out.println((String) o);
        }
    }

    public static void classTest() {
        Generic<String> stringGeneric = new Generic<>("stringGeneric");
        Generic<Integer> integerGeneric = new Generic<>(123);
//        stringGeneric.setKey(123); // 该情况会报错,构造方法已经指定泛型类型为String
//        integerGeneric.setKey("name"); // 该情况会报错,构造方法已经指定泛型类型为String
        System.out.println("stringGeneric = " + stringGeneric.getKey());
        System.out.println("integerGeneric = " + integerGeneric.getKey());
    }

    public static void class2Test() {
        Generic generic1 = new Generic("123");
        Generic generic2 = new Generic(456);
        Generic generic3 = new Generic(false);
        Generic generic4 = new Generic(789f);
        System.out.println("generic1 = " + generic1.getKey());
        System.out.println("generic2 = " + generic2.getKey());
        System.out.println("generic3 = " + generic3.getKey());
        System.out.println("generic4 = " + generic4.getKey());
    }

    public static void interface1() {
        // 正确
//        FXInterface fxInterface = new FXClass("jake");
        FXInterface<String> fxInterface = new FXClass<>("jake");

        // 错误-数据必须和指定类型一致
//        FXInterface<Integer> fxInterface = new FXClass<Integer>("jake");

        System.out.println(fxInterface.get());
    }

    private static void interface2() {
        FXInterface fxInterface = new FXClass2("jake2");
        System.out.println(fxInterface.get());
    }

    private static void compatible() {
        FXInterface<Number> fxClass = new FXClass<>(1);
        FXInterface<Integer> fxClass1 = new FXClass<>(100);
        showKey(fxClass);
//        showKey(fxClass1); // 同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的
    }
    public static void showKey(FXInterface<Number> fxClass) {
        System.out.println("showKey = " + fxClass.get());
    }

}

