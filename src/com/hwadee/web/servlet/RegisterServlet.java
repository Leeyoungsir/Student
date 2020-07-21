package com.hwadee.web.servlet;

import com.hwadee.model.UserInfo;
import com.hwadee.service.impl.RegisterService;
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
 * @Author xuiexizhang
 * @Description RegisterSevlet
 * @Date Create in 9:50 2020/7/18
 */


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
            System.out.println("ok");
        Map<String, String[]> properties = request.getParameterMap();
        UserInfo user=new UserInfo();
        try {
            BeanUtils.populate(user, properties);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //将user传递给service层
        RegisterService service= new RegisterService();
        boolean isRegisterSuccess=service.register(user);
        //是否注册成功
        if(isRegisterSuccess){
            //成功
            response.sendRedirect(request.getContextPath()+"/login/Return.jsp");
        }else{
            //失败
            response.sendRedirect(request.getContextPath()+"/login/Registered.jsp");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

