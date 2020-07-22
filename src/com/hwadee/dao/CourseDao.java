package com.hwadee.dao;


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
 int FindTotalCount();

 /**
  * 退课
  * @param sc
  */
 void deleteCourse(Sc sc);

 /**
  * 选课
  * @param sc
  */
 void addCourse(Sc sc);




}