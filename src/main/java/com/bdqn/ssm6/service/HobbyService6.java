package com.bdqn.ssm6.service;

import com.bdqn.ssm6.entity.Hobby6;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2017/12/27.
 */
public interface HobbyService6 {
    PageInfo<Hobby6> queryAll(Integer pageNum, Integer pageSize);

    Integer addHobby(Hobby6 hobby6);

    Integer deleteHobby(Integer id);

    Integer deleteHobbyList(List<Integer> ids);

    Hobby6 queryHobby(Integer id);

    Integer updateHobby(Hobby6 hobby6);
}
