<%@ page import="shiyan5.score_bean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="shiyan5.score_deal" %><%--
  Created by IntelliJ IDEA.
  User: lichao
  Date: 2022/10/15
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">修改学生信息</h3>
<%
    String id=request.getParameter("id");
    String name;
    int web;
    int java;
    int os;
    score_deal sdl=new score_deal();
    ArrayList al=sdl.selectscore(Integer.parseInt(id));
    score_bean sb=new score_bean();
    sb=(score_bean)al.get(0);
    name=sb.getStu_name();
    web=sb.getWeb_app();
    java=sb.getJava();
    os=sb.getOs();


%>
<form action="updateServlet" method="post">
    <h4 align="center">
        学生学号:<input type="text" name="stu_id" value=<%=id%>><br><br>
        学生姓名:<input type="text" name="stu_name" value=<%=name%>><br><br>
        Web成绩:<input type="text" name="web" value=<%=web%>><br><br>
        java成绩:<input type="text" name="java" value=<%=java%>><br><br>
        操作系统成绩:<input type="text" name="os" value=<%=os%>><br><br>
        <input type="submit" name="tijiao" value="提交"><br>
    </h4>
</form>
</body>
</html>
