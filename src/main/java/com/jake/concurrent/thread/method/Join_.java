package com.jake.concurrent.thread.method;

/**
 * join()
 *
 * 问题1:
 *      join()方法作用?
 * 问题2:
 *      如何让线程T1，T2，T3按顺序执行?
 * @author: chenliang.wang
 * @Date: 2018:09:17 上午11:34
 * @company: 易宝支付(YeePay)
 */
public class Join_ extends Thread {

    public Join_(String name) {
        super(name);
    }

    @Override
    public void run() {
        int a = 0;
        for (int i = 0; i < 5000; i++) {
            System.out.println("This is "+Thread.currentThread().getName()+"第"+(++a)+"次输出");
        }
    }

    // T1/T2/T3 异步交叉线程输出
    public static void test_1(){
        Join_ T1 = new Join_("T_1");
        Join_ T2 = new Join_("T_2");
        Join_ T3 = new Join_("T_3");
        T1.start();
        T2.start();
        T3.start();
    }

    // T1/T2/T3 同步依次输出
    public static void test_2(){
        Join_ T1 = new Join_("T_1");
        Join_ T2 = new Join_("T_2");
        Join_ T3 = new Join_("T_3");
        try {
            T1.start();
            T1.join();
            T2.start();
            T2.join();
            T3.start();
            T3.join();
            T3.join(12,12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
//        test_1();
        test_2();
    }

    /**
     * 问题1:
     *      t.join(),表示主线程需要等待t线程死亡后,才可继续执行主线程其他操作。
     * 问题2:
     *      test_2()解答。
     *      使用线程的join()方法,让主线程等待其他线程依次执行完。
     */
}
