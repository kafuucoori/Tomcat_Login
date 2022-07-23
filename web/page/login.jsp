<%--
  Created by IntelliJ IDEA.
  User: Coori
  Date: 2022/7/15
  Time: 8:07
  To change this template use File | Settings | File Templates.
  功能描述: 登录界面
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath(); %>

<html>
    <head>
        <title>User Login</title>
        <link rel="stylesheet"  type="text/css"  href="<%=path%>/css/login.css"/>
    </head>
    <body>
        <%
            Cookie[] cks = request.getCookies();
            if(cks !=null){
                for(Cookie ck: cks){
                    if(ck.getName().equals("regName")){
                        String regName = ck.getValue();
                        request.setAttribute("regName", regName);
                    }
                }
            }
        %>
        <div class="login-box">
            <div class="inner-head">
                <h1>Login</h1>
            </div>
            <div class="inner-sign">
                <form action="<%=path%>/userlogin" method="post">
                    <input type="text" name="name" class="input-text" placeholder="帐号" value="${regName}">
                    <input type="password" name="pwd" class="input-text" placeholder="密码">
                    <input type="submit" value="登录" class="input-btn">
                    <a onclick="location.href=('modify.jsp')">注册</a>
                    <a href="#">忘记密码</a>
                </form>
            </div>
        </div>
    </body>
</html>
