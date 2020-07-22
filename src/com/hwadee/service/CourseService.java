package com.hwadee.service;

import com.hwadee.model.*;
import com.hwadee.model.Class;

import java.util.List;
import java.util.Map;

/**
 * @Author: CKN
 * @Description :
 * Date : 2020/7/20 18:22
 */
public interface CourseService {
    /**
     * 查询选修的课程
     * @param currentPage
     * @param row
     * @return
     */
    PageBean<Course> findSelectedCourse(int currentPage, int row,String sno);

    /**
     * 选课
     * @param cno
     * @param sno
     */
    void addCourse(String cno,String sno);

    /**
     * 退课
     * @param
     */
    void deleteCourse(String cno,String sno);

    /**
     * 该学生没有选修的课程
     * @param currentPage
     * @param rows
     */
    PageBean<Course> findNotSelectCourse(int currentPage, int rows,String sno);

    /**
     * 成绩单
     * @param parseInt
     * @param parseInt1
     * @param sno
     * @return
     */
    PageBean<Score> findMyScoreList(int currentPage, int rows,String sno);
}
