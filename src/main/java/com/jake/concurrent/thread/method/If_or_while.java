package com.jake.concurrent.thread.method;

import java.util.ArrayList;
import java.util.List;

/**
 * 多线程中 if / while 使用选择
 *
 * 问题1: 多线程中 if / while 选择依据?
 *
 * @author: chenliang.wang
 * @Date: 2018:09:17 下午4:31
 * @company: 易宝支付(YeePay)
 */
public class If_or_while {

    public static void main(String[] args) {
        Object object = "1";

        Thread_A thread_a_1 = new Thread_A(object);
        thread_a_1.setName("thread_a_1");
        thread_a_1.start();

        Thread_A thread_a_2 = new Thread_A(object);
        thread_a_2.setName("thread_a_2");
        thread_a_2.start();

        Thread_B thread_b_1 = new Thread_B(object);
        thread_b_1.setName("thread_b_1");
        thread_b_1.start();
    }
}


class Service_{

    private Object object;

    public Service_(Object object) {
        this.object = object;
    }

    public void wait_(){
        synchronized (object){
//            while (ListObject.list.size() == 0){
            if (ListObject.list.size() == 0){
                System.out.println("This is "+Thread.currentThread().getName()+" wait begin...");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ListObject.list.remove(0);
            System.out.println("This is "+Thread.currentThread().getName()+" wait end");
        }
    }

    public void notifyAll_(){
        synchronized (object){
            ListObject.list.add("1");
            System.out.println("This is " + Thread.currentThread().getName() + " notifyAll begin...");
            object.notifyAll();
            System.out.println("This is " + Thread.currentThread().getName() + " notifyAll end");
        }
    }
}

class ListObject{
    public static List<String> list = new ArrayList<>();
}

class Thread_A extends Thread{

    private Object object;

    public Thread_A(Object object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        Service_ service_ = new Service_(object);
        service_.wait_();
    }
}

class Thread_B extends Thread{

    private Object object;

    public Thread_B(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        Service_ service_ = new Service_(object);
        service_.notifyAll_();
    }
}

/**
 * 问题1:
 *      wait()之后触发notify()、notifyALl()，则会在wait()后继续执行.且多个消费者的情况下下
 *      1)使用if,notify()之后可能会因为共享资源的错误操作，导致多个消费者之前逻辑处理出错，例子中导致 IndexOutofBoundException
 *      2)使用while，notify()之后还会继续判断while条件，不会因为多消费者处理导致逻辑处理出错
 */
