<%--
  Created by IntelliJ IDEA.
  User: Coori
  Date: 2022/7/14
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath(); %>

<html>
    <head>
        <title>My First Web</title>
        <link rel="stylesheet"  type="text/css"  href="<%=path%>/css/index.css"/>
    </head>
    <body>
    <div class="index-box">
        <div class="inner-head">
            <h1>
                项目根目录：<br />
                <% out.print(path); %>
            </h1>
        </div>
        <button onclick="location.href=('/Tomcat_Login/freekeylogin')" class="inner-btn">Enter</button>
    </div>
    </body>
</html>
