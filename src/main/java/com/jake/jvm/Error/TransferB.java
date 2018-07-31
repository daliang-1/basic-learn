package com.jake.jvm.Error;

/**
 * @author: chenliang.wang
 * @Date: 2018年07月31日 PM3:11
 * @company: 易宝支付(YeePay)
 */
public class TransferB {
    private String address;
    private TransferA transferA;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TransferA getTransferA() {
        return transferA;
    }

    public void setTransferA(TransferA transferA) {
        this.transferA = transferA;
    }

    public TransferB() {
        transferA = new TransferA();
    }

    @Override
    public String toString() {
        return "";
    }
}
