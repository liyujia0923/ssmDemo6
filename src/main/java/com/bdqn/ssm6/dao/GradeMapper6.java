package com.bdqn.ssm6.dao;

import com.bdqn.ssm6.entity.Grade6;

import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
public interface GradeMapper6 {
    public List<Grade6> queryAll();

    public Grade6 queryGradeById(Integer id);

    public Integer deleteGradeById(Integer id);

    public Integer deleteGradeByIds(List<Integer> list);

    public Integer addGrade(Grade6 grade6);

    public Integer updateGrade(Grade6 grade6);


}
