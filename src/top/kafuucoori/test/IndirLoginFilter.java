package top.kafuucoori.test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/19 - 07 - 19 - 11:52
 * @Description: top.kafuucoori.filter
 * @version: 1.0
 * 功能描述: Filter，拦截未登录请求（仅拦截）
 * 注意：本过滤器已被DirLoginFilter替代，仅做调试用
 */
//  @WebFilter(urlPatterns = {"/page/userlist.jsp", "/page/modify.jsp"})
public class IndirLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Object obj = req.getSession().getAttribute("name");
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        if (obj != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            res.sendRedirect("/Tomcat_Login/page/login.jsp");
        }

    }

}
