package com.jake.jvm.FX;

/**
 * 泛型接口实现类-不指定具体类型
 * 如 : class FXClass<T> implements FXInterface<T>{
 *
 * @author: chenliang.wang
 * @Date: 2019:06:17 下午3:23
 * @company: 易宝支付(YeePay)
 */
public class FXClass<T> implements FXInterface<T> {

    private T key;

    public FXClass(T key) {
        this.key = key;
    }

    @Override
    public T get() {
        return key;
    }
}
