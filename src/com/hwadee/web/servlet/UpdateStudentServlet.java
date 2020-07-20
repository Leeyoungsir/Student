package com.hwadee.web.servlet;

import com.hwadee.model.Student;
import com.hwadee.service.StudentService;
import com.hwadee.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LH
 * @Description 修改学生信息页面
 * @Date Create in 16:38 2020/7/20
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        StudentService service=new StudentServiceImpl();
        Student student = service.findBySno(sno);
        request.setAttribute("student",student);
        System.out.println(student);
        request.getRequestDispatcher("/admin/admin_student_modify.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
