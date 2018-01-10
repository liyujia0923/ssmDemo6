package com.bdqn.ssm6.dao;

import com.bdqn.ssm6.entity.Student6;

import java.util.List;

/**
 * Created by 佳 on 2017/12/14.
 */
public interface StudentMapper6 {
    public List<Student6> queryAll();

    public Integer delelteStudentByIds(List<Integer> list);

    public Integer addStudent(Student6 student6);

    public Student6 queryStudentById(Integer id);

    public Integer updateStudent(Student6 student6);

    public List<Student6> queryStudentByGradeId(Integer gradeId);
}
