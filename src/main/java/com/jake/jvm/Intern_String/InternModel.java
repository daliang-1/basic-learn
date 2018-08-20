package com.jake.jvm.Intern_String;

/**
 * Intern
 *
 *      String.intern()作用:
 *                          首先查看常量池是否有字符串,如果有直接返回常量池中字符串的引用;
 *                          否则在常量池添加该字符串在堆区的引用,并返回堆引用;
 *
 * 问题1:
 *      String 拼接注意事项?
 * 问题2:
 *      String 拼接底层实现?
 *
 * @author: chenliang.wang
 * @Date: 2018年08月03日 PM4:36
 * @company: 易宝支付(YeePay)
 */
public class InternModel {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();

    }

    public static void test1(){
        /**
         * 1.在栈中创建变量b
         * 2.在堆中创建String对象(值为"123"),检查常量池是否已创建"123",发现没有则在常量池(堆)中创建"123"(捎带创建的)
         * 3.最终关系  b(String对象引用) -> String对象
         */
        String b = new String("123");
        /**
         * 1.在栈中创建变量a
         * 2.在常量池(堆)中查找是否有"123",发现常量池已经有,则直接赋给变量a对应常量引用
         * 3.最终关系 a -> 常量池(堆)中"123"的引用
         */
        String a = "123";
        System.out.println(a == b); // 对应引用和常量引用对比
        System.out.println(a.intern() == b.intern()); // a.intern()返回常量池引用,b.intern()返回常量池引用
    }

    public static void test2(){
        /**
         * 1.在栈中创建变量a
         * 2.在常量池(堆)中查找是否有"123",发现常量池没有,则在常量池创建"123",并返回引用给变量a
         * 3.最终关系 a -> 常量池(堆)中"123"的引用
         */
        String a = "123";
        /**
         * 1.在栈中创建变量b
         * 2.在堆中创建String对象(值为"123"),检查常量池是否已创建"123",发现有则不做任何操作
         * 3.最终关系  b(String对象引用) -> String对象
         */
        String b = new String("123");
        System.out.println(a == b); // 常量池地址与堆内存地址对比
        System.out.println(a.intern() == b.intern()); // a.intern()返回常量池引用,b.intern()返回常量池引用
    }

    public static void test3(){
        /**
         * 1.在栈中创建变量a
         * 2.在常量池(堆)中查找是否有"123",发现常量池没有,则在常量池创建"123",并返回引用给变量a
         * 3.最终关系 a -> 常量池(堆)中"123"的引用
         */
        String a = "123";
        /**
         * 1.在栈中创建变量b
         * 2.在常量池(堆)中查找是否有"123",发现常量池没有,则在常量池创建"123",并返回引用给变量a
         * 3.最终关系 a -> 常量池(堆)中"123"的引用
         */
        String b = "1"+"23";
        System.out.println(a == b); // 常量池地址与常量池地址对比
        System.out.println(a.intern() == b.intern()); // 常量池地址与常量池地址对比
    }

    public static void test4(){
        /**
         * 1.在栈中创建变量a
         * 2.在常量池(堆)中查找是否有"123",发现常量池没有,则在常量池创建"123",并返回引用给变量a
         * 3.最终关系 a -> 常量池(堆)中"123"的引用
         */
        String a = "123";
        /**
         * 1.在栈中创建变量b
         * 2.在堆中创建String对象(值为"123"),不会尝试去常量池创建"123"
         * 3.最终关系  b(String对象引用) -> String对象
         */
        String b = new String("1")+new String("23");
        System.out.println(a == b); // 常量池地址与堆内存地址对比
        System.out.println(a == b.intern()); // 常量池地址与常量池地址对比
    }

    /**
     * b:在堆内存创建"123"对象,b不会在常量池创建"123"
     * a:在常量池创建"123"
     */
    public static void test5(){
        /**
         * 1.在栈中创建变量b
         * 2.在堆中创建String对象(值为"123"),不会尝试去常量池创建"123"
         * 3.最终关系  b(String对象引用) -> String对象
         */
        String b = new String("1")+new String("23");
        /**
         * 1.在栈中创建变量a
         * 2.在常量池(堆)中查找是否有"123",发现常量池没有,则在常量池创建"123",并返回引用给变量a
         * 3.最终关系 a -> 常量池(堆)中"123"的引用
         */
        String a = "123";

        b.intern();

        System.out.println(a == b); // 常量池地址与堆内存地址对比
        System.out.println(a == b.intern()); // 常量池地址与常量池地址对比
    }

    public static void test6(){
        /**
         * 1.在栈中创建变量b
         * 2.在堆中创建String对象(值为"123"),不会尝试去常量池创建"123"
         * 3.最终关系  b(String对象引用) -> String对象
         */
        String b = new String("1")+new String("23");

        b.intern(); // 去常量池查看是否存在"123",发现没有就将b在堆内存中的地址赋给"123";

        /**
         * 1.在栈中创建变量a
         * 2.在常量池(堆)中查找是否有"123",发现常量池没有,则在常量池创建"123",并返回引用给变量a
         * 3.最终关系 a -> 常量池(堆)中"123"的引用
         */
        String a = "123";
        System.out.println(a == b); // 堆内存地址与堆内存地址对比
        System.out.println(a == b.intern()); // 堆内存地址与堆内存地址对比
    }


    /**
     * 回答
     * 问题1:
     *      字面量拼接
     *          String a = "1" + "23";  编译期会先拼接然后直接在常量池创建对象
     *      字符串变量拼接
     *          1)String a = "1" + new String("23");
     *          2)String a = "1" + new String("23");
     *          3)String a = "1";
     *            String b = a + "23";
     *          4)String a = "1";
     *            String b = a + new String("23");
     *
     *          字符串变量拼接,编译期会被转化成StringBuilder的append操作,最后执行StringBuilder的toString()方法,
     *          变量最终指向Java堆上新建String对象
     *
     * 问题2:
     *      首先字符串拼接,区分字面量拼接和字符串变量拼接
     *
     *          1)字面量拼接,编译期会先拼接然后直接在常量池创建对象
     *
     *          2)字符串变量拼接,编译期会被转化成StringBuilder的append操作,最后执行StringBuilder的toString()方法,
     *            变量最终指向Java堆上新建String对象
     */
}
