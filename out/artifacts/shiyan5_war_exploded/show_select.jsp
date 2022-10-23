<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lichao
  Date: 2022/10/3
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="shiyan5.score_bean" %>
<%@page import="shiyan5.score_deal" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  String str_rowCount=String.valueOf(request.getAttribute("rowCount"));
  int rowCount=Integer.parseInt(str_rowCount);
  System.out.println("rowcount"+rowCount);
  String str_pageCount=String.valueOf(request.getAttribute("pageCount"));
  int pageCount=Integer.parseInt(str_pageCount);
  System.out.println("pagecount"+pageCount);
  String str_pageNow=String.valueOf(request.getAttribute("pageNow"));
  int pageNow=Integer.parseInt(str_pageNow);
  System.out.println("pagenow"+pageNow);
%>
<h3>学生成绩信息表</h3><br>
<button onclick="window.location.href = 'add.jsp'">添加学生信息</button>
<%
  out.println("共有【"+rowCount+"】条记录,当前显示第【"+pageNow+"】页");
%>
<table  border="1">
  <tr>
    <td>学号</td>
    <td>姓名</td>
    <td>Web前端开发</td>
    <td>Java课程</td>
    <td>操作系统</td>
    <td>操作</td>
    <td>操作2</td>
  </tr>
    <%
        ArrayList al=new ArrayList();
        al=(ArrayList) request.getAttribute("selresult");
        for (int i=0;i<al.size();i++){
            score_bean sb=new score_bean();
            sb=(score_bean)al.get(i);
            out.println("<tr>");
            out.println("<td>"+sb.getStu_id()+"</td><td>"+sb.getStu_name()+"</td><td>"+sb.getWeb_app()+"</td><td>"
            +sb.getJava()+"</td><td>"+sb.getOs()+"</td><td>"+"<a href=/shiyan5_war_exploded/deleteServlet?id="+sb.getStu_id()+" onclick='return confirm(\"是否删除\");'"+">删除</a>"+"</td><td>"+"<a href="+"LiChaoupdate.jsp"+"?id="+sb.getStu_id()+">修改</a>"+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("<a href=/shiyan5_war_exploded/show_scoreServlet?pageNow=1>首页</a>");
        if (pageNow>1){
            out.println("<a href=/shiyan5_war_exploded/show_scoreServlet?pageNow="+(pageNow-1)+">上一页</a>");
        }
         for (int i=1;i<=pageCount;i++){
             out.println("<a href=/shiyan5_war_exploded/show_scoreServlet?pageNow=" +i+ ">["+i+"]</a>");
         }
         if (pageNow<pageCount){
            out.println("<a href=/shiyan5_war_exploded/show_scoreServlet?pageNow="+(pageNow+1)+">下一页</a>");
         }
        out.println("<a href=/shiyan5_war_exploded/show_scoreServlet?pageNow="+pageCount+">尾页</a>");

    %>
</body>
</html>
