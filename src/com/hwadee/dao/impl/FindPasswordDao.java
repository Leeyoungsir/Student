package com.hwadee.dao.impl;

import com.hwadee.dao.UserDao;
import com.hwadee.model.Student;
import com.hwadee.model.UserInfo;
import com.hwadee.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author xuiexizhang
 * @Description
 * @Date Create in 9:50 2020/7/18
 */

public class FindPasswordDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    public UserInfo isUser(String username ,String sno) {
        String sql = "select * from user where username=? And sno=? ";
        try {
            UserInfo ruser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserInfo.class), username,sno);
            return ruser;
        } catch (DataAccessException e) {
            return null;
        }
    }

    // 用户信息写入数据库
    public int findPassword(String username,String password,String sno) {
        UserInfo user = isUser(username,sno);
        if( user!= null){
            String sql = "UPDATE user SET password = ? WHERE (id = ?);";
            return jdbcTemplate.update(sql,password,user.getId());
        }else {
            return 0;
        }

    }
}
