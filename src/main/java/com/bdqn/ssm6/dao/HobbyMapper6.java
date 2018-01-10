package com.bdqn.ssm6.dao;

import com.bdqn.ssm6.entity.Hobby6;

import java.util.List;

/**
 * Created by 佳 on 2017/12/27.
 */
public interface HobbyMapper6 {
    List<Hobby6> queryAll();

    Integer addHobby(Hobby6 hobby6);

    Integer deleteHobby(Integer id);

    Integer deleteHobbyList(List<Integer> ids);

    Hobby6 queryHobby(Integer id);

    Integer updateHobby(Hobby6 hobby6);
}
