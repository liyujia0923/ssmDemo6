package com.bdqn.ssm6.service;

import com.bdqn.ssm6.entity.Grade6;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
public interface GradeService6 {
    public PageInfo<Grade6> queryAll(Integer pageNum, Integer pageSize);

    public Grade6 queryGradeById(Integer id);

    public Integer deleteGradeById(Integer id);

    public Integer deleteGradeByIds(List<Integer> list);

    public Integer addGrade(Grade6 grade6);

    public Integer updateGrade(Grade6 grade6);

    public List<Grade6> queryAll();
}
