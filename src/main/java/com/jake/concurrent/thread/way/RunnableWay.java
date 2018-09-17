package com.jake.concurrent.thread.way;

/**
 * 创建线程—实现Runnable接口
 * @author: chenliang.wang
 * @Date: 2018:09:17 上午10:56
 * @company: 易宝支付(YeePay)
 */
public class RunnableWay implements Runnable {

    @Override
    public void run() {
        System.out.println("This is "+Thread.currentThread().getName()+" start");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new RunnableWay(),"thread1");
        Thread thread2 = new Thread(new RunnableWay(),"thread2");
        thread1.start();
        thread2.start();
    }
}
