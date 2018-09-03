package com.jake.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: chenliang.wang
 * @Date: 2018:09:03 下午2:19
 * @company: 易宝支付(YeePay)
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:application.xml"})
public class BaseTest {
}
