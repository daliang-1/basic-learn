package com.jake.jvm.FX;

/**
 * 泛型接口实现类-指定具体类型
 *
 * @author: chenliang.wang
 * @Date: 2019:06:17 下午3:31
 * @company: 易宝支付(YeePay)
 */
public class FXClass2 implements FXInterface<String> {

    private String key;

    public FXClass2(String key) {
        this.key = key;
    }

    @Override
    public String get() {
        return key;
    }
}
