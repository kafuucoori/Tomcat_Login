package top.kafuucoori.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/19 - 07 - 19 - 15:35
 * @Description: top.kafuucoori.filter
 * @version: 1.0
 * 功能描述: Filter，拦截未登录请求（仅放行）
 */
@WebFilter("*.jsp")
public class DirLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String url = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1);
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        if (url.equals("") || url.equals("login.jsp") || url.equals("modify.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (req.getSession().getAttribute("name") == null) {
                res.sendRedirect("/Tomcat_Login/freekeylogin");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

    }

}
