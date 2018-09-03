package com.jake.model.Factory.factory_1;

import com.jake.model.Factory.factory_1.biz.ProgressBiz;
import com.jake.model.Factory.factory_1.enum_.ProgressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * 注册工厂
 * @author: chenliang.wang
 * @Date: 2018:09:03 上午11:15
 * @company: 易宝支付(YeePay)
 */
@Controller
public class RegisterFactory {

    @Autowired
    protected Map<String,ProgressBiz> factoryMap;

    public ProgressBiz getProgress(ProgressType progressType){
        return factoryMap.get(progressType.getDesc());
    }
}
