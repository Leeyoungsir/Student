package com.hwadee.dao;

import com.hwadee.model.Student;

import java.util.List;

/**
 *  LH
 * 学生dao接口
 */
public interface StudentDao {
    /**
     * 添加学生
     * @param student
     */
    void add(Student student);

    /**
     * 返回记录总条数
     * @return
     */
    int FindTotalCount();

    /**
     * 分页查询，从start开始，共row条记录
     * @param start
     * @param rows
     * @return
     */
    List FindByPage(int start, int rows);

    /**
     * 根据学号删除学生
     * @param parseInt
     */
    void delete(int parseInt);

    Student findBySno(int parseInt);

    /**
     * 更新学生信息
     * @param student
     */
    void update(Student student);
}
