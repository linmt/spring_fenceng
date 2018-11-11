package com.lmt.service;

import com.lmt.dao.AdminDao;
import com.lmt.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 热带雨林 on 2018/11/11.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{
    private AdminDao adminDao;
    @Autowired
    public void setAdminDao(AdminDao adminDao){
        this.adminDao=adminDao;
    }
    public Admin checkLogin(String adminCode, String pwd) {
        Admin admin=adminDao.findByAdminCode(adminCode);
        if (admin==null){
            throw new ApplicationException("账号不存在");
        }
        if (!admin.getPassword().equals(pwd)){
            throw new ApplicationException("密码错误");
        }
        return admin;
    }
}
