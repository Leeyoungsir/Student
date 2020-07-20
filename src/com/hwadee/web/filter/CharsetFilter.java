package com.hwadee.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author LH
 * @Description
 * @Date Create in 9:39 2020/7/20
 */
@WebFilter("/*")
public class CharsetFilter implements Filter {
    // 定义编码方式 默认为空
    private String encoding ="UTF-8";
    public void destroy() {
    }
    // 自动调用过滤方法 doFilter
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 如果编码不为空就过滤请求中的数据
        if (encoding != null) {
            // 设置request字符编码
            request.setCharacterEncoding(encoding);
            // 设置response字符编码
            response.setContentType("text/html;charset=" + encoding);
        }
        // 传递给下一个过滤器或者下一个servlet/jsp
        chain.doFilter(request, response);
    }
    public void init(FilterConfig config) throws ServletException {

    }
    }

