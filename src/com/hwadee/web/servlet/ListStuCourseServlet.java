package com.hwadee.web.servlet;

/**
 * @Author: CKN
 * @Description :
 * Date : 2020/7/21 20:13
 */

import com.hwadee.model.PageBean;
import com.hwadee.model.Sc;
import com.hwadee.service.CourseService;
import com.hwadee.service.impl.CourseServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 学生课程列表
 */
@WebServlet("/ListStuCourseServlet")
public class ListStuCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentpage = request.getParameter("currentpage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数
        String sno=request.getParameter("sno");//学生学号
        Map<String, String[]> conditionMap = request.getParameterMap();//条件查询的键值对
        if(currentpage==null || "".equals(currentpage) || Integer.parseInt(currentpage)<=0)
        {
            currentpage="1";
        }

        if(rows==null || "".equals(rows))
        {
            rows="10";
        }
        CourseService service=new CourseServiceImpl();
        PageBean<Sc> pageBean = service.findByPage(Integer.parseInt(currentpage), Integer.parseInt(rows),sno);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("conditionMap",conditionMap);
        System.out.println(pageBean);
        System.out.println(conditionMap);
        request.getRequestDispatcher("/user/user_course_info.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
