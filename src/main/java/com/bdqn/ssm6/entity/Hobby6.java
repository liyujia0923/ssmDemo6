package com.bdqn.ssm6.entity;

import java.util.Date;

/**
 * Created by 佳 on 2017/12/27.
 */
public class Hobby6 {
    private Integer id;
    private String hobbyName;
    private Date createTime;

    @Override
    public String toString() {
        return "Hobby7{" +
                "id=" + id +
                ", hobbyName='" + hobbyName + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
