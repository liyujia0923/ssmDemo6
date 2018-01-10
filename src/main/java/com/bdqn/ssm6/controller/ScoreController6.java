package com.bdqn.ssm6.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.ssm6.entity.Course6;
import com.bdqn.ssm6.entity.Score6;
import com.bdqn.ssm6.service.CourseService6;
import com.bdqn.ssm6.service.ScoreService6;
import com.bdqn.ssm6.util.Message;
import com.bdqn.ssm6.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 佳 on 2017/12/26.
 */
@Controller
@RequestMapping("score")
public class ScoreController6 {
    @Resource
    private ScoreService6 scoreService6;
    @Resource
    private CourseService6 courseService6;
    @RequestMapping(value = "toScore")
    public String toScore() {
        return "score/score";
    }

    @ResponseBody
    @RequestMapping(value = "queryAll",method = RequestMethod.GET,
    produces = {"application/json;charset=UTF-8"})
    public String queryAll(Integer page, Integer rows,Integer gradeId,Integer studentId) {
       /* PageInfo<Score6> pageInfo = scoreService6.queryAll(page, rows);
        PageUtil<Score6> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);*/
        if (gradeId !=null && gradeId == -1) {
            gradeId = null;
        }
        if (studentId != null && studentId == -1) {
            studentId = null;
        }
        PageInfo<Score6> pageInfo = scoreService6.queryScore(page, rows, gradeId, studentId);
        PageUtil<Score6> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);
    }
    @ResponseBody
    @RequestMapping(value = "deleteScoreById",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteScoreById(Integer id) {
        int n = scoreService6.deleteScoreById(id);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "deleteScoreByIds",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteScoreByIds(String ids) {
        String[] idArray = ids.split(",");
        List<Integer> list = new ArrayList<>();
        if (idArray != null && idArray.length > 0) {
            for (String s : idArray) {
                list.add(Integer.parseInt(s));
            }
        }
        int n = scoreService6.deleteScoreByIds(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "queryScoreById",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryScoreById(Integer id) {
        Score6 score6 = scoreService6.queryScoreByIds(id);
        return JSON.toJSONString(score6);
    }
    @ResponseBody
    @RequestMapping(value = "queryCourse",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryCourse() {
        List<Course6> list = courseService6.queryCourse();
        return JSON.toJSONString(list);
    }
    @ResponseBody
    @RequestMapping(value = "addScore",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String addScore(Score6 score6) {
        int n = scoreService6.addScore(score6);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "updateScore",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String updateScore(Score6 score6) {
        int n = scoreService6.updateScore(score6);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
}
