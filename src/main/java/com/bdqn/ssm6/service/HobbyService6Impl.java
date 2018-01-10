package com.bdqn.ssm6.service;

import com.bdqn.ssm6.dao.HobbyMapper6;
import com.bdqn.ssm6.entity.Hobby6;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/27.
 */
@Service
public class HobbyService6Impl implements HobbyService6 {
    @Resource
    private HobbyMapper6 hobbyMapper6;
    @Override
    public PageInfo<Hobby6> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Hobby6> list = hobbyMapper6.queryAll();
        PageInfo<Hobby6> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer addHobby(Hobby6 hobby6) {
        return hobbyMapper6.addHobby(hobby6);
    }

    @Override
    public Integer deleteHobby(Integer id) {
        return hobbyMapper6.deleteHobby(id);
    }

    @Override
    public Integer deleteHobbyList(List<Integer> ids) {
        return hobbyMapper6.deleteHobbyList(ids);
    }

    @Override
    public Hobby6 queryHobby(Integer id) {
        return hobbyMapper6.queryHobby(id);
    }

    @Override
    public Integer updateHobby(Hobby6 hobby6) {
        return hobbyMapper6.updateHobby(hobby6);
    }

}
