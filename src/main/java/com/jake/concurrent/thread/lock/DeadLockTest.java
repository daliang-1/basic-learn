package com.jake.concurrent.thread.lock;

/**
 * 死锁
 *
 * 问题1:
 *      什么是死锁?
 * 问题2:
 *      死锁产生的条件?
 * 问题3:
 *      产生死锁的根本原因?
 * 问题4:
 *      如何避免死锁?
 * 问题5:
 *      如何查看到线程中的死锁?
 *
 * @author: chenliang.wang
 * @Date: 2018:09:18 上午10:49
 * @company: 易宝支付(YeePay)
 */
public class DeadLockTest {

    public static void main(String[] args) {
        String str1 = new String("string_1");
        String str2 = new String("string_2");

        new Thread(new Lock(str1,str2),"thread_1").start();
        new Thread(new Lock(str2,str1),"thread_2").start();
    }
}

class Lock implements Runnable{

    private String str1;

    private String str2;

    public Lock(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public void run() {
        synchronized (str1){
            System.out.println("This is "+Thread.currentThread().getName()+" first running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (str2){
                System.out.println("This is "+Thread.currentThread().getName()+" second running...");
            }
        }
    }
}

/**
 * 问题1:
 *      多个线程同时被阻塞，它们中的一个或者全部都在等待某个资源被释放。
 *
 * 问题2:
       1)互斥条件：一个资源每次只能被一个进程使用。独木桥每次只能通过一个人。
       2)请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。乙不退出桥面，甲也不退出桥面。
       3)不剥夺条件: 进程已获得的资源，在未使用完之前，不能强行剥夺。甲不能强制乙退出桥面，乙也不能强制甲退出桥面。
       4)循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。如果乙不退出桥面，甲不能通过，甲不退出桥面，乙不能通过。

 * 问题3:
 *      导致死锁的根源在于不适当地运用“synchronized”关键词来管理线程对特定对象的访问
 *
 * 问题4:
       1)加锁顺序
           按照顺序加锁是一种有效的死锁预防机制。但是，这种方式需要你事先知道所有可能会用到的锁(并对这些锁做适当的排序)，但总有些时候是无法预知的。
       2)加锁时限
           另外一个可以避免死锁的方法是在尝试获取锁的时候加一个超时时间，这也就意味着在尝试获取锁的过程中若超过了这个时限该线程则放弃对该锁请求
       3)死锁检测
           死锁检测是一个更好的死锁预防机制，它主要是针对那些不可能实现按序加锁并且锁超时也不可行的场景。

 * 问题5:
       1)jconsole:JDK自带的图形化界面工具,线程界面"检测死锁"
       2)jstack:JDK自带的命令行工具，主要用于线程Dump分析
 *
 */


