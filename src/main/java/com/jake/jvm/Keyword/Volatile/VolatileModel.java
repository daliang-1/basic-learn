package com.jake.jvm.Keyword.Volatile;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile
 *
 * 问题1.并发编程中的三个概念(or 如何保证并发不会出错)?
 * 问题2.volatile能保证原子性么?
 * 问题3.volatile有什么作用?
 *
 * 共享变量被volatile修饰后,就具备了两次含义
 *      1.保证可见性
 *        保证不同线程对该变量的操作都具有可见性,即某个线程对该变量进行了修改,其新值会对于其他线程是保持可见的
 *        当变量被volatile修饰后,线程2 会在主内存中读取变量数据,放入高速缓存中,修改后然后同步到主内存,此时线程2的修改会导致变量在线程1高速缓存中的缓存失效,
 *        线程1会直接去主内存中读取新的变量值
 *
 *        注意点:保持可见性,并没有保证操作的原子性,所以在多线程环境下,被volatile修饰的变量不一定能原子操作
 *              若需要该变量进行原子操作,则需要进行同步操作(synchronized)/加锁(Lock)/同步类处理(Atomic***)
 *
 *      2.禁止指令重排序
 *
 *        在Java内存模型中,允许编译器和处理器对命令进行重排序,重排序对单线程执行结果没有影响,但是对多线程执行结果有影响。
 *
 *        volatile修饰的变量,有两层含义
 *          1）当程序执行到volatile变量的读操作或者写操作时，在其前面的操作的更改肯定全部已经进行，且结果已经对后面的操作可见；在其后面的操作肯定还没有进行；
 *          2）在进行指令优化时，不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行
 *
 * @author: chenliang.wang
 * @Date: 2018年08月02日 AM11:00
 * @company: 易宝支付(YeePay)
 */
public class VolatileModel {

    private static volatile int a = 0;

    private static AtomicInteger b = new AtomicInteger();

    public static int c = 0;

    // 非公平锁/可重入锁,空参构造方法默认执行非公平锁,有参数构造方法可执行锁的类型
//    private Lock lock = new ReentrantLock();
    private Lock lock = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {

        final VolatileModel test = new VolatileModel();

        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
//                        test.add(); // volatile无法保证原子性
//                        test.addByLock(); // 加锁,保证原子性
//                        test.addBySynchronized(); // 加同步方法,保证原子性
//                        test.addByAtomic(); // 原子操作类,保证原子性
                    test.addC(); // 说明内存模型中线程工作缓存与主内存同步延迟导致数据错误
                }
            }.start();
        }

        //保证前面的线程都执行完
        Thread.sleep(10000);
        System.out.println("a = " + a);
        System.out.println("b = " + b.get());
        System.out.println("c = " + c);
    }

    public void add() {
        a++;
    }

    public void addByLock() {
        lock.lock();
        try {
            a++;
        } catch (Exception e) {
            System.out.println("异常了");
        } finally {
            lock.unlock();
        }

    }

    public synchronized void addBySynchronized() {
        a++;
    }

    public static void addByAtomic(){
        b.getAndIncrement();
    }

    public static void addC() {
        c++;
    }

    /**
     * 回答
     * 问题1.
     *      1.原子性,即一个操作或者多个操作要么全部执行并且执行的过程不会被任何因素打断,要么就都不执行
     *      2.可见性,可见性是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值
     *      3.有序性,即程序执行的顺序按照代码的先后顺序执行
     *
     * 问题2.
     *      并没有保证操作的原子性,所以在多线程环境下,被volatile修饰的变量不一定能原子操作
     *      若需要该变量进行原子操作,则需要进行同步操作(synchronized)/加锁(Lock)/同步类处理(Atomic***)
     *
     * 问题3.如类注释
     */
}
