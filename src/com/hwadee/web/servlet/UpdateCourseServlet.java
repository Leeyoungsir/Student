package com.hwadee.web.servlet;

import com.hwadee.model.Course;
import com.hwadee.model.Student;
import com.hwadee.service.AdminCourseService;
import com.hwadee.service.StudentService;
import com.hwadee.service.impl.AdminCourseServiceImpl;
import com.hwadee.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LH
 * @Description 修改课程页面
 * @Date Create in 11:28 2020/7/21
 */
@WebServlet("/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        AdminCourseService service=new AdminCourseServiceImpl();
        Course course = service.findByCno(cno);
        request.setAttribute("course",course);
        System.out.println(course);
        request.getRequestDispatcher("/admin/admin_course_modify.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
