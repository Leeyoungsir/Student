package com.hwadee.web.servlet;

import com.hwadee.model.Course;
import com.hwadee.model.PageBean;
import com.hwadee.model.Sc;
import com.hwadee.model.UserInfo;
import com.hwadee.service.AdminCourseService;
import com.hwadee.service.CourseService;
import com.hwadee.service.impl.AdminCourseServiceImpl;
import com.hwadee.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Map;

/**
 * @Author LH
 * @Description 可选课程列表
 * @Date Create in 10:47 2020/7/22
 */
@WebServlet("/ListSelectCourseServlet")
public class ListSelectCourseServlet extends HttpServlet {
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
        PageBean<Course> pageBean = service.findNotSelectCourse(Integer.parseInt(currentpage), Integer.parseInt(rows), sno);
        System.out.println(pageBean);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/student/selectCourse.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
