package com.hwadee.web.servlet;

import com.hwadee.model.Sc;
import com.hwadee.model.Student;
import com.hwadee.service.CourseService;
import com.hwadee.service.StudentService;
import com.hwadee.service.impl.CourseServiceImpl;
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
 * @Author: CKN
 * @Description :
 * Date : 2020/7/20 22:01
 */
@WebServlet("/AddSCServlet")
/**
 * 学生选课
 */
public class AddSCServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Sc sc=new Sc();
        try {
            BeanUtils.populate(sc,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        CourseService courseService=new CourseServiceImpl();
        courseService.addCourse(sc);
        resp.sendRedirect(req.getContextPath()+"/ListStuCourseServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

