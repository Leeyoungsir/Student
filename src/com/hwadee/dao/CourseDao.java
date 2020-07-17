package com.hwadee.dao;

import com.hwadee.model.Course;
import com.hwadee.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDao {
    // 获取可选课程的信息，用ArrayList返回
    public ArrayList<Course> searchCourse() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql ="select * from course  where cno mot in (select cno from sc,student,course where sc.sno=student.sno and sc.cno=course.cno";
        ArrayList<Course> results = new ArrayList<Course>();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course temp = new Course();
                temp.setCno(rs.getString("cno"));
                temp.setCname(rs.getString("cname"));
                temp.setCteacher(rs.getString("cteacher"));
                temp.setCcredit(rs.getInt("Ccredit"));
                results.add(temp);
            }
            // 关闭资源
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn);
        }
        return results;
    }
}