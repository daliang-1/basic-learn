package com.jake.model.Factory.factory_2.progress;

import com.jake.model.Factory.factory_2.RegisterFactory_2;
import com.jake.model.Factory.factory_2.entity.BizEntity;
import com.jake.model.Factory.factory_2.enum_.BizTypeEnum;
import com.jake.model.Factory.factory_2.enum_.CodeEnum;
import org.springframework.stereotype.Component;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午3:17
 * @company: 易宝支付(YeePay)
 */
@Component("aBProgress")
public class ABProgress extends RegisterFactory_2 {

    public ABProgress() {
        this.code = CodeEnum.CODE_1;
        this.biz = BizTypeEnum.SAY_HELLO;
        this.putBiz();
    }

    @Override
    public void process(BizEntity entity){
        System.out.println(entity.getBizName() + " aBProgress");
    }
}
