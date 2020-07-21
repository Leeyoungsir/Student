package com.hwadee.dao.impl;

import com.hwadee.model.UserInfo;
import com.hwadee.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * @Author xuiexizhang
 * @Description
 * @Date Create in 9:55 2020/7/18
 */

public class LoginDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public UserInfo login(String username, String password) throws SQLException {
        // TODO Auto-generated method stub
        String sql = "select * from user where username=?";
        //查询密码与账户匹配的user
        try {
            UserInfo ruser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserInfo.class), username);
            if (password.equals(ruser.getPassword())){
                return ruser;
            }
            return null;
        } catch (DataAccessException e) {
            return null;
        }

    }


}
