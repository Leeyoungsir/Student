package com.hwadee.web.servlet;

import com.hwadee.model.UserInfo;
import com.hwadee.service.impl.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


/**
 * @Author xuiexizhang
 * @Description
 * @Date Create in 9:50 2020/7/18
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取数据
        HttpSession session = request.getSession();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        LoginService service=new LoginService();
        UserInfo user=null;
        try {
            user=service.login(username, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(user!=null){
            //登录成功
            //将登录的用户的user对象存到session中
            String autoLogin=request.getParameter("autoLogin");
            session.setAttribute("user", user);//左边为名字，右边为值
            //管理员学生管理页面
            if("admin".equals(user.getLevel() )){
                response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
            }
            //学生选课界面
            if("stu".equals(user.getLevel())){
                response.sendRedirect(request.getContextPath()+"/welcome_student.jsp");
            }

        }else{
            //登录失败
            request.getRequestDispatcher("/login/false.jsp").forward(request, response);
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}