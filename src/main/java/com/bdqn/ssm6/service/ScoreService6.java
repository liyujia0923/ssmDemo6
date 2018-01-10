package com.bdqn.ssm6.service;

import com.bdqn.ssm6.entity.Score6;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2018/1/5.
 */
public interface ScoreService6 {
    public PageInfo<Score6> queryAll(Integer pageNum,Integer pageSize);

    public PageInfo<Score6> queryScore(Integer pageNum,Integer pageSize,
                                       Integer gradeId,Integer studentId);

    public Integer deleteScoreById(Integer id);

    public Integer deleteScoreByIds(List<Integer> list);

    public Score6 queryScoreByIds(Integer id);

    public Integer addScore(Score6 score6);

    public Integer updateScore(Score6 score6);
}
