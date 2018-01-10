package com.bdqn.ssm6.dao;

import com.bdqn.ssm6.entity.Tuser6;

import java.util.List;

/**
 * Created by 佳 on 2017/12/7.
 */
public interface TuserMapper6 {
    public Tuser6 login(Tuser6 tuser6);

    public List<Tuser6> queryAll();

}
