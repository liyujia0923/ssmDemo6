package com.bdqn.ssm6.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bdqn.ssm6.entity.Grade6;
import com.bdqn.ssm6.entity.Student6;
import com.bdqn.ssm6.service.GradeService6;
import com.bdqn.ssm6.service.StudentService6;
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
 * Created by 佳 on 2017/12/14.
 */
@Controller
@RequestMapping("student")
public class StudentController6 {
    @Resource
    private StudentService6 studentService6;
    @Resource
    private GradeService6 gradeService6;

    @RequestMapping(value = "queryAll")
    public String queryAll(Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Student6> pageInfo = studentService6.queryAll(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "student/student";
    }

    @ResponseBody
    @RequestMapping(value = "deleteStudentByIds",method = RequestMethod.POST,
    produces = {"application/json;charset=UTF-8"})
    public String deleteStudentByIds(String studentId) {
        String[] studentArray = studentId.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : studentArray) {
            list.add(Integer.parseInt(s));
        }
        int n = studentService6.delelteStudentByIds(list);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.success());
    }
    @ResponseBody
    @RequestMapping(value = "queryGrade",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryGrade() {
        List<Grade6> list = gradeService6.queryAll();
        return JSONArray.toJSONString(list);
    }
    @ResponseBody
    @RequestMapping(value = "addStudent",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String addStudent(Student6 student6) {
        int n = studentService6.addStudent(student6);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.success());
    }
    @ResponseBody
    @RequestMapping(value = "queryStudentById",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryStudentById(Integer id) {
        Student6 student6 = studentService6.queryStudentById(id);
        return JSON.toJSONString(student6);
    }
    @ResponseBody
    @RequestMapping(value = "updateStudent",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String updateStudent(Student6 student6) {
        int n = studentService6.updateStudent(student6);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.success());
    }
    @ResponseBody
    @RequestMapping(value = "queryStudentByGradeId",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    public String queryStudentByGradeId(Integer gradeId) {
        List<Student6> list = studentService6.queryStudentByGradeId(gradeId);
        return JSON.toJSONString(list);
    }
}
