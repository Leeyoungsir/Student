package com.hwadee.dao;

import com.hwadee.model.Class;

import java.util.List;

/**
 * @Author LH
 * @Description 班级dao接口
 * @Date Create in 9:43 2020/7/21
 */
public interface ClassDao {
    /**
     * 分页查询
     * @return
     */
    List<Class> findByPage(int start, int rows);

    /**
     * 查询记录条数
     * @return
     */
    int FindTotalCount();

    /**
     * 添加班级
     * @param c
     */
    void add(Class c);

    /**
     * 根据班级号查询班级
     * @param c_no
     * @return
     */
    Class findByC_no(String c_no);
}
