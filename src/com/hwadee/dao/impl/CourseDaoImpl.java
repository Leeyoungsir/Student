package com.hwadee.dao.impl;

import com.hwadee.dao.CourseDao;

import com.hwadee.model.Course;
import com.hwadee.model.Sc;
import com.hwadee.model.Student;
import com.hwadee.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: CKN
 * @Description :
 * Date : 2020/7/20 9:37
 */
public class CourseDaoImpl  implements CourseDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 分页查询
     * @return
     */
    @Override
    public List findByPage(int start,int rows,String sno) {
        String sql="select * from sc where sno=? limit ?,? ";
        List<Sc> list = template.query(sql, new BeanPropertyRowMapper<Sc>(Sc.class),sno,start,rows);
        return list;
    }

    /**
     * 记录查询条数
     * @return
     */
    @Override
    public int FindTotalCount(String sno) {
        String sql="select count(*) from sc where sno=? ";
        Integer integer = template.queryForObject(sql, Integer.class,sno);
        return integer;
    }

    /**
     * 退课
     *
     * @param cno
     * @param sno
     */
    @Override
    public void deleteCourse(String cno, String sno) {
        String sql="delete from sc  where sno=? and cno=?";
        template.update(sql,sno,cno);

    }

    /**
     * 选课
     *
     * @param cno
     * @param sno
     */
    @Override
    public void addCourse(String cno, String sno) {
        String sql="insert into sc(sno,cno) values(?,?)";
        template.update(sql,sno,cno);
    }

    /**
     * 根据学生的学号查询选修的课程号
     *
     * @param sno
     * @return
     */
    @Override
    public List<Course> findBySno(String sno) {
        String sql="select * from sc where sno=?";
        List<Course> query = template.query(sql, new BeanPropertyRowMapper<>(Course.class), sno);
        return query;
    }

    /**
     * 查询该学生未选修的课程
     *
     * @param cnos
     * @return
     */
    @Override
    public List<Course> findNotSelectCourse(int start, int rows,List<String> cnos) {
        if (cnos.isEmpty()){
            String sql="select * from course limit ?,?";
            return template.query(sql,new BeanPropertyRowMapper<>(Course.class),start,rows);
        }else {
            String sql="select * from course where cno not in(";
            StringBuffer sb = new StringBuffer(sql);
            for (int i = 0; i < cnos.size(); i++) {
                if (i!=cnos.size()-1){
                    sb.append(cnos.get(i)+",");
                }else {
                    sb.append("?)");
                }
            }
            sb.append(" limit ?,? ");
//            System.out.println(sb);
            List<Course> courses = template.query(sb.toString(), new BeanPropertyRowMapper<>(Course.class), cnos.get(cnos.size()-1),start,rows);
//            System.out.println(courses);
            return courses;
        }

    }

    /**
     * 没有选修课程的数量
     *
     * @param sno
     * @return
     */
    @Override
    public int FindNotSelectCount(String sno) {
        String sql="select count(*) from course";
        Integer allCount = template.queryForObject(sql, Integer.class);
        int selectCount = FindTotalCount(sno);
        return allCount-selectCount;
    }
}
