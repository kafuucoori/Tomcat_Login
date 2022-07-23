package top.kafuucoori.servlet;

import top.kafuucoori.service.UserService;
import top.kafuucoori.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/17 - 07 - 17 - 8:45
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，完成根据ID删除用户功能
 */
@WebServlet(name = "DelUserByIdServlet", value = "/deleteuser")
public class DelUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService us = new UserServiceImpl();
        String strid = request.getParameter("id");
        int id = 0;

        if (strid != null) {
            id = Integer.parseInt(strid);
        }

        if (us.delUserById(id) == 1) {
            response.sendRedirect("/Tomcat_Login/getuserbyfuzzy");
        } else {
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
        }

    }

}
