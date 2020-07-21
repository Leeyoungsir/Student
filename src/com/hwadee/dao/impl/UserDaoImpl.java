package com.hwadee.dao.impl;

import com.hwadee.dao.UserDao;
import com.hwadee.service.UserService;
import com.hwadee.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author LH
 * @Description 用户dao实现类
 * @Date Create in 15:29 2020/7/21
 */
public class UserDaoImpl implements UserDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 根据id修改用户表
     *
     * @param id
     * @param username
     * @param password
     */
    @Override
    public void update(int id, String username, String password) {
        String sql="update user set username=? , password=?,where id=?";
        template.update(sql,username,password,id);
    }
}
