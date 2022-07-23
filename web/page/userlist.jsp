<%@ page import="top.kafuucoori.util.PageHelper" %>

<%--
  Created by IntelliJ IDEA.
  User: Coori
  Date: 2022/7/16
  Time: 18:00
  To change this template use File | Settings | File Templates.
  功能描述: 用户管理界面
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 前缀prefix设置为c表示所有jstl标签都以c开头（规范） -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<% String path = request.getContextPath(); %>

<html>
    <head>
        <title>User Info</title>
        <script type="text/javascript" charset="UTF-8" src="<%=path%>/js/userlist.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.css">
        <link rel="stylesheet"  type="text/css" href="<%=path%>/css/userlist.css"/>
    </head>
    <body>
        <div class="container">
            <div class="top-head">
                <div class="head-left">
                    欢迎你：${name}
                </div>
                <div class="head-right">
                    <form action="<%=path%>/getuserbyfuzzy" name="queryForm" method="post">
                        请输入名字：
                        <input type="txt" name="sname"> &nbsp; &nbsp;
                        国家：
                        <select name="scid" >
                            <option value="1">China</option>
                            <option value="2">Germany</option>
                            <option value="3">France</option>
                            <option value="4">Japan</option>
                            <option value="5">UK</option>
                            <option value="6">USA</option>
                        </select>
                        <input type="button" value="查询" onclick="query()">
                    </form>
                </div>
            </div>
            <hr class="hr-style-seven">
            <table class="table table-bordered text-center">
                <tr class="bg-primary">
                    <td>编号</td>
                    <td>账号</td>
                    <td>密码</td>
                    <td>爱好</td>
                    <td>国家</td>
                    <td>选择</td>
                    <td>修改</td>
                    <td>删除</td>
                </tr>
                <c:forEach items="${userPageList}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.pwd}</td>
                        <td>${user.hobby}</td>
                        <td>${user.country.country}</td>
                        <td><input type="checkbox" name="ids" value="${user.id}"></td>
                        <td><a href="<%=path%>/updateuser?id=${user.id}">修改</a></td>
                        <td><a href="<%=path%>/deleteuser?id=${user.id}"
                               onclick="if(confirm('是否确定删除'+'${user.name}'+'?') == false)
                                       return false">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="bottom">
                <div class="bottom-page">
                    <%
                        Object obj = request.getAttribute("pagehelper");
                        PageHelper ph = (PageHelper)obj;
                        int pNo = ph.getPageNo();
                        if(pNo > 1) {
                    %>
                    <a href="<%=path%>/getuserbyfuzzy?pageNo=1">首页</a> &emsp;
                    <td>当前页：${pagehelper.pageNo}</td> &emsp;
                    <td>总页数：${pagehelper.pageCount}</td> &emsp;
                    <a href="<%=path%>/getuserbyfuzzy?pageNo=${pagehelper.pageNo-1}">上一页</a>
                    <%
                        }
                        if(pNo < ph.getPageCount()) {
                    %>
                    <a href="<%=path%>/getuserbyfuzzy?pageNo=${pagehelper.pageNo+1}">下一页</a> &emsp;
                    <td>当前页：${pagehelper.pageNo}</td> &emsp;
                    <td>总页数：${pagehelper.pageCount}</td> &emsp;
                    <a href="<%=path%>/getuserbyfuzzy?pageNo=${pagehelper.pageCount}">尾页</a>
                    <%
                        }
                    %>
                </div>
                <div class="bottom-btn">
                    <input type="button" value="全选" onclick="checkAll()">
                    <input type="button" value="反选" onclick="reverseCheck()">
                    <input type="button" value="批量删除" onclick="deleteAll()">
                </div>
            </div>
        </div>
    </body>
</html>
