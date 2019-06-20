<%--
  Created by IntelliJ IDEA.
  User: cooktea
  Date: 2019/6/20
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.database.dbUser" %>
<%@ page import="java.util.List" %>


<html>
<head>
    <title>管理用户</title>
</head>
<body>
<html>
<head>
    <title>修改票价</title>
</head>
<body>
<div class="mainContainer">
    <div style="width: 100%;height: 20%;margin-bottom: 30px;background-color: gray;display: flex;justify-content: center;align-items: center">
        <h1 style="color: white">管理系统</h1>
    </div>
    <div style="width: 100%;height:80%;">
        <table border="1" width="100%" style="text-align: center">
            <tr>
                <th>用户id</th>
                <th>用户密码</th>
                <th>联系方式</th>
                <th>操作</th>
            </tr>
            <tr>
                <%
                    dbUser db = new dbUser();
                    List<String[]> users = db.getUsers();
                    for(int i=0;i<users.size();i++){
                        out.println("<tr>");
                        out.println(String.format("<td>%s</td>",users.get(i)[0]));
                        out.println(String.format("<td>%s</td>",users.get(i)[1]));
                        out.println(String.format("<td>%s</td>",users.get(i)[2]));
                        out.println(String.format("<td><a href=deleteUser?id=%s>删除用户</a></td>",users.get(i)[0]));
                        out.println("</tr>");
                    }

                %>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
</body>
</html>
