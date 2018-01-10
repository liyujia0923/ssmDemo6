package com.bdqn.ssm6.service;

import com.bdqn.ssm6.dao.CourseMapper6;
import com.bdqn.ssm6.entity.Course6;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2018/1/10.
 */
@Service
public class CourseService6Impl implements CourseService6 {
    @Resource
    private CourseMapper6 courseMapper6;
    @Override
    public List<Course6> queryCourse() {
        return courseMapper6.queryCourse();
    }
}
