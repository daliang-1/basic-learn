package com.jake.jvm.Stack;

/**
 * 操作数栈测试
 *
 * javap -c xxx.class 反汇编
 *
 * @author: chenliang.wang
 * @Date: 2018:08:22 下午2:54
 * @company: 易宝支付(YeePay)
 */
public class OperateStackTest {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = (a + b) * 3;
    }

    /**
     * 反汇编结果
     *
     * 0: aload_0
     * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     * 4: return
     * public static void main(java.lang.String[]);
     *
     * Code:
     * 	0: bipush      10	将10压入操作数栈的栈顶
     * 	2: istore_1	负责将栈顶元素出栈并存储在局部变量表中访问索引为1的Slot上
     * 	3: bipush      20	将20压入操作数栈的栈顶
     * 	5: istore_2	负责将栈顶元素出栈并存储在局部变量表中访问索引为2的Slot上
     * 	6: iload_1	将索引为1的Slot数值重新压入操作数栈的栈顶
     * 	7: iload_2	将索引为2的Slot数值重新压入操作数栈的栈顶
     * 	8: iadd		将两个数值出栈执行加法运算后再将结果压入栈顶
     * 	9: istore_3	负责将栈顶元素出栈并存储在局部变量表中访问索引为3的Slot上
     * 	10: return	方法执行完返回操作
     */
}
