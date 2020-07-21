package com.hwadee.dao;

/**
 * @Author LH
 * @Description 用户dao接口
 * @Date Create in 15:28 2020/7/21
 */
public interface UserDao {
    /**
     * 根据id修改用户表
     * @param id
     * @param username
     * @param password
     */
    void update(int id,String username,String password);
}
