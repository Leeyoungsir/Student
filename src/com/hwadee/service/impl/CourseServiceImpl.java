package com.hwadee.service.impl;

import com.hwadee.dao.CourseDao;
import com.hwadee.dao.impl.CourseDaoImpl;
import com.hwadee.model.Class;
import com.hwadee.model.Course;
import com.hwadee.model.PageBean;
import com.hwadee.model.Sc;
import com.hwadee.model.Student;
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
    @Override
    /**
     * 选课
     */
    public void addCourse(Sc sc) {
      courseDao.addCourse(sc) ;
    }

    /**
     * 退课
     * @param sc
     */
    @Override
    public void deleteCourse(Sc sc) {
    courseDao.deleteCourse(sc);
    }

    /**
     * 查询成绩
     * @param currentPage
     * @param row
     * @param sno
     * @return
     */
    @Override
    public PageBean<Sc> findByPage(int currentPage, int row,String sno) {
        PageBean<Sc> scPageBean=new PageBean<Sc>();
        int totalcount= courseDao.FindTotalCount();
        scPageBean.setCurrentPage(currentPage);
        scPageBean.setRows(row);
        scPageBean.setTotalCount(totalcount);
        scPageBean.setSno(sno);
        int start=(currentPage-1)*row;
        List list = courseDao.findByPage(start, row,sno);
        scPageBean.setList(list);
        int totalpage=(totalcount%row)==0 ? (totalcount/row):(totalcount/row)+1;
        scPageBean.setTotalPage(totalpage);
        return scPageBean;
    }


}
