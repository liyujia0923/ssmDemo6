package com.bdqn.ssm6.service;

import com.bdqn.ssm6.dao.ScoreMapper6;
import com.bdqn.ssm6.entity.Score6;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2018/1/5.
 */
@Service
public class ScoreService6Impl implements ScoreService6 {
    @Resource
    private ScoreMapper6 scoreMapper6;
    @Override
    public PageInfo<Score6> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Score6> list = scoreMapper6.queryAll();
        PageInfo<Score6> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Score6> queryScore(Integer pageNum, Integer pageSize, Integer gradeId, Integer studentId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Score6> list = scoreMapper6.queryScore(gradeId, studentId);
        PageInfo<Score6> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer deleteScoreById(Integer id) {
        return scoreMapper6.deleteScoreById(id);
    }

    @Override
    public Integer deleteScoreByIds(List<Integer> list) {
        return scoreMapper6.deleteScoreByIds(list);
    }

    @Override
    public Score6 queryScoreByIds(Integer id) {
        return scoreMapper6.queryScoreByIds(id);
    }

    @Override
    public Integer addScore(Score6 score6) {
        return scoreMapper6.addScore(score6);
    }

    @Override
    public Integer updateScore(Score6 score6) {
        return scoreMapper6.updateScore(score6);
    }
}
