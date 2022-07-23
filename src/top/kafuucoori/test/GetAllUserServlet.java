package top.kafuucoori.test;

import top.kafuucoori.entity.User;
import top.kafuucoori.service.UserService;
import top.kafuucoori.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/16 - 07 - 16 - 17:54
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，完成查询用户所有信息功能
 * 注意：本过Servlet已被 GetUserByPageServlet 替代，仅做调试用
 */
//  @WebServlet(name = "GetAllUserServlet", value = "/getalluser")
public class GetAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object name = request.getSession().getAttribute("name");

        if (name != null){
            UserServiceImpl us = new UserServiceImpl();
            List<User> list = us.getUserCountry();
            request.setAttribute("userList", list);
            request.getRequestDispatcher("/page/userlist.jsp").forward(request, response);
        } else {
            response.sendRedirect("/Tomcat_Login/page/login.jsp");
        }

    }

}
