package com.hwadee.dao.impl;

import com.hwadee.dao.StudentDao;
import com.hwadee.model.Student;
import com.hwadee.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 添加学生
     *
     * @param student
     */
    @Override
    public void add(Student student) {
        String sql="insert into student values(?,?,?,?,?,?,?)";
        template.update(sql,student.getSno(),student.getSname(),student.getSsex(),student.getSage(),student.getSyear(),student.getSmajor(),student.getC_no());

    }

    /**
     * 返回记录总条数
     *
     * @return
     */
    @Override
    public int FindTotalCount() {
        String sql="select count(*) from student";
        Integer integer = template.queryForObject(sql, int.class);
        return integer;
    }

    /**
     * 分页查询，从start开始，共row条记录
     *
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List FindByPage(int start, int rows) {
        String sql="select * from Student limit ?,? ";
        List<Student> list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class),start,rows);
        return list;
    }

    /**
     * 根据学号删除学生
     *
     * @param parseInt
     */
    @Override
    public void delete(int parseInt) {
        String sql="delete from student where sno=?";
        template.update(sql,parseInt);
    }

    @Override
    public Student findBySno(int sno) {
        String sql="select * from student where sno = ?";
        Student student = template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),sno);
        return student;
    }

    /**
     * 更新学生信息
     *
     * @param student
     */
    @Override
    public void update(Student student) {
        String sql="update student set sname=?,ssex=?,sage=?,syear=?,smajor=? where sno=?";
        template.update(sql,student.getSname(),student.getSsex(),student.getSage(),student.getSyear(),student.getSmajor(),student.getSno());
    }
}
