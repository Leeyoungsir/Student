package com.hwadee.service;

import com.hwadee.model.PageBean;
import com.hwadee.model.Student;

import java.util.Map;

/**
 * @Author LH
 * @Description 学生service接口
 * @Date Create in 15:40 2020/7/20
 */
public interface StudentService {
    /**
     * 添加学生信息
     * @param student
     */
    void add(Student student);

    /**
     * 分页查询
     */
    PageBean<Student> findByPage(int currentPage, int row, Map<String,String[]> conditionMap);

    /**
     * 根据学号删除学生
     * @param sno
     */
    void delete(String sno);

    /**
     * 根据学号查询学生信息
     * @param sno
     */
    Student findBySno(String sno);

    /**
     * 更新学生信息
     * @param student
     */
    void update(Student student);
}
