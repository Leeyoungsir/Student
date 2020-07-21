package com.hwadee.web.servlet;

import com.hwadee.model.UserInfo;
import com.hwadee.service.UserService;
import com.hwadee.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author LH
 * @Description 管理员主页
 * @Date Create in 15:12 2020/7/21
 */
@WebServlet("/AdminUpdateServlet")
public class AdminUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String username = request.getParameter("username");
        String password=request.getParameter("password");
        UserService service=new UserServiceImpl();
        service.update(id,username,password);
        response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
