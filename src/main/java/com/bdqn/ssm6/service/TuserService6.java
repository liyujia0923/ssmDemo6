package com.bdqn.ssm6.service;

import com.bdqn.ssm6.entity.Tuser6;
import com.github.pagehelper.PageInfo;

/**
 * Created by 佳 on 2017/12/7.
 */
public interface TuserService6 {
    public Tuser6 login(Tuser6 tuser6);

    public PageInfo<Tuser6> queryAll(Integer pageNum, Integer pageSize);
}
