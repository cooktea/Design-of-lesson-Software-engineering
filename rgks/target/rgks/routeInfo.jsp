<%--
  Created by IntelliJ IDEA.
  User: cooktea
  Date: 2019/6/12
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="util.database.dbRouteInfo" %>
<%@page import="rote.station" %>
<%@page import="java.util.List" %>

<html>
<head>
    <title>车次信息</title>
    <link href="css/routeList.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="mainContainer">
    <div style="width: 100%;height: 20%;margin-bottom: 30px;background-color: gray;display: flex;justify-content: center;align-items: center">
        <%
            String id = request.getParameter("id");
            out.println("<h1 style=\"color:white\">"+id+" 车次信息</h1>");
        %>
        <a href="index.html">返回首页</a>
    </div>
    <div style="width: 100%">
        <table border="1" style="width: 100%">
            <tr>
                <th>编号</th>
                <th>站点名</th>
                <th>到达时刻</th>
                <th>出发时刻</th>
                <th>价格</th>
            </tr>
            <%
                dbRouteInfo db = new dbRouteInfo(request.getParameter("id"));
                List<station> stations = db.getStations();
                for(int i=0;i<stations.size();i++){
                    out.println("<tr>");
                    out.println(String.format("<td>%s</td>",i+1));
                    out.println(String.format("<td>%s</td>",stations.get(i).name));
                    out.println(String.format("<td>%s</td>",stations.get(i).arrTime));
                    out.println(String.format("<td>%s</td>",stations.get(i).leaTime));
                    out.println(String.format("<td>%s</td>",stations.get(i).price));
                }
            %>
        </table>
    </div>
</div>
</body>
</html>
