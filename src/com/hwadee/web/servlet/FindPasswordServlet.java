package com.hwadee.web.servlet;

import com.hwadee.service.impl.FindPasswordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;

@WebServlet("/FindPassword")
public class FindPasswordServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //获取数据
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        System.out.println("code" + code);
        String username=request.getParameter("username");
        String sno=request.getParameter("sno");
        String password=request.getParameter("password");
        String scode = (String) session.getAttribute("CHECKCODE_SERVER");
        //判断验证码是否正确
        //不区分大小写
        if(code == null || !code.equalsIgnoreCase(scode)){
            out.println("验证码错误请重新输入");
            response.setHeader("refresh", "5,url="+request.getContextPath()+"/login/signin.jsp");
            return;
        }
        //user传个service层
        FindPasswordService service=new FindPasswordService();
        Boolean r = false;
        try {
            r=service.findPassword(username, password,sno);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(r==true){
            out.println("修改密码成功，5秒返回登入界面");
            response.setHeader("refresh", "5,url="+request.getContextPath()+"/login/signin.jsp");
            return;

        }else{
            //登录失败
            out.println("修改密码失败，5秒回到修改密码界面");
            response.setHeader("refresh", "5,url="+request.getContextPath()+"/login/FindPassword.jsp");
        }



    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
