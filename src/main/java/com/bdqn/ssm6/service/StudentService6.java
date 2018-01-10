package com.bdqn.ssm6.service;

import com.bdqn.ssm6.entity.Student6;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 佳 on 2017/12/14.
 */
public interface StudentService6 {
    public PageInfo<Student6> queryAll(Integer pageNum, Integer pageSize);

    public Integer delelteStudentByIds(List<Integer> list);

    public Integer addStudent(Student6 student6);

    public Student6 queryStudentById(Integer id);

    public Integer updateStudent(Student6 student6);

    public List<Student6> queryStudentByGradeId(Integer gradeId);
}
