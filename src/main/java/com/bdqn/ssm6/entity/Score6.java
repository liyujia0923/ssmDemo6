package com.bdqn.ssm6.entity;

/**
 * Created by 佳 on 2018/1/5.
 */
public class Score6 {
    private Integer id;
    private Double score;
    private Student6 student6;
    private Course6 course6;

    @Override
    public String toString() {
        return "Score6{" +
                "id=" + id +
                ", score=" + score +
                ", student6=" + student6 +
                ", course6=" + course6 +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Student6 getStudent6() {
        return student6;
    }

    public void setStudent6(Student6 student6) {
        this.student6 = student6;
    }

    public Course6 getCourse6() {
        return course6;
    }

    public void setCourse6(Course6 course6) {
        this.course6 = course6;
    }
}
