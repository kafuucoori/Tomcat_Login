<%--
  Created by IntelliJ IDEA.
  User: Coori
  Date: 2022/7/17
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath(); %>

<html>
<head>
    <title>Modify User</title>
    <script type="text/javascript" charset="UTF-8" src="<%=path%>/js/jquery.js"></script>
    <script type="text/javascript" charset="UTF-8" src="<%=path%>/js/modify.js"></script>
    <link rel="stylesheet"  type="text/css"  href="<%=path%>/css/modify.css"/>
</head>
    <body>
        <div class="register-box">
            <div class="inner-head">
                <h1>Welcome</h1>
            </div>
            <div class="inner-sign">
                <form action="<%=path%>/douserupdate" onsubmit="checkNameByJQuery()">
                    <!-- 用户ID：<input type="text" name="id" value="${user.id}" readonly="readonly"> -->
                    <input type="hidden" name="id" value="${user.id}">
                    用户名：<span id="sname"></span>
                    <input class="input-text" type="text" name="name" id="name" value="${user.name}" onblur="checkNameByJQuery()">
                    密码：<input class="input-text" type="text" name="pwd" value="${user.pwd}">
                    爱好：<input class="input-text" type="text" name="hobby" value="${user.hobby}">
                    国家：<br>
                    <div class="select">
                        <select name="cid">
                            <option value="1">China</option>
                            <option value="2">Germany</option>
                            <option value="3">France</option>
                            <option value="4">Japan</option>
                            <option value="5">UK</option>
                            <option value="6">USA</option>
                        </select>
                    </div>
                    <input class="input-btn" type="submit" value="提交">
                    <input class="input-btn" type="reset" value="重置">
                    <input class="input-btn" type="button" value="返回" onclick="history.back()">
                </form>
            </div>
        </div>
    </body>
</html>