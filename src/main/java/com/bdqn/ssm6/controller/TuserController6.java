package com.bdqn.ssm6.controller;

import com.bdqn.ssm6.entity.Tuser6;
import com.bdqn.ssm6.service.TuserService6;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by 佳 on 2017/12/7.
 */
@Controller
@RequestMapping("user")
public class TuserController6 {
    @Resource
    private TuserService6 tuserService6;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Tuser6 tuser6, HttpSession session, Model model) {
        Tuser6 loginUser = tuserService6.login(tuser6);
        if (null != loginUser) {
            session.setAttribute("loginUser", loginUser);
            return "comm/main";
        }
        model.addAttribute("message", "用户名错误或密码错误");
        return "index";
    }

    @RequestMapping(value = "loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("loginUser");
        return "index_bootstrap";
    }
}
