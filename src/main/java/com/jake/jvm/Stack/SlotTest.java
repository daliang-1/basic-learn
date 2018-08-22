package com.jake.jvm.Stack;

/**
 * 变量槽(Slot)
 *
 * 问题1：什么是变量槽？
 * 问题2：变量槽干啥的？
 * 问题3：变量槽可存储的类型？
 * 问题4：变量槽的使用方式？
 * 问题5：变量槽的特点？
 *
 *
 * @author: chenliang.wang
 * @Date: 2018年08月08日 AM11:00
 * @company: 易宝支付(YeePay)
 */
public class SlotTest {

    public static void main(String[] args) {
//        release();
        releaseFail();
    }


    /**
     * 配置输出GC日志  -verbose:gc
     */
    public static void release() {
        {
            byte[] bytes1 = new byte[100 * 1024 * 1024];
        }
        System.gc(); // 第一次GC,虽然bytes1的作用域已结束,但是由于Slot未释放bytes1引用,所以System.gc()执行FullGc的时候没有回收掉该对象
        {
            byte[] bytes2 = new byte[10 * 1024 * 1024]; // 复用Slot
        }
        System.gc(); // 第二次GC,bytes2复用bytes1的Slot,bytes1被回收,bytes2仍然占据Slot,不会被回收

        int a = 0; // 复用Slot

        System.gc(); // 第三次GC,a复用bytes2的Slot,bytes2被回收,a仍然占据Slot,不会被回收
    }

    public static void releaseFail() {
        {
            byte[] bytes = new byte[10 * 1024 * 1024];
        }
        System.gc(); // 虽然bytes的作用域已结束,但是由于Slot未释放bytes引用,所以System.gc()执行FullGc的时候没有回收掉该对象
    }

    /**
     * 回答
     * 问题1：
     *      是虚拟机栈组成中局部变量表的最小组成单位
     * 问题2：
     *      存储 方法参数及局部变量
     * 问题3：
     *      可以存储 八种基本数据类型(byte/short/char/int/long/float/double/boolean)
     *              + reference (对象引用地址)
     *              + returnAddress(为字节码指令jsr、jsr_w和ret服务的，它指向了一条字节码指令的地址)
     * 问题4：
     *      使用 索引定位 方式使用局部变量表的
     * 问题5：
     *      1)变量槽可复用,当一个变量超过了它的作用域,该变量对应的Slot可以被其他变量复用
     *      2)Slot可能会影响GC回收,当对象引用被Slot引用时,不会被GC回收
     */
}