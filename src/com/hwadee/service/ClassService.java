package com.hwadee.service;

import com.hwadee.model.Class;
import com.hwadee.model.PageBean;

import java.util.List;

/**
 * @Author LH
 * @Description 班级接口
 * @Date Create in 9:37 2020/7/21
 */
public interface ClassService {
    /**
     * 分页查询
     * @param currentPage
     * @param row
     * @return
     */
    PageBean<Class> findByPage(int currentPage, int row);

    /**
     * 添加班级
     * @param c
     */
    void add(Class c);
}
