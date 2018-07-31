package com.jake.jvm.Error;

/**
 * java函数调用时,虚拟机会分配堆栈,当栈空间不足(内存不足)时,会抛出StackOverflowError
 * or
 * 当栈深度超出虚机分配给线程的栈大小时,会抛出StackOverflowError
 * <p>
 * 常见出现该异常Error:
 *      1-深度递归,方法递归,导致虚拟机一直分配堆栈,导致最终栈空间不足
 *      2-类循环调用,会导致栈空间不足(与深度递归类似)
 *
 * @author: chenliang.wang
 * @Date: 2018年07月31日 PM2:55
 * @company: 易宝支付(YeePay)
 */
public class StackOverflowErrorModel {

    public static void main(String[] args) {
        // 深度递归
//        recursion(1);

        // 循环调用
        transfer(new TransferA());
    }

    /**
     * 当传入值 num > 1 时,会导致深度递归,栈空间不足
     *
     * @param num
     */
    public static void recursion(int num) {
        if (num == 0) {
            System.out.println("bingo");
            return;
        }
        System.out.println("recursion result = " + num);
        recursion(++num);
    }

    /**
     * 循环调用,导致内存空间不足,无法分配栈空间
     *
     * @param transfer
     */
    public static void transfer(TransferA transfer) {
        System.out.println(transfer.toString());
    }
}
