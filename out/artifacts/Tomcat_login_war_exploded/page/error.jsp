<%--
  Created by IntelliJ IDEA.
  User: Coori
  Date: 2022/7/15
  Time: 21:14
  To change this template use File | Settings | File Templates.
  功能描述: 登录错误界面
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath(); %>

<html>
    <head>
        <title>Error Page</title>
        <link rel="stylesheet"  type="text/css"  href="<%=path%>/css/state.css"/>
    </head>
    <body>
        <div class="state-box">
            <div class="state">
                <h1>
                    操作错误！
                </h1>
            </div>
        </div>
    </body>
</html>
