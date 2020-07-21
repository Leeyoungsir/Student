package com.hwadee.service.impl;

import com.hwadee.dao.ClassDao;
import com.hwadee.dao.StudentDao;
import com.hwadee.dao.impl.ClassDaoImpl;
import com.hwadee.dao.impl.StudentDaoImpl;
import com.hwadee.model.Class;
import com.hwadee.model.PageBean;
import com.hwadee.service.ClassService;

import java.util.List;

/**
 * @Author LH
 * @Description Class实现类
 * @Date Create in 9:38 2020/7/21
 */
public class ClassServiceImpl implements ClassService {
    ClassDao classDao=new ClassDaoImpl();
    StudentDao studentDao=new StudentDaoImpl();

    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @return
     */
    @Override
    public PageBean<Class> findByPage(int currentPage, int rows) {
        PageBean<Class> classPageBean=new PageBean<>();
        int totalcount=classDao.FindTotalCount();
        classPageBean.setCurrentPage(currentPage);
        classPageBean.setRows(rows);
        classPageBean.setTotalCount(totalcount);
        int start=(currentPage-1)*rows;
        List<Class> list = (List<Class>) classDao.findByPage(start, rows);
        for (Class c : list) {
            int member=studentDao.findByC_no(c.getC_no());
            c.setMember(member);
        }
        classPageBean.setList(list);
        int totalpage=(totalcount%rows)==0 ? (totalcount/rows):(totalcount/rows)+1;
        classPageBean.setTotalPage(totalpage);
        return classPageBean;
    }

    /**
     * 添加班级
     *
     * @param c
     */
    @Override
    public void add(Class c) {
        classDao.add(c);
    }
}
