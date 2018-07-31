package com.jake.jvm.Error;

/**
 * @author: chenliang.wang
 * @Date: 2018年07月31日 PM3:11
 * @company: 易宝支付(YeePay)
 */
public class TransferA {

    private String name;

    private TransferB transferB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransferB getTransferB() {
        return transferB;
    }

    public void setTransferB(TransferB transferB) {
        this.transferB = transferB;
    }

    public TransferA() {
        transferB = new TransferB();
    }

    @Override
    public String toString() {
        return "";
    }
}
