package com.hwadee.service.impl;

import com.hwadee.dao.StudentDao;
import com.hwadee.dao.impl.StudentDaoImpl;
import com.hwadee.model.PageBean;
import com.hwadee.model.Student;
import com.hwadee.service.StudentService;

import java.util.List;

/**
 * @Author LH
 * @Description
 * @Date Create in 15:41 2020/7/20
 */
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao=new StudentDaoImpl();
    /**
     * 添加学生信息
     *
     * @param student
     */
    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    /**
     * 分页查询
     */
    @Override
    public PageBean<Student> findByPage(int currentPage, int rows) {
        PageBean<Student> userPageBean=new PageBean<Student>();
        int totalcount=studentDao.FindTotalCount();
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setRows(rows);
        userPageBean.setTotalCount(totalcount);
        int start=(currentPage-1)*rows;
        List list = studentDao.FindByPage(start, rows);
        userPageBean.setList(list);
        int totalpage=(totalcount%rows)==0 ? (totalcount/rows):(totalcount/rows)+1;
        userPageBean.setTotalPage(totalpage);
        return userPageBean;
    }

    /**
     * 根据学号删除学生
     *
     * @param sno
     */
    @Override
    public void delete(String sno) {
        studentDao.delete(Integer.parseInt(sno));
    }

    /**
     * 根据学号查询学生信息
     *
     * @param sno
     */
    @Override
    public Student findBySno(String sno) {
        return studentDao.findBySno(Integer.parseInt(sno));
    }

    /**
     * 更新学生信息
     *
     * @param student
     */
    @Override
    public void update(Student student) {
        studentDao.update(student);
    }
}
