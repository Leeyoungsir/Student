package com.hwadee.service.impl;

import com.hwadee.dao.impl.RegisterDao;
import com.hwadee.model.UserInfo;

/**
 * @Author xuiexizhang
 * @Description UserService
 * @Date Create in 9:50 2020/7/18
 */

public class RegisterService {

    public boolean register(UserInfo user) {
        // TODO Auto-generated method stub
        RegisterDao dao=new RegisterDao();
        int result=0;
        result = dao.regist(user);
        return result>0?true:false;
    }

//    public static void main(String[] args) {
//
//        UserInfo user = new UserInfo(01, "xuexizhang", "1234","stu","s01");
//        RegisterService rs = new RegisterService();
//        System.out.println(user);
//        if(rs.register(user)){
//            System.out.println("ture");
//        }else{
//            System.out.println("false");
//        }
//
//    }

}