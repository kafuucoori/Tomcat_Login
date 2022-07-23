package top.kafuucoori.servlet;

import top.kafuucoori.entity.User;
import top.kafuucoori.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/21 - 07 - 21 - 10:13
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，完成用户注册时 name 检查功能
 */
@WebServlet(name = "CheckNameWithAjaxServlet", value = "/checkname")
public class CheckNameWithAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        User user = new User();
        user.setName(name);
        UserServiceImpl us = new UserServiceImpl();

        if (us.getUserByName(user)) {
            response.getWriter().print(false);
        } else {
            response.getWriter().print(true);
        }

    }

}
