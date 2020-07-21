package com.hwadee.service.impl;

import com.hwadee.dao.impl.LoginDao;
import com.hwadee.model.UserInfo;

import java.sql.SQLException;

/**
 * @Author xuiexizhang
 * @Description
 * @Date Create in 9:53 2020/7/18
 */

public class LoginService {

    public UserInfo login(String username, String password) throws SQLException {

        LoginDao dao=new LoginDao();
        return dao.login(username,password);

    }
}
