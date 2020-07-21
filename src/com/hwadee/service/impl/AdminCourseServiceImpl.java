package com.hwadee.service.impl;

import com.hwadee.dao.AdminCourseDao;
import com.hwadee.dao.impl.AdminCourseDaoImpl;
import com.hwadee.model.Course;
import com.hwadee.model.PageBean;
import com.hwadee.service.AdminCourseService;

import java.util.List;

/**
 * @Author LH
 * @Description 课程service实现类
 * @Date Create in 10:50 2020/7/21
 */
public class AdminCourseServiceImpl implements AdminCourseService {
    AdminCourseDao adminCourseDao =new AdminCourseDaoImpl();
    /**
     * 添加课程
     *
     * @param course
     */
    @Override
    public void add(Course course) {
        adminCourseDao.add(course);
    }

    /**
     * 分页查询
     *
     * @param currentPage
     * @param rows
     * @return
     */
    @Override
    public PageBean<Course> findByPage(int currentPage, int rows) {
        PageBean<Course> coursePageBean=new PageBean<Course>();
        int totalcount= adminCourseDao.FindTotalCount();
        coursePageBean.setCurrentPage(currentPage);
        coursePageBean.setRows(rows);
        coursePageBean.setTotalCount(totalcount);
        int start=(currentPage-1)*rows;
        List list = adminCourseDao.FindByPage(start, rows);
        coursePageBean.setList(list);
        int totalpage=(totalcount%rows)==0 ? (totalcount/rows):(totalcount/rows)+1;
        coursePageBean.setTotalPage(totalpage);
        return coursePageBean;
    }

    /**
     * 根据课程号查询课程
     *
     * @param cno
     * @return
     */
    @Override
    public Course findByCno(String cno) {
        return adminCourseDao.findByCno(cno);
    }

    /**
     * 更新课程
     *
     * @param course
     */
    @Override
    public void update(Course course) {
        adminCourseDao.update(course);
    }

    /**
     * 根据课程号删除课程
     *
     * @param cno
     */
    @Override
    public void delete(String cno) {
        adminCourseDao.delete(cno);
    }
}
