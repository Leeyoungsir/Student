package com.hwadee.dao.impl;

import com.hwadee.dao.CourseDao;

import com.hwadee.model.Sc;
import com.hwadee.model.Student;
import com.hwadee.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



import java.util.ArrayList;
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
        String sql="select * from sc course  where sno=?  limit ?,? ";
        List<Sc> list = template.query(sql, new BeanPropertyRowMapper<Sc>(Sc.class),start,rows);
        return list;
    }

    /**
     * 记录查询条数
     * @return
     */
    @Override
    public int FindTotalCount() {
        String sql="select count(*) from sc ";
        Integer integer = template.queryForObject(sql, Integer.class);
        return integer;
    }

    /**
     *退课
     * @param sc
     * @return
     */
    @Override
    public void deleteCourse(Sc sc) {
         String sql="SELECT * From sc where cno=? and sno=?";
         template.update(sql,sc.getSno(),sc.getCno(),sc.getGrade());

    }

    /**
     * 选课
     * @param sc
     * @return
     */
    @Override
    public void addCourse(Sc sc) {
        String sql="INSERT INTO sc VALUE(?,?,?)";
        template.update(sql,sc.getSno(),sc.getCno(),sc.getGrade());
    }


}
