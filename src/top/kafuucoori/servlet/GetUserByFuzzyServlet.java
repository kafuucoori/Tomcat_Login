package top.kafuucoori.servlet;

import top.kafuucoori.entity.User;
import top.kafuucoori.service.UserService;
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
 * @Date: 2022/7/20 - 07 - 20 - 16:50
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 * 功能描述: Servlet，完成分页模糊查询功能
 */
@WebServlet(name = "GetUserByFuzzyServlet", value = "/getuserbyfuzzy")
public class GetUserByFuzzyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strPageNo = request.getParameter("pageNo");
        PageHelper ph = new PageHelper();
        UserServiceImpl us = new UserServiceImpl();
        String sname = request.getParameter("sname");
        String scid = request.getParameter("scid");
        StringBuffer sb = new StringBuffer(); // 创建可变字符串

        if (strPageNo == null) {
            strPageNo = "1";
        }

        ph.setPageNo(Integer.parseInt(strPageNo));
        ph.setPageSize(10);
        ph.setDataCount(us.getUserCount());

        // 有内容且非空时追加字符串
        if (sname != null && !sname.equals("")) {
            sb.append(" and name like '%" + sname + "%'");
        }

        if (scid != null && !scid.equals("0")) {
            int cid = Integer.parseInt(scid);
            sb.append(" and cid = " + cid);
        }

        ph.setPageCount(ph.getPageCount());
        List<User> list = us.getUserByPageAndFuzzy(ph.getPageNo(), ph.getPageSize(), sb);
        request.setAttribute("userPageList", list);
        request.setAttribute("pagehelper", ph);
        request.getRequestDispatcher("/page/userlist.jsp").forward(request, response);

    }

}
