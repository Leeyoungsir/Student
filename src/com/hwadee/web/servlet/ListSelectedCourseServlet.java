package com.hwadee.web.servlet;

/**
 * @Author: CKN
 * @Description :
 * Date : 2020/7/21 20:13
 */

import com.hwadee.model.Course;
import com.hwadee.model.PageBean;
import com.hwadee.model.Sc;
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
import java.util.Map;

/**
 * 学生课程列表
 */
@WebServlet("/ListSelectedCourseServlet")
public class ListSelectedCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentpage = request.getParameter("currentpage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        String sno="001";
        if (user!=null){
            sno = user.getSno();//学号
        }
        if(currentpage==null || "".equals(currentpage) || Integer.parseInt(currentpage)<=0)
        {
            currentpage="1";
        }

        if(rows==null || "".equals(rows))
        {
            rows="10";
        }
        CourseService service=new CourseServiceImpl();
        PageBean<Course> pageBean = service.findSelectedCourse(Integer.parseInt(currentpage), Integer.parseInt(rows),sno);
        request.setAttribute("pageBean",pageBean);
//        System.out.println(pageBean);
        request.getRequestDispatcher("/student/selectedCourse.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
