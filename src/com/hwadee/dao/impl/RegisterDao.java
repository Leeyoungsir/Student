
package com.hwadee.dao.impl;

import com.hwadee.model.Student;
import com.hwadee.model.UserInfo;
import com.hwadee.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *@Author xuiexizhang
 *@Description UserDao
 *
 */

public class RegisterDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    //判断数据库中是否存在用户
    public UserInfo isUser(UserInfo user) {
        String sql = "select * from user where username=?";
        try {
            UserInfo ruser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserInfo.class), user.getUsername());
            return ruser;
        } catch (DataAccessException e) {
            return null;
        }
    }

    public Student isStudent(UserInfo user){
        String sql = "select * from student where sno=?";
        try {
            Student rstudent = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), user.getSno());
            return rstudent;
        } catch (DataAccessException e) {
            return null;
        }
    }

    // 用户信息写入数据库
    public int regist(UserInfo user) {
        if(isUser(user) == null && isStudent(user) != null ){
            String sql = "insert into user(id,username,password,level,sno) values(?,?,?,?,?)";
            return jdbcTemplate.update(sql,user.getId(),user.getUsername(), user.getPassword(),"stu",user.getSno());
        }else {
            return 0;
        }

    }
}
