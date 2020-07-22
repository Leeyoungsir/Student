package com.hwadee.service.impl;

import com.hwadee.dao.impl.FindPasswordDao;

import java.sql.SQLException;

/**
 * @Author xuiexizhang
 * @Description
 * @Date Create in 9:50 2020/7/18
 */

public class FindPasswordService {
    public boolean findPassword(String username, String password,String sno) throws SQLException {

        FindPasswordDao dao=new FindPasswordDao();

        return dao.findPassword(username,password,sno)>0?true:false;

    }
}
