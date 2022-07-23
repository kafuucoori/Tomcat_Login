package top.kafuucoori.servlet;

import top.kafuucoori.entity.User;
import top.kafuucoori.service.UserService;
import top.kafuucoori.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/17 - 07 - 17 - 10:03
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，更新用户信息以及用户注册功能
 */
@WebServlet(name = "DoUserUpdateServlet", value = "/douserupdate")
public class DoUserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strid = request.getParameter("id");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String hobby = request.getParameter("hobby");
        int cid = Integer.parseInt(request.getParameter("cid"));
        UserServiceImpl us = new UserServiceImpl();

        // 判断是注册还是修改信息（1.是否含有id参数，注册时不含id 2.请求来源地址）
        if (strid != null && !(strid.equals(""))) {
            int id = Integer.parseInt(strid);
            int result = us.updateUserById(new User(id, name, pwd, hobby, cid));

            if (result == 1) {
                response.sendRedirect("/Tomcat_Login/getuserbyfuzzy");
            } else {
                response.sendRedirect("/page/error.jsp");
            }

        } else {
            if (us.register(new User(name, pwd, hobby, cid)) == 1) {
                Cookie ck = new Cookie("regName", name);
                response.addCookie(ck);
                ck.setMaxAge(30); // 保存30S

                response.getWriter().print("<body style='background-color: #e6e4c0; " +
                        "text-align: center; " +
                        "font-size: 25px; " +
                        "color: #79F58E;'>");
                response.getWriter().print("<h1> 注册成功！正在跳转~ </h1>");
                response.getWriter().print("</body>");

                response.setHeader("refresh", "1.5, url='/Tomcat_Login/page/login.jsp'"); // 设置刷新停留时间S

            }

        }

    }

}
