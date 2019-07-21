package com.fu.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class WebController {

    @RequestMapping("login")
    @ResponseBody
    public String login(String wid, String password, HttpServletRequest request){
        if(!StringUtils.isEmpty(wid) && !StringUtils.isEmpty(password) && "123456".equals(wid) && "123456".equals(password)){
            request.getSession().setAttribute("wid", wid);
            return "200";
        }else{
            return "500";
        }
    }

    @RequestMapping("loginsuccess")
    public String loginsuccess(String wid, String password){
        return "redirect:../webtest/manage.html";
    }
}
