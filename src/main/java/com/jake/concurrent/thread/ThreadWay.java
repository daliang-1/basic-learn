package com.jake.concurrent.thread;

/**
 * 创建线程-继承Thread类
 * @author: chenliang.wang
 * @Date: 2018:09:17 上午10:54
 * @company: 易宝支付(YeePay)
 */
public class ThreadWay extends Thread {

    public ThreadWay(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("This is "+Thread.currentThread().getName()+" start");
    }

    public static void main(String[] args) {
        new ThreadWay("thread1").start();
    }
}
