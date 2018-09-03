package com.jake.model.Factory.factory_1.biz.impl;

import com.jake.model.Factory.factory_1.biz.ProgressBiz;
import com.jake.model.Factory.factory_1.entity.ProgressEntity;
import org.springframework.stereotype.Component;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午2:01
 * @company: 易宝支付(YeePay)
 */
@Component("sayGoodByeProgress")
public class SayGoodByeProgress implements ProgressBiz {

    @Override
    public void process(ProgressEntity entity) {
        System.out.println(entity.getProgressName()+" Hello...");
    }
}
