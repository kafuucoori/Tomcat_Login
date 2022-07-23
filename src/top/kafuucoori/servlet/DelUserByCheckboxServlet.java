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
 * @Date: 2022/7/19 - 07 - 19 - 19:53
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，完成通过多选框删除功能
 */
@WebServlet(name = "DelUserByCheckboxServlet", value = "/checkboxdel")
public class DelUserByCheckboxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] ids = request.getParameter("ids").split(",");
        UserService us = new UserServiceImpl();
        int count = 0;

        for (int i = 0; i < ids.length; i++) {
            if (!ids[i].equals("")) {
                int id = Integer.parseInt(ids[i]);
                count += us.delUserById(id);
            }
        }

        if (count == ids.length) {
            response.sendRedirect("/Tomcat_Login/getuserbyfuzzy");
        }

    }

}
