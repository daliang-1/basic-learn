package com.jake.jvm.Object_load;

/**
 * 类加载机制
 *
 * 问题1:
 *      类的加载机制了解么,主要有哪些过程?
 * 问题2:
 *      static final 修饰的成员变量，在类加载时有什么注意点？
 * 问题3：
 *      什么事ConstantValue属性？
 * 问题4:
 *      static 修饰的变量赋值方式?
 * 问题5:
 *      为什么ConstantValue的属性值只限于基本类型和string？
 * 问题6:
 *      final、static、static final修饰的字段赋值的区别?
 *
 * @author: chenliang.wang
 * @Date: 2018年08月09日 PM6:22
 * @company: 易宝支付(YeePay)
 */
public class LoadTest {

    public static void main(String[] args) {
//        show_one();
        show_two();
//        staticFinal();
//        load1();
//        load2();
//        load3();
//        load4();
//        load5();
//        load5_1();
//        load6();
//        load7();
//        load8();
//        load9();
    }

    /**
     * 实例化,会显示初始化
     */
    public static void load1() {
        LoadModel loadModel = new LoadModel();
        System.out.println("load a = " + loadModel.getA());
    }

    /**
     * 访问类的静态常量(非static final修饰),会显示初始化
     */
    public static void load2() {
        System.out.println("load a = " + LoadModel.a);
    }

    /**
     * 反射,Class.forName("packagePath")
     * 若不指定参数 initialize 为true,则会显示初始化
     * 若不指定参数 initialize 为false,则不会显示初始化
     */
    public static void load3() {
        try {
            Class clazz = Class.forName("com.jake.jvm.Object_load.LoadModel",false,ClassLoader.getSystemClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * 通过类名获取类Class,不会进行显示初始化
     */
    public static void load4() {
        Class clazz = LoadModel.class;
    }

    /**
     * 访问类的静态常量(static final修饰),不会显示初始化
     */
    public static void load5() {
        System.out.println("load c = " + LoadModel.b);
    }

    /**
     * 访问类的静态变量(static final修饰),会显示初始化
     */
    public static void load5_1() {
        System.out.println("load b = " + LoadModel.c);
    }

    /**
     * 通过子类引用父类的静态字段，只会触发父类的初始化，而不会触发子类的初始化。
     */
    public static void load6() {
        System.out.println("load a = " + LoadModelSon2.a);
    }

    /**
     * 通定义对象数组，不会触发该类的初始化。
     */
    public static void load7() {
        LoadModelSon2[] loadModelSon2s = new LoadModelSon2[1];
    }

    /**
     * 通过类名获取class对象，不会触发该类的初始化
     */
    public static void load8() {
        Class clazz = LoadModelSon2.class;
    }

    /**
     * 通过ClassLoader默认的loadClass方法，也不会触发初始化动作。
     */
    public static void load9() {
        try {
            ClassLoader.getSystemClassLoader().loadClass("com.jake.jvm.Object_load.LoadModelSon2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    /**
     * static final 修饰的成员变量不进行初始化
     * 体现:static代码块未执行
     */
    public static void staticFinal() {
        LoadModelFather loadModelFather = new LoadModelFather();
        System.out.println(loadModelFather.c);
    }

    /**
     * 成员1
     */
    public static void show_one() {
        System.out.println(LoadModelFather.a);
        System.out.println(LoadModelFather.b);
        System.out.println(LoadModelFather.c);
    }

    /**
     * 成员2
     */
    public static void show_two() {
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
     *      2、连接：
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
     *          2)访问类或接口的静态变量（特例：如果是用static final修饰的常量，那就不会对类进行显式初始化。static final 修改的变量则会做显式初始化）
     *          3)调用类的静态方法
     *          4)反射（Class.forName(packagename.className)）
     *          5)初始化类的子类。注：子类初始化问题：满足主动调用，即父类访问子类中的静态变量、方法，子类才会初始化；否则仅父类初始化。
     *          6)java虚拟机启动时被标明为启动类的类
     *
     *     问题2:
     *          static final 修饰的静态常量不进行初始化,直接赋值为变量定义(String和基本数据类型)的值
     *          static final 修饰的成员变量进行初始化
     *
     *     问题3:
     *          static final 修饰的变量,且仅限于基本类型和String
     *          作用:通知虚拟机自动为静态变量赋值
     *
     *     问题4:
     *          static 修饰的变量有两种赋值方式
     *          1.在类构造中赋值(单一static修饰).
     *          2.使用ConstantValue属性赋值(static final修饰,且仅限于基本类型和String).
     *
     *     问题5:
     *          因为从常量池中只能引用到基本类型和String类型的字面量
     *
     *     问题6:
     *          static修饰的字段在加载过程中准备阶段被初始化，但是这个阶段只会赋值一个默认的值（0或者null而并非定义变量设置的值）初始化阶段在类构造器中才会赋值为变量定义的值。
     *
     *          final修饰的字段在运行时被初始化，可以直接赋值，也可以在实例构造器中赋值，赋值后不可修改。
     *
     *          static final修饰的字段在javac编译时生成comstantValue属性，在类加载的准备阶段直接把constantValue的值赋给该字段。
     *          可以理解为在编译期即把结果放入了常量池中。
     */
}
