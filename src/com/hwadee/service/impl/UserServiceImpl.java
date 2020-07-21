package com.hwadee.service.impl;

import com.hwadee.dao.UserDao;
import com.hwadee.dao.impl.UserDaoImpl;
import com.hwadee.service.UserService;

/**
 * @Author LH
 * @Description
 * @Date Create in 15:27 2020/7/21
 */
public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    /**
     * 根据用户id进行更新
     *
     * @param id
     * @param username
     * @param password
     */
    @Override
    public void update(String id, String username, String password) {
        userDao.update(Integer.parseInt(id),username,password);
    }
}
