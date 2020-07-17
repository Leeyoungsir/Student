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
             out.write("<div class='all'>");
             out.write("<div><span>课程号</span><span>课程名称</span><span>执教老师</span><span>学分</span></div>");
             for(Course i:results) {
                 out.write("<div>");
                 out.write("<span>"+i.getCno()+"</span>");
                 out.write("<span>"+i.getCname()+"</span>");
                 out.write("<span>"+i.getCteacher()+"</span>");
                 out.write("<span>"+i.getCcredit()+"</span>");
                 out.write("</div>");
             }
             out.write("</div>");
         }
     }
     out.flush();
     out.close();
 }
}
