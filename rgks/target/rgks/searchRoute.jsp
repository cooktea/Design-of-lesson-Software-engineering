<%--
  Created by IntelliJ IDEA.
  User: cooktea
  Date: 2019/6/10
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="util.database.dbRouteList" %>
<%@page import="java.util.List" %>
<%@page import="rote.route" %>

<html>
<head>
    <title>Title</title>
    <link href="css/routeList.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="mainContainer">
    <div style="width: 100%;height: 20%;margin-bottom: 30px;background-color: gray;display: flex;justify-content: center;align-items: center">
        <h1 style="color:white">车次查询信息</h1>
        <a href="index.html">返回首页</a>
    </div>
    <div style="width: 100%">
        <table border="1" style="width: 100%">
            <tr>
                <th>车次号</th>
                <th>出发</th>
                <th>出发时间</th>
                <th>到达</th>
                <th>到达时间</th>
                <th colspan="2">二等座余量</th>
                <th colspan="2">一等座余量</th>
                <th colspan="2">商务座余量</th>
                <th>列车类型</th>
                <th>价格</th>
                <th>操作</th>
            </tr>
            <%
                request.setCharacterEncoding("UTF-8");
                String start = request.getParameter("start");
                String end = request.getParameter("end");
                String time = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
                System.out.println(start +"->"+ end +" | "+time);
                dbRouteList db = new dbRouteList(start,end,time);
                List<route> routes = db.getRouteList();
                for(int i=0;i<routes.size();i++){
                    out.println("<tr>");
                    out.println("<td>"+routes.get(i).id);
                    out.println("<td>"+start);
                    out.println("<td>"+routes.get(i).leatime);
                    out.println("<td>"+end);
                    out.println("<td>"+routes.get(i).arrTime);
                    out.println("<td>"+routes.get(i).seat[1]);
                    out.println("<td>");
                    out.println("<form action=\"bookTicket\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"id\" value=\""+routes.get(i).id+"\">");
                    out.println("<input type=\"hidden\" name=\"date\" value=\""+time+"\">");
                    out.println("<input type=\"hidden\" name=\"start\" value=\""+start+"\">");
                    out.println("<input type=\"hidden\" name=\"end\" value=\""+end+"\">");
                    out.println("<input type=\"hidden\" name=\"seat\" value=\"seatOne\">");
                    out.println("<input type=\"submit\" name=\"id\" value=\"订票\">");
                    out.println("</from>");
                    out.println("<td>"+routes.get(i).seat[0]);
                    out.println("<td>");
                    out.println("<form action=\"bookTicket\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"id\" value=\""+routes.get(i).id+"\">");
                    out.println("<input type=\"hidden\" name=\"date\" value=\""+time+"\">");
                    out.println("<input type=\"hidden\" name=\"start\" value=\""+start+"\">");
                    out.println("<input type=\"hidden\" name=\"end\" value=\""+end+"\">");
                    out.println("<input type=\"hidden\" name=\"seat\" value=\"seatTwo\">");
                    out.println("<input type=\"submit\" name=\"id\" value=\"订票\">");
                    out.println("</from>");
                    out.println("<td>"+routes.get(i).seat[2]);
                    out.println("<td>");
                    out.println("<form action=\"bookTicket\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"id\" value=\""+routes.get(i).id+"\">");
                    out.println("<input type=\"hidden\" name=\"date\" value=\""+time+"\">");
                    out.println("<input type=\"hidden\" name=\"start\" value=\""+start+"\">");
                    out.println("<input type=\"hidden\" name=\"end\" value=\""+end+"\">");
                    out.println("<input type=\"hidden\" name=\"seat\" value=\"seatBuss\">");
                    out.println("<input type=\"submit\" name=\"id\" value=\"订票\">");
                    out.println("</from>");
                    out.println("<td>"+routes.get(i).type);
                    out.println("<td>"+routes.get(i).price);
                    out.println("<td><a href=\"routeInfo.jsp?id="+routes.get(i).id+"\">查看详情</a>");
                }
            %>
        </table>
    </div>
</div>
</body>
</html>
