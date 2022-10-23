<%--
  Created by IntelliJ IDEA.
  User: lichao
  Date: 2022/10/13
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3 align="center">增加学生信息</h3>
  <form action="AddServlet" method="post">
    <h4 align="center">
      学生学号:<input type="text" name="stu_id" value=""><br><br>
      学生姓名:<input type="text" name="stu_name" value=""><br><br>
      Web成绩:<input type="text" name="web" value=""><br><br>
      java成绩:<input type="text" name="java" value=""><br><br>
      操作系统成绩:<input type="text" name="os" value=""><br><br>
      <input type="submit" name="tijiao" value="提交"><br>
    </h4>

  </form>
</body>
</html>
