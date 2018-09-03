package com.jake.test.model;

import com.jake.model.Factory.factory_1.RegisterFactory;
import com.jake.model.Factory.factory_1.entity.ProgressEntity;
import com.jake.model.Factory.factory_1.enum_.ProgressType;
import com.jake.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午2:07
 * @company: 易宝支付(YeePay)
 */
public class Factory_1_test extends BaseTest {

    @Autowired
    private RegisterFactory registerFactory;

    @Test
    public void factory_1(){
        ProgressEntity entity = new ProgressEntity();
        entity.setProgressName("TOM");
        registerFactory.getProgress(ProgressType.SAY_HELLO).process(entity);
    }
}
