package com.jake.jvm.FInalize;

/**
 * finalize方法介绍
 *
 * *** 该方法了解即可,不鼓励使用,因为该方法运行代价高昂,不确定性大,无法保证各个对象的调用顺序
 *
 * finalize的执行过程(生命周期)
 *      unfinalized: 新建对象会先进入此状态，GC并未准备执行其finalize方法，因为该对象是可达的
 *      finalizable: 表示GC可对该对象执行finalize方法，GC已检测到该对象不可达。正如前面所述，GC通过F-Queue队列和一专用线程完成finalize的执行
 *      finalized: 表示GC已经对该对象执行过finalize方法
 *      reachable: 表示GC Roots引用可达
 *      finalizer-reachable(f-reachable)：表示不是reachable，但可通过某个finalizable对象可达
 *      unreachable：对象不可通过上面两种途径可达
 *
 * @author: chenliang.wang
 * @Date: 2018年08月07日 AM10:45
 * @company: 易宝支付(YeePay)
 */
public class FinalizeTest {

    private static FinalizeTest FINALIZE = null;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        FINALIZE = this;
    }

    public static void main(String[] args) {

        FINALIZE = new FinalizeTest();
        System.out.println("first FINALIZE = " + FINALIZE);

        FINALIZE = null;

        /**
         * 第一次标记筛选
         * GC Roots不可达但是因为有覆盖finalize()
         * 所以该对象会被放置到F-Queue中等待虚机触发覆盖的finalize()方法
         */
        System.gc();
        System.out.println("second FINALIZE = " + FINALIZE);

        FINALIZE = null;

        /**
         * 第二次标记筛选
         * GC Roots不可达,虽然因为有覆盖finalize(),但是finalize()已被GC收集器执行过一次,不会再执行,此时直接GC回收
         */
        System.gc();
        System.out.println("third FINALIZE = " + FINALIZE);
    }
}

