package com.hwadee.service.impl;

import com.hwadee.dao.impl.FindPasswordDao;

import java.sql.SQLException;

public class FindPasswordService {
    public boolean findPassword(String username, String password,String sno) throws SQLException {

        FindPasswordDao dao=new FindPasswordDao();

        return dao.findPassword(username,password,sno)>0?true:false;

    }
}
