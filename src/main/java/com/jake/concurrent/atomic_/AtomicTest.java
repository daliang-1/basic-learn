package com.jake.concurrent.atomic_;

import org.apache.http.annotation.GuardedBy;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * java.util.concurrent.atomic原子变量类
 * <p>
 * 1.保证原子性底层实现原理?
 * 2.保证原子性特点?
 *
 * @author: chenliang.wang
 * @Date: 2018:09:14 下午3:18
 * @company: 易宝支付(YeePay)
 */
public class AtomicTest {

    private AtomicInteger integer = new AtomicInteger();

    private AtomicReference<Integer> reference = new AtomicReference<>(0);

    public void increase() {
        for (int i = 0; i < 10000; i++) {
            integer.incrementAndGet();
        }
    }

    public void service() {
        Integer i = 999;
        for (int j = 0; j < 500; j++) {
            // 加上同步锁后，可保证线程安全
//            synchronized (this) {
                if (i.equals(reference.get())) {
                    System.out.println("相等了...");
                } else {
                    System.out.println(" reference = " + reference.get());
                    reference.getAndSet(reference.get() + 1);
                }
//            }
        }
    }

    /**
     * integer 本身线程安全
     */
    @Test
    public void test_1() throws InterruptedException {
        new Thread(() -> this.increase()).start();
        new Thread(() -> this.increase()).start();
        Thread.sleep(1000);
        System.out.println(integer.get());
    }

    /**
     * reference本身线程安全，但是test_2中存在竟态条件，导致线程不安全
     */
    @Test
    public void test_2() throws InterruptedException {
        new Thread(() -> this.service()).start();
        new Thread(() -> this.service()).start();
        Thread.sleep(1000);
        System.out.println(reference.get());
    }

    /**
     * 1.java.util.concurrent.atomic原子变量类,使用了Unsafe类的CAS函数保证了原子性(并发安全性)
     *   1)volatile关键字：数值对象使用 volatile关键字 修饰，保证多线程条件下可见性，任何一个线程修改了value值，会立马会写到主内存中，不会经过临时内存，保证了可见性
     *   2)CAS函数：使用 Unsafe.compareAndSwapInt(**) 方法，即CAS函数(compare and swap)，CAS函数操作是原子的
     *   3)依靠的便是Unsafe这个类中调用的该方法具有原子性，这个原子性的保证并不是靠java本身保证，而是靠一个更底层的与操作系统相关的特性实现
     *
     * 2.只是保证有本身(Atomic*)具备线程安全性，但是如果利用本身存在竟态条件，还是会出现线程安全问题。例如test_2()
     */
}
