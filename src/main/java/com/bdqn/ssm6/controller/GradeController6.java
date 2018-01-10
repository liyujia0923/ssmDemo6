package com.bdqn.ssm6.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.ssm6.entity.Grade6;
import com.bdqn.ssm6.service.GradeService6;
import com.bdqn.ssm6.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 佳 on 2017/12/9.
 */
@Controller
@RequestMapping("grade")
public class GradeController6 {
    @Resource
    private GradeService6 gradeService6;

    @RequestMapping("toGrade")
    public String toGrade(Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Grade6> pageInfo = gradeService6.queryAll(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "grade/grade";
    }
    @ResponseBody
    @RequestMapping(value ="queryGradeById",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryGradeById(Integer gradeId){
        Grade6 grade=gradeService6.queryGradeById(gradeId);
        return JSON.toJSONString(grade);
    }

    @ResponseBody
    @RequestMapping(value = "deleteGradeById",method = RequestMethod.POST,
            produces ={"application/json;charset=UTF-8"} )
    public String deleteGradeById(Integer gradeId) {
        int n=gradeService6.deleteGradeById(gradeId);
        if(n>0){
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "deleteGradeByIds",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String deleteGradeByIds(String gradeIds){
        String[] gradeIdArray=gradeIds.split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (String s : gradeIdArray) {
            list.add(Integer.parseInt(s));
        }

        int n=gradeService6.deleteGradeByIds(list);

        if(n>0){
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    @ResponseBody
    @RequestMapping(value = "addGrade",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String addGrade(Grade6 grade6) {
        int n = gradeService6.addGrade(grade6);
        if(n>0){
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());

    }
    @ResponseBody
    @RequestMapping(value = "updateGrade",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String updateGrade(Grade6 grade6) {
        int n = gradeService6.updateGrade(grade6);
        if(n>0){
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
}
