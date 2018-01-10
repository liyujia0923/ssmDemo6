package com.bdqn.ssm6.service;

import com.bdqn.ssm6.dao.TuserMapper6;
import com.bdqn.ssm6.entity.Tuser6;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/7.
 */
@Service("tuserService6")
public class TuserService6Impl implements TuserService6 {
    @Resource
    private TuserMapper6 tuserMapper6;
    @Override
    public Tuser6 login(Tuser6 tuser6) {
        return tuserMapper6.login(tuser6);
    }

    @Override
    public PageInfo<Tuser6> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tuser6> list = tuserMapper6.queryAll();
        PageInfo<Tuser6> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
