package com.hwadee.service;

/**
 * @Author LH
 * @Description 用户service
 * @Date Create in 15:26 2020/7/21
 */
public interface UserService {
    /**
     * 根据用户id进行更新
     * @param id
     * @param username
     * @param password
     */
    void update(String id,String username,String password);
}
