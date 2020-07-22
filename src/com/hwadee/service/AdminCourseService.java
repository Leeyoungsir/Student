package com.hwadee.service;

import com.hwadee.model.Course;
import com.hwadee.model.PageBean;

/**
 * @Author LH
 * @Description 课程service接口
 * @Date Create in 10:49 2020/7/21
 */
public interface AdminCourseService {
    /**
     * 添加课程
     * @param course
     */
    boolean add(Course course);

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @return
     */
    PageBean<Course> findByPage(int currentPage, int rows);

    /**
     * 根据课程号查询课程
     * @param cno
     * @return
     */
    Course findByCno(String cno);

    /**
     * 更新课程
     * @param course
     */
    void update(Course course);

    /**
     * 根据课程号删除课程
     * @param cno
     */
    void delete(String cno);
}
