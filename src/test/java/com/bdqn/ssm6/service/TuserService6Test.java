package com.bdqn.ssm6.service;

import com.bdqn.ssm6.entity.Tuser6;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TuserService6Test {
    @Resource
    private TuserService6 tuserService6;
    @Test
    public void login() throws Exception {
        Tuser6 tuser6 = new Tuser6();
        tuser6.setUserName("admin");
        tuser6.setPassword("abc");
        Tuser6 loginUser = tuserService6.login(tuser6);
        System.out.println(loginUser);
    }

    @Test
    public void queryAll() {
        PageInfo<Tuser6> pageInfo = tuserService6.queryAll(1, 3);
        List<Tuser6> list = pageInfo.getList();
        if (null != list) {
            for (Tuser6 tuser6 : list) {
                System.out.println(tuser6);
            }
        }
    }

}