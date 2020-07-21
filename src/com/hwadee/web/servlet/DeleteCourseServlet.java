package com.hwadee.web.servlet;

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
 * @Description
 * @Date Create in 11:41 2020/7/21
 */
@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        AdminCourseService service=new AdminCourseServiceImpl();
        service.delete(cno);
        response.sendRedirect(request.getContextPath()+"/ListCourseServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
