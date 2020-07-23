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

@WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //1.获取资源请求路径
        HttpServletRequest request=(HttpServletRequest)req;
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/login/") || requestURI.contains("/LoginServlet") || requestURI.contains("/css/") || requestURI.contains("/js/") || requestURI.contains("/fonts/") || requestURI.contains("/checkCode"))
        {
            //放行
            chain.doFilter(request,resp);
        }
        else
        {
            Object user = request.getSession().getAttribute("user");
            if(user==null)
            {
                //跳转到登录页面
                request.setAttribute("login_msg","你尚未登录，请登录！");
                request.getRequestDispatcher("/login/signin.jsp").forward(request,resp);
            }
            else
            {
//                放行
                chain.doFilter(request,resp);

            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
