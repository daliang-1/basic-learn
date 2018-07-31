package com.jake.reflect.Class;

import com.jake.reflect.ClassEntity;
import com.jake.reflect.SubClassEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Class学习
 *
 * @author: chenliang.wang
 * @Date: 2018年07月24日 PM5:03
 * @company: 易宝支付(YeePay)
 */
public class ClassMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("com.jake.reflect.SubClassEntity");
        System.out.println("isAssignableFrom = " + ClassEntity.class.isAssignableFrom(clazz));

        Constructor declaredCon = clazz.getDeclaredConstructor();
        declaredCon.setAccessible(true);
        SubClassEntity declaredEntity = (SubClassEntity) declaredCon.newInstance();
        System.out.println(declaredEntity.getName());

        Constructor noneConstructor = clazz.getDeclaredConstructor(String.class);
        noneConstructor.setAccessible(true);
        SubClassEntity noneEntity = (SubClassEntity) noneConstructor.newInstance("Jany");
        System.out.println(noneEntity.getName());

        Constructor constructor = clazz.getConstructor(String.class,int.class);
        SubClassEntity subClassEntity = (SubClassEntity) constructor.newInstance("Tony",100);
        System.out.println(subClassEntity.getName());
    }



    /**
     * forName -> 根据对象名称获取Class对象
     */
    public static void forNameTest(String name){
        try {
            System.out.println(Class.forName(name));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * isAssignableFrom
     * A.class.isAssignableFrom(B.class)  —> 判断ClassA是否为ClassB的父类或接口
     *                                       or 判断ClassA和ClassB是否为同一类
     */
    public static void isAssignableFromTest(Class A, Class B) {
        System.out.println(A.isAssignableFrom(B));
    }

    /**
     * getClass —> 获取Class对象，对象的类型类
     */
    public static void getClassTest(Object object){
        System.out.println(object.getClass());
    }

    /**
     * getName —> 获取具体对象名称(带包路径)
     */
    public static void getNameTest(Object obj) {
        System.out.println(obj.getClass().getName());
    }
}
