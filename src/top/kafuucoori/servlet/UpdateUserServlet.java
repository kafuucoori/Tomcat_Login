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
 * @Date: 2022/7/17 - 07 - 17 - 8:19
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，更新用户信息
 */
@WebServlet(name = "UpdateUserServlet", value = "/updateuser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strid = request.getParameter("id");
        UserServiceImpl us = new UserServiceImpl();
        int id = 0;

        if (strid != null) {
            id = Integer.parseInt(strid);
        }

        User u = us.getUserById(id);
        request.setAttribute("user", u);
        request.getRequestDispatcher("/page/modify.jsp").forward(request, response);

    }

}
/**
 * 根据获取的id查询出想要获得的内容
 * 将获得的内容放到盒子内
 * 跳转到显示信息的页面
 * 直接显示当前已查找好的人的信息
 */