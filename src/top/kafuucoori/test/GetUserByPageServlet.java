package top.kafuucoori.test;

import top.kafuucoori.entity.User;
import top.kafuucoori.service.impl.UserServiceImpl;
import top.kafuucoori.util.PageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/20 - 07 - 20 - 8:52
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，完成分页查询用户信息功能
 * 注意：本过Servlet已被 GetUserByFuzzyServlet 替代，仅做调试用
 */
//  @WebServlet(name = "GetUserByPageServlet", value = "/getuserbypage")
public class GetUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strPageNo = request.getParameter("pageNo");
        PageHelper ph = new PageHelper();
        UserServiceImpl us = new UserServiceImpl();

        if(strPageNo == null){
            strPageNo = "1";
        }

        ph.setPageNo(Integer.parseInt(strPageNo));
        ph.setPageSize(10);
        ph.setDataCount(us.getUserCount());
        int pageCount = ph.getPageCount();

        ph.setPageCount(pageCount);
        List<User> list = us.getUserByPage(ph.getPageNo(), ph.getPageSize());
        request.setAttribute("userPageList", list);
        request.setAttribute("pagehelper", ph);
        request.getRequestDispatcher("/page/userlist.jsp").forward(request, response);

    }

}
