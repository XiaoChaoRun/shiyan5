<%--
  Created by IntelliJ IDEA.
  User: lichao
  Date: 2022/10/13
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="LiChaoUserServlet" method="post">
    <br>
    <br>
    <h4 align="center">用户名:<input type="text" name="username" value=""></h4>
    <h4 align="center">密码:<input type="password" name="password" value=""></h4>
    <h4 align="center">重新输入密码:<input type="password" name="passwordtwo" value=""></h4>
    <h4 align="center"> <input type="submit" name="submit1" value="注册"></h4>
    <input type="hidden" name="operate" value="registor">
        <%
        String mess = (String)request.getAttribute("message");
        if(mess != null) {
    %>
    <script type="text/javascript" language="javascript">
        alert("<%=mess%>");
        window.location='loginregistor.jsp' ;
    </script>
        <%
        }
    %>
</body>
</html>
