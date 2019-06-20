<%--
  Created by IntelliJ IDEA.
  User: cooktea
  Date: 2019/6/20
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.database.dbAddSeat" %>
<%@ page import="java.util.List" %>
<%@ page import="rote.route" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>增加座位</title>
    <link href="css/search.css" type="text/css" rel="stylesheet">
    <style>
        tr{
            margin-bottom: 40px;
            font-size: 140%;
        }
        select{
            font-size: 110%;
            width: 150px;
        }
    </style>
</head>
<body>
<div class="mainContainer">
    <div style="width: 100%;height: 20%;margin-bottom: 30px;background-color: gray;display: flex;justify-content: center;align-items: center">
        <h1 style="color: white">管理系统</h1>
    </div>
    <div style="width: 100%;height:80%;display: flex;flex-direction: row;justify-content: center;align-items: center">
        <div style="width: 700px;height: 400px;background-color: gray;display: flex;flex-direction: column;align-items: center;justify-content: center">
            <table width="500px">
                <form action="addSeat" method="post">
                <tr style="font-size: 140%">
                    <td width="200px">车次</td>
                    <td width="300px">
                        <select name="route">
                            <%
                                dbAddSeat db = new dbAddSeat();
                                List<String> numbers = db.getRouteNumbers();
                                for(int i=0;i<numbers.size();i++){
                                    out.println(String.format("<option value=\"%s\">%s</option>",numbers.get(i),numbers.get(i)));
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="200px">坐席</td>
                    <td width="300px">
                        <select name="seat">
                            <option value="seatTwo">二等座</option>
                            <option value="seatOne">一等座</option>
                            <option value="seatBuss">商务座</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="200px">时间</td>
                    <td width="100px">
                        <select name="year">
                            <option value="2019">2019</option>
                        </select>
                        年
                    </td>
                    <td width="100px">
                        <select name="month">
                            <%
                                for(int i=1;i<=12;i++){
                                    out.println(String.format("<option value=\"%d\">%d</option>",i,i));
                                }
                            %>
                        </select>
                        月
                    </td>
                    <td width="100px">
                        <select name="day">
                            <%
                                for(int i=1;i<=31;i++){
                                    out.println(String.format("<option value=\"%d\">%d</option>",i,i));
                                }
                            %>
                        </select>
                        日
                    </td>
                </tr>
                <tr>
                    <td width="200px">添加数量</td>
                    <td width="300px">
                        <input type="text" name="number">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="确认">
                    </td>
                </tr>
                </form>
            </table>
        </div>
    </div>
</div>
</body>
</html>
