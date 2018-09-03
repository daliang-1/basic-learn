package com.jake.test.model;

import com.jake.model.Factory.factory_2.RegisterFactory_2;
import com.jake.model.Factory.factory_2.entity.BizEntity;
import com.jake.model.Factory.factory_2.enum_.BizTypeEnum;
import com.jake.model.Factory.factory_2.enum_.CodeEnum;
import com.jake.test.BaseTest;
import org.junit.Test;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午3:39
 * @company: 易宝支付(YeePay)
 */
public class Factory_2_test extends BaseTest {

    @Test
    public void factory_2(){
        BizEntity entity = new BizEntity();
        entity.setBizName("HELLO");
        RegisterFactory_2.getBiz(CodeEnum.CODE_2, BizTypeEnum.SAY_GOODBYE).process(entity);
    }
}
