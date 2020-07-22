package com.hwadee.web.servlet;

import com.hwadee.model.Class;
import com.hwadee.model.Student;
import com.hwadee.service.ClassService;
import com.hwadee.service.StudentService;
import com.hwadee.service.impl.ClassServiceImpl;
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
 * @Description 添加班级servlet
 * @Date Create in 10:37 2020/7/21
 */
@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Class c=new Class();
        try {
            BeanUtils.populate(c,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ClassService service=new ClassServiceImpl();
        boolean isAdd=service.add(c);
//        System.out.println("添加成功");
       if (isAdd){
           response.sendRedirect(request.getContextPath()+"/ListClassServlet");
       }else {
           response.sendRedirect(request.getContextPath()+"/admin/admin_add_failed.jsp?aId=3");
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
