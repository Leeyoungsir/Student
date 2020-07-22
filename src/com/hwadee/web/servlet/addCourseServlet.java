package com.hwadee.web.servlet;

import com.hwadee.model.Course;
import com.hwadee.service.AdminCourseService;
import com.hwadee.service.impl.AdminCourseServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author LH
 * @Description
 * @Date Create in 10:47 2020/7/21
 */
@WebServlet("/addCourseServlet")
public class addCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Course course=new Course();
        try {
            BeanUtils.populate(course,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        AdminCourseService service=new AdminCourseServiceImpl();
        boolean isAdd=service.add(course);
//        System.out.println("添加成功");
        if (isAdd){
            response.sendRedirect(request.getContextPath()+"/ListCourseServlet");
        }else {
            response.sendRedirect(request.getContextPath()+"/admin/admin_add_failed.jsp?aId=2");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
