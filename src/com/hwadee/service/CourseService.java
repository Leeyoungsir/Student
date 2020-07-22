package com.hwadee.service;

import com.hwadee.model.Class;
import com.hwadee.model.Course;
import com.hwadee.model.PageBean;
import com.hwadee.model.Sc;
import com.hwadee.model.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author: CKN
 * @Description :
 * Date : 2020/7/20 18:22
 */
public interface CourseService {
    /**
     * 分页查询
     * @param currentPage
     * @param row
     * @return
     */
    PageBean<Sc> findByPage(int currentPage, int row,String sno);
    /**
     * 选课
     * @param sc
     */
    void addCourse(Sc sc);

    /**
     * 退课
     * @param
     */
    void deleteCourse(Sc sc);



}
