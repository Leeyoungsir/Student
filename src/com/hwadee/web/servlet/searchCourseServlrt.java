package com.hwadee.web.servlet;

import com.hwadee.dao.CourseDao;
import com.hwadee.model.Course;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/searchCourse")
//查询可选课程
public class searchCourseServlrt extends HttpServlet {
 public void searchCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
     response.setContentType("text/html;charset=utf-8");
     ArrayList<Course> results = new CourseDao().searchCourse();
     PrintWriter out = response.getWriter();
     if(results != null){
         //输出结果
         if(results != null){
             out.write("<table><tr><td>课程号</td><td>课程名</td><td>执教老师</td><td>学分</td>");
             for(Course i:results) {
                 out.write("<tr><td>"+i.getCno()+"</td>");
                 out.write("<td>"+i.getCname()+"</td>");
                 out.write("<td>"+i.getCteacher()+"</td>");
                 out.write("<td>"+i.getCcredit()+"</td></tr>");
             }
             out.write("</table>");
         }
     }
     out.flush();
     out.close();
 }
}
