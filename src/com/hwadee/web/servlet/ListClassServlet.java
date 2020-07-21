package com.hwadee.web.servlet;

import com.hwadee.model.Class;
import com.hwadee.model.PageBean;
import com.hwadee.model.Student;
import com.hwadee.service.ClassService;
import com.hwadee.service.StudentService;
import com.hwadee.service.impl.ClassServiceImpl;
import com.hwadee.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author LH
 * @Description 班级列表servlet
 * @Date Create in 9:34 2020/7/21
 */
@WebServlet("/ListClassServlet")
public class ListClassServlet extends HttpServlet {
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
        ClassService service=new ClassServiceImpl();
        PageBean<Class> pageBean = service.findByPage(Integer.parseInt(currentpage), Integer.parseInt(rows));
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/admin/admin_class_info.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
