package com.lmt.dao;

import com.lmt.annotation.MybatisDao;
import com.lmt.entity.Admin;

/**
 * Created by 张洲徽 on 2018/11/9.
 */
@MybatisDao
public interface AdminDao {
    public Admin findByAdminCode(String adminCode);
}
