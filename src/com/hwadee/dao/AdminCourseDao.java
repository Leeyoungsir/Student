package com.hwadee.dao;

import com.hwadee.model.Course;

import java.util.List;

/**
 * @Author LH
 * @Description 课程dao接口
 * @Date Create in 10:51 2020/7/21
 */
public interface AdminCourseDao {
    /**
     * 添加课程
     * @param course
     */
    void add(Course course);

    /**
     * 查询记录条数
     * @return
     */
    int FindTotalCount();

    /**
     * 返回从start开始共rows条记录
     * @param start
     * @param rows
     * @return
     */
    List FindByPage(int start, int rows);

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
