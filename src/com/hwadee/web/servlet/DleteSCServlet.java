package com.hwadee.web.servlet;

import com.hwadee.model.Sc;
import com.hwadee.service.CourseService;
import com.hwadee.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CKN
 * @Description :
 * Date : 2020/7/20 18:15
 */
@WebServlet("/DeleteSCServlet")
/**
 * 退课servlet
 */
public class DleteSCServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno=req.getParameter("sno");
        String cno=req.getParameter("cno");
        Sc sc=new Sc();
        sc.setSno(sno);
        sc.setCno(cno);
        CourseService courseService=new CourseServiceImpl();
        courseService.deleteCourse(sc);
        resp.sendRedirect(req.getContextPath()+"/ListStuCourseServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
