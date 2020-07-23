package com.hwadee.dao.impl;

import com.hwadee.dao.StudentDao;
import com.hwadee.model.Student;
import com.hwadee.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * @param conditionMap
     * @return
     */
    @Override
    public int FindTotalCount(Map<String, String[]> conditionMap) {
        String sql="select count(*) from student where 1=1 ";
        StringBuffer sb=new StringBuffer(sql);
        //定义参数集合
        ArrayList<Object> params=new ArrayList<>();
        Set<String> keys=conditionMap.keySet();
        for (String key : keys) {
            String value=conditionMap.get(key)[0];
            if("currentPage".equalsIgnoreCase(key) || "rows".equalsIgnoreCase(key))
            {
                continue;
            }
            if(value!=null && !"".equals(value))
            {
                //有值
                sb.append( " and " + key + " like ? ");
                params.add("%"+value+"%");//获取条件的参数
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    /**
     * 分页查询，从start开始，共row条记录
     *
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List FindByPage(int start, int rows,Map<String,String[]> conditionMap) {
        String sql="select * from student where 1 = 1";
        StringBuffer sb=new StringBuffer(sql);
        //定义参数集合
        ArrayList<Object> params=new ArrayList<Object>();
        Set<String> keys = conditionMap.keySet();
        for (String key : keys) {
            String value = conditionMap.get(key)[0];
            if("currentPage".equalsIgnoreCase(key) || "rows".equalsIgnoreCase(key))
            {
                continue;
            }
            if(value!=null && !"".equals(value))
            {
                //有值
                sb.append( " and " + key + " like ? ");
                params.add("%"+value+"%");//获取条件的参数
            }
        }
        sb.append(" limit ? , ?");
        params.add(start);
        params.add(rows);
        sql=sb.toString();
        List<Student> list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class),params.toArray());
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

    /**
     * 根据学号查询学生
     * @param sno
     * @return
     */
    @Override
    public Student findBySno(int sno) {
        try {
            String sql="select * from student where sno = ?";
            Student student = template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),sno);
            return student;
        } catch (DataAccessException e) {
            return null;
        }
    }

    /**
     * 更新学生信息
     *
     * @param student
     */
    @Override
    public void update(Student student) {
        String sql="update student set sname=?,ssex=?,sage=?,syear=?,smajor=?,c_no=? where sno=?";
        template.update(sql,student.getSname(),student.getSsex(),student.getSage(),student.getSyear(),student.getSmajor(),student.getC_no(),student.getSno());
    }

    /**
     * 根据班级号查询班级人数
     *
     * @param c_no
     * @return
     */
    @Override
    public int findByC_no(String c_no) {
        try {
            String sql="select count(*) from student where c_no=?";
            Integer integer = template.queryForObject(sql, Integer.class,c_no);
            return integer;
        } catch (DataAccessException e) {
            return 0;
        }
    }
}
