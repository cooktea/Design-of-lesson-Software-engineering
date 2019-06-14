<%--
  Created by IntelliJ IDEA.
  User: cooktea
  Date: 2019/6/12
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.database.dbOrders" %>
<%@ page import="rote.orders" %>
<%@ page import="java.util.List" %>


<html>
<head>
    <title>订单信息</title>
    <link href="css/routeList.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="mainContainer">
        <div style="width: 100%;height: 20%;margin-bottom: 30px;background-color: gray;display: flex;justify-content: center;align-items: center">
            <h1 style="color:white;">用户信息</h1>
            <a href="index.html">返回首页</a>
        </div>
        <div style="width: 100%">
            <table width="100%" border="1">
                <tr>
                    <th>编号</th>
                    <th>日期</th>
                    <th>出发站</th>
                    <th>目的地</th>
                    <th>坐席</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                <%
                    Cookie[] cookies = request.getCookies();
                    String phoneNumber = null;
                    for(int i=0;i<cookies.length;i++){
                        if("phoneNumber".equals(cookies[i].getName())){
                            phoneNumber = cookies[i].getValue();
                        }
                    }
                    dbOrders db = new dbOrders(phoneNumber);
                    List<orders> myOrders = db.getOrders();
                    for(int i=0;i<myOrders.size();i++){
                        orders order = myOrders.get(i);
                        out.println("<tr>");
                        out.println(String.format("<td>%s</td>",order.id));
                        out.println(String.format("<td>%s</td>",order.date));
                        out.println(String.format("<td>%s</td>",order.start));
                        out.println(String.format("<td>%s</td>",order.end));
                        out.println(String.format("<td>%s</td>",order.seat));
                        out.println(String.format("<td>%s</td>",order.status));
                        out.println(String.format("<td><a href=\"unBook?id="+order.id+"\">退票</a></td>"));
                    }
                %>
            </table>
        </div>
    </div>
</body>
</html>
