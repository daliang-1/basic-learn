package com.jake.concurrent.synchronized_;

import org.junit.Test;

/**
 * Synchronized
 *
 * 1.作用?
 * 2.使用?
 * 3.特点?
 *
 * @author: chenliang.wang
 * @Date: 2018:09:12 下午6:05
 * @company: 易宝支付(YeePay)
 */
public class SynchronizedTest {

    static int a = 0;

    public void increase_1() {
        for (int i = 0; i < 50000; i++) {
            a++;
        }
    }

    public synchronized void increase_2() {
        for (int i = 0; i < 50000; i++) {
            a++;
        }
    }
    public static synchronized void increase_3() {
        for (int i = 0; i < 50000; i++) {
            a++;
        }
    }
    public void increase_4() {
        synchronized (this){
            for (int i = 0; i < 50000; i++) {
                a++;
            }
        }
    }

    /**
     * 并发+无锁
     */
    @Test
    public void test_1() throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        new Thread(() -> test.increase_1()).start();
        new Thread(() -> test.increase_1()).start();
        Thread.sleep(1000);
        System.out.println(a);
    }

    /**
     * 多线程 + synchronized修饰实例方法 + 同一个实例对象
     * 同一个实例对象锁,产生互斥,所以多线程下保证了共享资源的同步处理
     */
    @Test
    public void test_2() throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        new Thread(() -> test.increase_2()).start();
        new Thread(() -> test.increase_2()).start();
        Thread.sleep(1000);
        System.out.println(a);
    }

    /**
     * 多线程 + synchronized修饰实例方法 + 不同实例对象
     * 不同实例对象锁,不会产生互斥,所以保证不了共享资源的同步处理
     */
    @Test
    public void test_3() throws InterruptedException {
        SynchronizedTest test1 = new SynchronizedTest();
        SynchronizedTest test2 = new SynchronizedTest();
        new Thread(() -> test1.increase_2()).start();
        new Thread(() -> test2.increase_2()).start();
        Thread.sleep(1000);
        System.out.println(a);
    }

    /**
     * 多线程 + synchronized修饰静态方法 + 相同实例对象
     * 相同类对象锁,产生互斥,所以多线程下保证了共享资源的同步处理
     */
    @Test
    public void test_4() throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        new Thread(() -> test.increase_3()).start();
        new Thread(() -> test.increase_3()).start();
        Thread.sleep(1000);
        System.out.println(a);
    }

    /**
     * 多线程 + synchronized修饰静态方法 + 不同实例对象
     * 相同类对象锁,产生互斥,所以多线程下保证了共享资源的同步处理
     */
    @Test
    public void test_5() throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        new Thread(() -> test.increase_3()).start();
        new Thread(() -> test.increase_3()).start();
        Thread.sleep(1000);
        System.out.println(a);
    }

    /**
     * 多线程 + synchronized修饰静态方法 + synchronized修饰实例方法
     * 锁对象不同,不会形成互斥,所以出现共享数据安全性问题
     */
    @Test
    public void test_6() throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        new Thread(() -> test.increase_2()).start();
        new Thread(() -> test.increase_3()).start();
        Thread.sleep(1000);
        System.out.println(a);
    }

    /**
     * 多线程 + synchronized同步代码块
     * 指定锁对象相同,形成互斥,所以多线程下保证了共享资源的同步处理
     */
    @Test
    public void test_7() throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        new Thread(() -> test.increase_4()).start();
        new Thread(() -> test.increase_4()).start();
        Thread.sleep(1000);
        System.out.println(a);
    }

    /**
     * 多线程 + synchronized同步代码块
     * 指定锁对象不相同,不会形成互斥,所以出现共享数据安全性问题
     */
    @Test
    public void test_8() throws InterruptedException {
        SynchronizedTest test1 = new SynchronizedTest();
        SynchronizedTest test2 = new SynchronizedTest();
        new Thread(() -> test1.increase_4()).start();
        new Thread(() -> test2.increase_4()).start();
        Thread.sleep(1000);
        System.out.println(a);
    }


    /**
     * 1.作用
     *   1)保证在同一个时刻，只有一个线程可以执行某个方法或者某个代码块(主要是对方法或者代码块中存在共享数据的操作)
     *   2)保证一个线程的变化(主要是共享数据的变化)被其他线程所看到（保证可见性，完全可以替代Volatile功能）
     * 2.使用
     *   1)修饰实例方法，锁对象 = 当前实例对象
     *   2)修饰静态方法，锁对象 = 当前类对象(class对象)
     *   3)修饰代码块，锁对象 = 指定对象
     * 3.特点
     *   1)当一个线程正在访问一个对象的synchronized方法，其他线程不能访问 该对象 的其他synchronized方法，毕竟一个对象只有一个锁
     *   2)不同线程不同对象 访问相同的synchronized实例方法时，锁分别是对象本身，此时共享数据不安全
     *   3)线程1调用对象的synchronized实例方法，线程2调用对象的synchronized静态方法，此时锁对象不同，不会形成互斥，引发共享数据安全性问题
     */
}