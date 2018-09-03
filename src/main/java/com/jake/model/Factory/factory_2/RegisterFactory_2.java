package com.jake.model.Factory.factory_2;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.jake.model.Factory.factory_2.entity.BizEntity;
import com.jake.model.Factory.factory_2.enum_.BizTypeEnum;
import com.jake.model.Factory.factory_2.enum_.CodeEnum;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午3:09
 * @company: 易宝支付(YeePay)
 */
public abstract class RegisterFactory_2 {

    public CodeEnum code;

    public BizTypeEnum biz;

    public static Table<CodeEnum,BizTypeEnum,RegisterFactory_2> registerTable = HashBasedTable.create();

    public static RegisterFactory_2 getBiz(CodeEnum code, BizTypeEnum bizType){
        return registerTable.get(code,bizType);
    }

    public void putBiz(){
        registerTable.put(code,biz,this);
    }

    public abstract void process(BizEntity entity);
}
