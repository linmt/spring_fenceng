package com.lmt.controller;

import com.lmt.entity.Admin;
import com.lmt.service.ApplicationException;
import com.lmt.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 热带雨林 on 2018/11/11.
 */
@Controller
public class LoginController {
    @Resource(name="loginService")
    private LoginService service;

    @RequestMapping("/toLogin.form")
    public String toLogin(){
        System.out.println("toLogin()");
        return "main/login";
    }
    @RequestMapping("/login.form")
    public String login(HttpServletRequest request){
        System.out.println("login()");
        String adminCode=request.getParameter("adminCode");
        String pwd=request.getParameter("pwd");
        System.out.println(adminCode+"  "+pwd);
        Admin admin=service.checkLogin(adminCode,pwd);
        return "redirect:toIndex.form";
    }
    @RequestMapping("/toIndex.form")
    public String toIndex(){
        System.out.println("index()");
        return "main/index";
    }

    @ExceptionHandler
    public String exHandle(Exception e,HttpServletRequest request){
        //应用异常，提示用户采取正确的操作
        if(e instanceof ApplicationException){
            request.setAttribute("error",e.getMessage());
            return "main/login";
        }
        //系统异常，提示用户稍后重试
        return "public/error";
    }
}
