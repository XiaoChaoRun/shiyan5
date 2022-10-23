<%@ page import="java.util.ArrayList" %>
<%@ page import="shiyan5.score_bean" %><%--
  Created by IntelliJ IDEA.
  User: lichao
  Date: 2022/10/13
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2 align="center">欢迎使用学生成绩管理系统</h2>
    <br>
    <form action="show_scoreServlet" method="post">
        <h3 align="center">
            点击查询所有学生信息<input type="submit" name="chaxun" value="查询">
        </h3>
    </form>
    <br>

</html>
