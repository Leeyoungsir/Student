package com.hwadee.web.servlet;

import com.hwadee.dao.SCDao;
import com.hwadee.model.SC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/searchGrade")
public class CourseServlet extends HttpServlet {
    public void searchGrade(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("text/html;charset=utf-8");
        ArrayList<SC> results = new SCDao().searchGrade();
        PrintWriter out = response.getWriter();
        // 输出结果
        if (results != null) {
            out.write("<table><tr><td>学号</td><td>姓名</td><td>课程号</td><td>课程名</td><td>成绩</td></tr>");
            for (SC i : results) {

                out.write("<tr><td>" + i.getSno() + "</td>");
                out.write("<td>" + i.getSname() + "</td>");
                out.write("<td>" + i.getCno() + "</td>");
                out.write("<td>" + i.getCname() + "</td>");
                out.write("<td>" + i.getGrade() + "</td></tr>");
            }
            out.write("</table>");
        }
        out.flush();
        out.close();
    }
    }

