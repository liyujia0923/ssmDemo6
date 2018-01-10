package com.bdqn.ssm6.service;

import com.bdqn.ssm6.dao.GradeMapper6;
import com.bdqn.ssm6.dao.StudentNumMapper6;
import com.bdqn.ssm6.entity.Grade6;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
@Service
public class GradeService6Impl implements GradeService6 {
    @Resource
    private GradeMapper6 gradeMapper6;
    @Resource
    private StudentNumMapper6 studentNumMapper6;
    @Override
    public PageInfo<Grade6> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Grade6> list = gradeMapper6.queryAll();
        PageInfo<Grade6> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Grade6 queryGradeById(Integer id) {
        return gradeMapper6.queryGradeById(id);
    }

    @Override
    public Integer deleteGradeById(Integer id) {
        return gradeMapper6.deleteGradeById(id);
    }

    @Override
    public Integer deleteGradeByIds(List<Integer> list) {
        return gradeMapper6.deleteGradeByIds(list);
    }

    @Override
    public Integer addGrade(Grade6 grade6) {
        gradeMapper6.addGrade(grade6);
        Integer gradeId = grade6.getId();
        return studentNumMapper6.addStudentNum(gradeId);
    }

    @Override
    public Integer updateGrade(Grade6 grade6) {
        return gradeMapper6.updateGrade(grade6);
    }

    @Override
    public List<Grade6> queryAll() {
        return gradeMapper6.queryAll();
    }

}
