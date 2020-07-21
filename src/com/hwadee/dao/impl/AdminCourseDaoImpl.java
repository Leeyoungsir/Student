package com.hwadee.dao.impl;

import com.hwadee.dao.AdminCourseDao;
import com.hwadee.model.Course;
import com.hwadee.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author LH
 * @Description 课程实现dao
 * @Date Create in 10:51 2020/7/21
 */
public class AdminCourseDaoImpl implements AdminCourseDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 添加课程
     *
     * @param course
     */
    @Override
    public void add(Course course) {
        String sql="insert into course values(?,?,?,?)";
        template.update(sql,course.getCno(),course.getCname(),course.getCteacher(),course.getCcredit());

    }

    /**
     * 查询记录条数
     *
     * @return
     */
    @Override
    public int FindTotalCount() {
        String sql="select count(*) from course";
        Integer integer = template.queryForObject(sql, Integer.class);
        return integer;
    }
    /**
     * 返回从start开始共rows条记录
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List FindByPage(int start, int rows) {
        String sql="select * from course limit ?,?";
        List<Course> query = template.query(sql, new BeanPropertyRowMapper<Course>(Course.class), start, rows);
        return query;
    }

    /**
     * 根据课程号查询课程
     *
     * @param cno
     * @return
     */
    @Override
    public Course findByCno(String cno) {
        String sql="select * from course where cno=?";
        Course course = template.queryForObject(sql, new BeanPropertyRowMapper<Course>(Course.class), cno);
        return course;
    }

    /**
     * 更新课程
     *
     * @param course
     */
    @Override
    public void update(Course course) {
        String sql="update course set cname=?,cteacher=?,ccredit=? where cno=? ";
        template.update(sql,course.getCname(),course.getCteacher(),course.getCcredit(),course.getCno());
    }

    /**
     * 根据课程号删除课程
     *
     * @param cno
     */
    @Override
    public void delete(String cno) {
        String sql="delete from course where cno=?";
        template.update(sql,cno);
    }
}
