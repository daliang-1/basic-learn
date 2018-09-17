package com.jake.concurrent.thread.method;

/**
 * wait/notify/notifyAll
 *
 * 问题1:
 *      wait()? notify()? notifyAll()?
 *
 * 问题2:
 *      三者使用注意点?
 *
 * @author: chenliang.wang
 * @Date: 2018:09:17 下午3:26
 * @company: 易宝支付(YeePay)
 */
public class Wait_notify {

    public static void main(String[] args) throws InterruptedException {
        // notify()
//        test_1();
        // notifyAll()
        test_2();
    }

    public static void test_1(){
        Object object = "1";
        new ThreadA(object).start();
        new ThreadB(object).start();
    }

    public static void test_2(){
        Object object = "1";
        new ThreadA(object).start();
        new ThreadC(object).start();
    }

}

class Service {

    private Object lock;

    public Service(Object lock) {
        this.lock = lock;
    }

    public void wait_() {
        synchronized (lock) {
            System.out.println("This is " + Thread.currentThread().getName() + " lock running...");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This is " + Thread.currentThread().getName() + " lock end...");
        }
    }

    public void notify_() {
        synchronized (lock) {
            System.out.println("This is " + Thread.currentThread().getName() + " notify running...");
            lock.notify();
            System.out.println("This is " + Thread.currentThread().getName() + " notify end...");
        }
    }

    public void notifyAll_() {
        synchronized (lock) {
            System.out.println("This is " + Thread.currentThread().getName() + " notifyAll running...");
            lock.notifyAll();
            System.out.println("This is " + Thread.currentThread().getName() + " notifyAll end...");
        }
    }
}

class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service(lock);
        service.wait_();
    }
}

class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service(lock);
        service.notify_();
    }
}

class ThreadC extends Thread {

    private Object lock;

    public ThreadC(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service(lock);
        service.notifyAll_();
    }
}

/**
 * 问题1:
 *      object.wait(),线程终止编程非运行状态，该状态下会释放锁
 *      object.notify(),正在等待该对象的所有线程中将有一个线程被唤醒并允许执行,随机选取线程唤醒
 *      object.notifyAll(),来唤醒正在等待一个给定对象的所有线程
 *
 * 问题2:
 *      1) 只能用于同步代码块中
 *      2) 不要使用字符串常量 or 全局变量 调用 wait()、notify()、notifyAll()方法
 */


