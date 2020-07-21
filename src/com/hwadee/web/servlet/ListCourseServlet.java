package com.hwadee.web.servlet;

import com.hwadee.model.Course;
import com.hwadee.model.PageBean;
import com.hwadee.service.AdminCourseService;
import com.hwadee.service.impl.AdminCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author LH
 * @Description 课程列表servlet
 * @Date Create in 15:57 2020/7/20
 */
@WebServlet("/ListCourseServlet")
public class ListCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentpage = request.getParameter("currentpage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数
        Map<String, String[]> conditionMap = request.getParameterMap();//条件查询的键值对
        if(currentpage==null || "".equals(currentpage) || Integer.parseInt(currentpage)<=0)
        {
            currentpage="1";
        }

        if(rows==null || "".equals(rows))
        {
            rows="10";
        }
        AdminCourseService service=new AdminCourseServiceImpl();
        PageBean<Course> pageBean = service.findByPage(Integer.parseInt(currentpage), Integer.parseInt(rows));
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/admin/admin_course_info.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
