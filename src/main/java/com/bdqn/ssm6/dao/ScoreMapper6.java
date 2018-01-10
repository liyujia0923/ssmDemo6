package com.bdqn.ssm6.dao;

import com.bdqn.ssm6.entity.Score6;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 佳 on 2018/1/5.
 */
public interface ScoreMapper6 {
    public List<Score6> queryAll();

    public List<Score6> queryScore(@Param("gradeId") Integer gradeId,
                                   @Param("studentId") Integer studentId);

    public Integer deleteScoreById(Integer id);

    public Integer deleteScoreByIds(List<Integer> list);

    public Score6 queryScoreByIds(Integer id);

    public Integer addScore(Score6 score6);

    public Integer updateScore(Score6 score6);

}
