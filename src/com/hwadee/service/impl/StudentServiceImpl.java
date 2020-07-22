package com.hwadee.service.impl;

import com.hwadee.dao.StudentDao;
import com.hwadee.dao.impl.StudentDaoImpl;
import com.hwadee.model.PageBean;
import com.hwadee.model.Student;
import com.hwadee.service.StudentService;

import java.util.List;
import java.util.Map;

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
    public boolean add(Student student) {
        Student stu = studentDao.findBySno(Integer.parseInt(student.getSno()));
        if (stu==null){
            studentDao.add(student);
        }else {
            return false;
        }
        return true;

    }

    /**
     * 分页查询
     */
    @Override
    public PageBean<Student> findByPage(int currentPage, int rows, Map<String,String[]> conditionMap) {
        PageBean<Student> userPageBean=new PageBean<Student>();
        int totalcount=studentDao.FindTotalCount(conditionMap);
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setRows(rows);
        userPageBean.setTotalCount(totalcount);
        int start=(currentPage-1)*rows;
        List list = studentDao.FindByPage(start, rows,conditionMap);
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
