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
    <h3 align="center">用户登录</h3>
    <form action="LiChaoUserServlet" method="post">
        <br>
        <h4 align="center">账 号:<input type="text" name="username" value=""></h4>
        <h4 align="center">密 码:<input type="password" name="password" value=""></h4>
        <h4 align="center"> <input type="submit" name="submit1" value="提交"></h4>
        <input type="hidden" name="operate" value="login">
        </h4>
    </form>
    <h4 align="center"><a href="registor.jsp">还没有用户名？点击注册</a> </h4>
    <%
        String mess = (String)request.getAttribute("message");
        if(mess != null) {
    %>
    <script type="text/javascript" language="javascript">
        alert("<%=mess%>");
        window.location='login.jsp' ;
    </script>
    <%
        }
    %>

</body>
</html>
