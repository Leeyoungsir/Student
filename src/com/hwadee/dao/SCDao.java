package com.hwadee.dao;

import com.hwadee.model.SC;
import com.hwadee.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//查询成绩
public class SCDao {
    public ArrayList<SC> searchGrade() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select student.sno sno,sname,ssex,sage,course.cno,cname,grade from sc,student,course where sc.sno = student.sno and course.cno = sc.cno order by sno;";
        ArrayList<SC> results = new ArrayList<SC>();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SC temp = new SC();
                temp.setSno(rs.getString("sno"));
                temp.setSname(rs.getString("sname"));
                temp.setCno(rs.getString("cno"));
                temp.setCname(rs.getString("cname"));
                temp.setGrade(rs.getDouble("grade"));
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
