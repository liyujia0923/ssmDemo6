package com.bdqn.ssm6.service;

import com.bdqn.ssm6.dao.StudentMapper6;
import com.bdqn.ssm6.dao.StudentNumMapper6;
import com.bdqn.ssm6.entity.Student6;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/14.
 */
@Service
public class StudentService6Impl implements StudentService6 {
    @Resource
    private StudentMapper6 studentMapper6;
    @Resource
    private StudentNumMapper6 studentNumMapper6;
    @Override
    public PageInfo<Student6> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student6> list = studentMapper6.queryAll();
        PageInfo<Student6> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer delelteStudentByIds(List<Integer> list) {
        return studentMapper6.delelteStudentByIds(list);
    }

    @Override
    public Integer addStudent(Student6 student6) {
        Integer gradeId = student6.getGrade6().getId();
        studentNumMapper6.updateMaxNumByGradeId(gradeId);
        Integer maxNum = studentNumMapper6.queryMaxNumByGradeId(gradeId);
        String gradeName = student6.getGrade6().getGradeName();
        String studentNum = gradeName + maxNum;
        int n = 15 - studentNum.length();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                gradeName += 0;
                
            }
        }
        studentNum = gradeName + maxNum;
        student6.setStudentNum(studentNum);

        return studentMapper6.addStudent(student6);
    }

    @Override
    public Student6 queryStudentById(Integer id) {
        return studentMapper6.queryStudentById(id);
    }

    @Override
    public Integer updateStudent(Student6 student6) {
        return studentMapper6.updateStudent(student6);
    }

    @Override
    public List<Student6> queryStudentByGradeId(Integer gradeId) {
        return studentMapper6.queryStudentByGradeId(gradeId);
    }

}
