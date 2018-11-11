package com.lmt.service;

import com.lmt.entity.Admin;

/**
 * Created by 热带雨林 on 2018/11/11.
 */
public interface LoginService {
    //如果在此处抛出SQLException异常，是不好的，该异常是JDBC专有的，意味着以后都只能用JDBC技术访问数据库
    public Admin checkLogin(String adminCode,String pwd);
}
