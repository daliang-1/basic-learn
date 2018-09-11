package com.jake.jdk.jdk8.methodReference;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * JDK8-方法引用
 * <p>
 * 1)格式— 类名::方法名
 * <p>
 * 2)形式
 * 引用静态方法	ContainingClass::staticMethodName
 * 引用某个对象的实例方法	containingObject::instanceMethodName
 * 引用某个类型的任意对象的实例方法	ContainingType::methodName
 * 引用构造方法	ClassName::new
 * 3)
 *
 * @author: chenliang.wang
 * @Date: 2018:09:06 下午6:09
 * @company: 易宝支付(YeePay)
 */
public class MethodReferenceTest {

    List<Person> persons = new ArrayList<>();
    List<String> strs = new ArrayList<>();

    @Before
    public void init() {
        IntStream.range(1, 10).forEach(i -> {
            persons.add(new Person("name" + i, new Random().nextInt(100), "address" + i));
            strs.add(i % 2 == 0 ? "a" : "B");
        });
    }

    /**
     * 引用静态方法
     * 引用对象的实例方法
     */
    @Test
    public void test1() {
        persons.stream().sorted(Person::compareByAge).forEach(person -> System.out.println(person.toString()));
    }

    /**
     * 引用类型对象的实例方法
     */
    @Test
    public void test2(){
        strs.stream().sorted(String::compareToIgnoreCase).forEach(System.out::println);
    }

    /**
     * 引用构造方法
     */
    @Test
    public void test3(){

    }
}
