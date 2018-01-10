package com.bdqn.ssm6.entity;

/**
 * Created by 佳 on 2018/1/5.
 */
public class Course6 {
    private Integer id;
    private String courseName;

    @Override
    public String toString() {
        return "Course6{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
