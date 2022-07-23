package top.kafuucoori.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/22 - 07 - 22 - 11:28
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: 测试类，测试Cookie功能
 */
@WebServlet(name = "CookieTestServlet", value = "/cookietest")
public class CookieTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cks = request.getCookies();
        Date date = null;
        boolean flag = false;

        if (cks != null){
            for (int i = 0; i < cks.length; i++){
                if(cks[i].getName().equals("lastLogin")){
                    flag = true;
                    cks[i].setValue(System.currentTimeMillis() + "");
                    date = new Date(System.currentTimeMillis());
                }
            }
        }
        if (flag) {
            response.getWriter().print("上一次的登录时间是：" + date);
        } else {
            response.getWriter().print("第一次哦！");
        }

        Cookie cookie = new Cookie("lastLogin", System.currentTimeMillis() + "");
        cookie.setMaxAge(10);
        response.addCookie(cookie);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
