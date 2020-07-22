package com.hwadee.web.servlet;

import com.hwadee.model.UserInfo;
import com.hwadee.service.CourseService;
import com.hwadee.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author LH
 * @Description 选课
 * @Date Create in 11:49 2020/7/22
 */
@WebServlet("/SelectCourseServlet")
public class SelectCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        CourseService courseService=new CourseServiceImpl();
        HttpSession session = request.getSession();
        UserInfo user=(UserInfo) session.getAttribute("user");
        String sno="001";
        if (user!=null){
            sno=user.getSno();
        }
        courseService.addCourse(cno,sno);
        response.sendRedirect(request.getContextPath()+"/ListSelectCourseServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
