package com.hwadee.web.servlet;

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
 * @Description 删除学生servlet
 * @Date Create in 16:34 2020/7/20
 */
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        StudentService service=new StudentServiceImpl();
        service.delete(sno);
        response.sendRedirect(request.getContextPath()+"/ListStudentServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
