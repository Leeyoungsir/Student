package com.hwadee.web.servlet;

import com.hwadee.model.Student;
import com.hwadee.service.StudentService;
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
 * @Description 添加学生
 * @Date Create in 14:54 2020/7/20
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Student student=new Student();
        try {
            BeanUtils.populate(student,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        StudentService service=new StudentServiceImpl();
        boolean isAdd = service.add(student);
//        System.out.println("添加成功");
        if (isAdd){
            response.sendRedirect(request.getContextPath()+"/ListStudentServlet");
        }else {
            response.sendRedirect(request.getContextPath()+"/admin/admin_add_failed.jsp?aId=1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
