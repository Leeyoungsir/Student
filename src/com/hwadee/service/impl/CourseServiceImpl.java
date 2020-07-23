package com.hwadee.service.impl;

import com.hwadee.dao.AdminCourseDao;
import com.hwadee.dao.CourseDao;
import com.hwadee.dao.StudentDao;
import com.hwadee.dao.impl.AdminCourseDaoImpl;
import com.hwadee.dao.impl.CourseDaoImpl;
import com.hwadee.dao.impl.StudentDaoImpl;
import com.hwadee.model.*;
import com.hwadee.model.Class;
import com.hwadee.service.AdminCourseService;
import com.hwadee.service.CourseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: CKN
 * @Description :
 * Date : 2020/7/20 18:25
 */
public class CourseServiceImpl implements CourseService {
    CourseDao courseDao= new CourseDaoImpl();
    StudentDao studentDao=new StudentDaoImpl();
    AdminCourseDao adminCourseDao=new AdminCourseDaoImpl();

    /**
     * 选课
     *
     * @param cno
     * @param sno
     */
    @Override
    public void addCourse(String cno, String sno) {
        courseDao.addCourse(cno,sno);
    }

    /**
     * 退课
     *
     * @param cno
     * @param sno
     */
    @Override
    public void deleteCourse(String cno, String sno) {
        courseDao.deleteCourse(cno,sno);
    }

    /**
     * 已选课程
     * @param currentPage
     * @param row
     * @param sno
     * @return
     */
    @Override
    public PageBean<Course> findSelectedCourse(int currentPage, int row,String sno) {
        PageBean<Course> pageBean=new PageBean<Course>();
        int totalcount= courseDao.FindTotalCount(sno);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(row);
        pageBean.setTotalCount(totalcount);
        int start=(currentPage-1)*row;
        List<Sc> list = (List<Sc>)courseDao.findByPage(start, row,sno);
        List<Course> courses=new ArrayList<>();
        for (Sc sc : list) {
            Course byCno = adminCourseDao.findByCno(sc.getCno());
            courses.add(byCno);
        }
        pageBean.setList(courses);
        int totalpage=(totalcount%row)==0 ? (totalcount/row):(totalcount/row)+1;
        pageBean.setTotalPage(totalpage);
        return pageBean;
    }

    /**
     * 该学生没有选修的课程
     *
     * @param currentPage
     * @param rows
     * @param sno
     */
    @Override
    public PageBean<Course> findNotSelectCourse(int currentPage, int rows, String sno) {
        PageBean<Course> coursePageBean=new PageBean<Course>();
        int totalcount= courseDao.FindNotSelectCount(sno);
        coursePageBean.setCurrentPage(currentPage);
        coursePageBean.setRows(rows);
        coursePageBean.setTotalCount(totalcount);
        int start=(currentPage-1)*rows;
        List<Course> selectedCourse = courseDao.findBySno(sno);
        List<String> cnos=new ArrayList<>();
        for (Course course : selectedCourse) {
            cnos.add(course.getCno());
        }
        List<Course> notSelectCourse = courseDao.findNotSelectCourse(start,rows,cnos);
        coursePageBean.setList(notSelectCourse);
        int totalpage=(totalcount%rows)==0 ? (totalcount/rows):(totalcount/rows)+1;
        coursePageBean.setTotalPage(totalpage);
        return coursePageBean;
    }

    /**
     * 成绩单
     * @param currentPage
     * @param rows
     * @param sno
     * @return
     */
    @Override
    public PageBean<Score> findMyScoreList(int currentPage, int rows,String sno) {
        PageBean<Score> pageBean=new PageBean<Score>();
        int totalcount= courseDao.FindTotalCount(sno);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalcount);
        int start=(currentPage-1)*rows;
        List<Sc> list = (List<Sc>)courseDao.findByPage(start, rows,sno);
        List<Score> scores=new ArrayList<>();
        for (Sc sc : list) {
            Course c = adminCourseDao.findByCno(sc.getCno());
            scores.add(new Score(c.getCno(),c.getCname(),c.getCteacher(),c.getCcredit(),sc.getGrade()));
        }
        pageBean.setList(scores);
        int totalpage=(totalcount%rows)==0 ? (totalcount/rows):(totalcount/rows)+1;
        pageBean.setTotalPage(totalpage);
        return pageBean;
    }
}
