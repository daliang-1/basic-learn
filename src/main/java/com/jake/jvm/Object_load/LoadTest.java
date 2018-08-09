package com.jake.jvm.Object_load;

/**
 * 类加载机制
 *
 * 问题1:
 *      类的加载机制了解么,主要有哪些过程?
 * 问题2:
 *      static final 修饰的成员变量，在类加载时有什么注意点？
 *
 * @author: chenliang.wang
 * @Date: 2018年08月09日 PM6:22
 * @company: 易宝支付(YeePay)
 */
public class LoadTest {

    public static void main(String[] args) {
//        show_one();
//        show_two();
        staticFinal();
    }


    /**
     * static final 修饰的成员变量不进行初始化
     * 体现:static代码块未执行
     */
    public static void staticFinal(){
        System.out.println(LoadModelFather.c);
    }

    /**
     * 成员1
     */
    public static void show_one(){
        System.out.println(LoadModelFather.a);
        System.out.println(LoadModelFather.b);
        System.out.println(LoadModelFather.c);
    }

    /**
     * 成员2
     */
    public static void show_two(){
        System.out.println(LoadModelFather.a);
        System.out.println(LoadModelFather.b);
        System.out.println(LoadModelFather.c);
    }



    /**
     * 回答
     *      问题1:
     *      1、加载：
     *          类加载指的是将类的class文件读入内存，并为之创建一个java.lang.*Class对象，作为方法区这个类的数据访问的入口。
     *          也就是说，当程序中使用任何类时，系统都会为之建立一个java.lang.*Class对象。具体包括以下三个部分：
     *              1)通过类的全名产生对应类的二进制数据流。（根据early_load原理，如果没找到对应的类文件，只有在类实际使用时才会抛出错误）
     *              2)分析并将这些二进制数据流转换为方法区方法区特定的数据结构
     *              3)创建对应类的java.lang.Class对象，作为方法区的入口（有了对应的Class对象，并不意味着这个类已经完成了加载链接）
     *
     *          通过使用不同的类加载器，可以从不同来源加载类的二进制数据，通常有如下几种来源：
     *              1)从本地文件系统加载class文件，这是绝大部分程序的加载方式
     *              2)从jar包中加载class文件，这种方式也很常见，例如jdbc编程时用到的数据库驱动类就是放在jar包中，jvm可以从jar文件中直接加载该class文件
     *              3)通过网络加载class文件
     *              4把一个Java源文件动态编译、并执行加载
     *
     *      2、链接：
     *          链接指的是将Java类的二进制文件合并到jvm的运行状态之中的过程。在链接之前，这个类必须被成功加载。
     *          类的链接包括验证、准备、解析这三步。具体描述如下：
     *
     *          2.1 验证：
     *              验证是用来确保Java类的二进制表示在结构上是否完全正确（如文件格式、语法语义等）。如果验证过程出错的话，会抛出java.lang.VertifyError错误。
     *              主要验证以下内容：
     *                  文件格式验证
     *                  元数据验证：语义验证
     *                  字节码验证
     *          2.2 准备：
     *              准备过程则是创建Java类中的静态域（static修饰的内容），并将这些域的值设置为默认值，同时在方法区中分配内存空间。准备过程并不会执行代码。
     *                  注意这里是做默认初始化，不是做显式初始化。例如：
     *                  public static int value = 12;
     *                  上面的代码中，在准备阶段，会给value的值设置为0（默认初始化）。在后面的初始化阶段才会给value的值设置为12（显式初始化）。
     *
     *          2.3 解析：
     *              解析的过程就是确保这些被引用的类能被正确的找到（将符号引用替换为直接引用）。解析的过程*可能会导致其它的Java类被加载。
     *
     *      3、初始化(显示初始化)：
     *          初始化阶段是类加载过程的最后一步。到了初始化阶段，才真正执行类中定义的Java程序代码（或者说是字节码）。
     *
     *          在以下几种情况中，会执行初始化过程：
     *          1)创建类的实例
     *          2)访问类或接口的静态变量（特例：如果是用static *final修饰的常量，那就不会对类进行显式初始化。static final 修改的变量则会做显式初始化）
     *          3)调用类的静态方法
     *          4)反射（Class.forName(packagename.className)）
     *          5)初始化类的子类。注：子类初始化问题：满足主动调用，即父类访问子类中的静态变量、方法，子类才会初始化；否则仅父类初始化。
     *          6)java虚拟机启动时被标明为启动类的类
     *
     *     问题2:
     *          static final 修饰的成员变量不进行初始化
     */
}
