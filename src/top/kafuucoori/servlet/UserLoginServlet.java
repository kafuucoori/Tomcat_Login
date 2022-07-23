package top.kafuucoori.servlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import top.kafuucoori.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/15 - 07 - 15 - 8:25
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，完成用户登录及页面跳转功能
 */
@WebServlet(name = "UserLoginServlet", value = "/userlogin")
public class UserLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        UserServiceImpl us = new UserServiceImpl();

        if (us.login(name, pwd)) {
            request.getSession().setAttribute("name", name);

            // 储存免密登录的Cookie
            Cookie cookie = new Cookie("uid", name + "");
            cookie.setMaxAge(10);
            response.addCookie(cookie);

            response.sendRedirect("/Tomcat_Login/getuserbyfuzzy");
        } else {
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
        }

    }

}
