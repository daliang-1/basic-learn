package com.jake.concurrent.atomic_;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * java.util.concurrent.atomic原子变量类
 *
 * 1.保证原子性底层实现原理?
 *
 * @author: chenliang.wang
 * @Date: 2018:09:14 下午3:18
 * @company: 易宝支付(YeePay)
 */
public class AtomicTest {

    private AtomicInteger integer = new AtomicInteger();

    public void increase(){
        for (int i = 0; i < 10000; i++) {
            integer.incrementAndGet();
        }
    }

    @Test
    public void test_1() throws InterruptedException {
        new Thread(()->this.increase()).start();
        new Thread(()->this.increase()).start();
        Thread.sleep(1000);
        System.out.println(integer.get());
    }


    /**
     * 1.java.util.concurrent.atomic原子变量类,使用了Unsafe类的方法保证了并发安全性。
     *   1)数值对象使用volatile关键字修饰，保证多线程条件下可见性，任何一个线程修改了value值，会立马会写到主内存中，不会经过临时内存，保证了可见性
     *   2)使用Unsafe.compareAndSwapInt(**)方法，即CAS(compare and swap)
     *   3)依靠的便是Unsafe这个类中调用的该方法具有原子性，这个原子性的保证并不是靠java本身保证，而是靠一个更底层的与操作系统相关的特性实现
     */
}
