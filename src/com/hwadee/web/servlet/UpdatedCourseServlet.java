package com.hwadee.web.servlet;

import com.hwadee.model.Course;
import com.hwadee.model.Student;
import com.hwadee.service.AdminCourseService;
import com.hwadee.service.StudentService;
import com.hwadee.service.impl.AdminCourseServiceImpl;
import com.hwadee.service.impl.StudentServiceImpl;
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
 * @Description 修改之后servlet
 * @Date Create in 11:36 2020/7/21
 */
@WebServlet("/UpdatedCourseServlet")
public class UpdatedCourseServlet extends HttpServlet {
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
        service.update(course);
        response.sendRedirect(request.getContextPath()+"ListCourseServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
