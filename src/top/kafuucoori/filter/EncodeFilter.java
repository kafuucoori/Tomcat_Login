package top.kafuucoori.filter;

import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/19 - 07 - 19 - 10:18
 * @Description: top.kafuucoori.filter
 * @version: 1.0
 * 功能描述: Filter，集中处理乱码问题
 */
@WebFilter("/*")
public class EncodeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        // 设置请求链
        filterChain.doFilter(servletRequest, servletResponse);

    }

}
