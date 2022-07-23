package top.kafuucoori.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/22 - 07 - 22 - 20:51
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，实现免密登录功能
 */
@WebServlet(name = "FreeKeyLoginServlet", value = "/freekeylogin")
public class FreeKeyLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取免密登录的cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if(cookie.getName().equals("uid")){
                    String value = cookie.getValue();
                    if(value != null){
                        request.getSession().setAttribute("name", value);
                        response.sendRedirect("/Tomcat_Login/getuserbyfuzzy");
                        return;
                    } else {
                        response.sendRedirect("/Tomcat_Login/page/login.jsp");
                    }
                } else {
                    response.sendRedirect("/Tomcat_Login/page/login.jsp");
                }
            }
        } else {
            response.sendRedirect("/Tomcat_Login/page/login.jsp");
        }

    }
}
