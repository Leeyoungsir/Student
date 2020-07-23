package com.hwadee.web.filter;

import com.hwadee.model.UserInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author xuiexizhang
 * @Description
 * @Date Create in 9:07 2020/7/21
 */

@WebFilter(filterName = "LoginFilter",urlPatterns = "*.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        PrintWriter out = response.getWriter();
        //定义未登入允许访问的页面
        String rurl = "/,/signin.jsp,/FindPassword.jsp,/Registered.jsp,/LoginServlet";

        String requestURl = request.getRequestURI().toString();
        String url = requestURl.substring(requestURl.lastIndexOf("/"));

        //判断是否拦截
        if(rurl.indexOf(url)==-1 ){
            HttpSession session = request.getSession();
            UserInfo user = (UserInfo) session.getAttribute("user");
            if(user ==null){
                out.println("你还未登入，3秒回转到登入");
                response.setHeader("refresh", "3,url="+request.getContextPath()+"/login/signin.jsp");
                return;
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
