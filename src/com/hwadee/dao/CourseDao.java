package com.hwadee.dao;


import com.hwadee.model.Course;
import com.hwadee.model.Sc;

import java.util.List;

/**
 * @Author: CKN
 * @Description :查询成绩  退课  选课
 * Date : 2020/7/20 9:35
 */
public interface  CourseDao {

 /**
  * 分页查询
  * @return
  */
 List<Sc> findByPage(int start, int rows,String sno);
 /**
  * 查询记录条数
  * @return
  */
 int FindTotalCount(String sno);

 /**
  * 退课
  * @param cno
  * @param sno
  */
 void deleteCourse(String cno,String sno);

 /**
  * 选课
  * @param cno
  * @param sno
  */
 void addCourse(String cno,String sno);

 /**
  * 根据学生的学号查询选修的课程号
  * @param sno
  * @return
  */
 List<Course> findBySno(String sno);

 /**
  * 查询该学生未选修的课程
  * @param cnos
  * @return
  */
 List<Course> findNotSelectCourse(List<String> cnos);

 /**
  * 没有选修课程的数量
  * @param sno
  * @return
  */
 int FindNotSelectCount(String sno);
}