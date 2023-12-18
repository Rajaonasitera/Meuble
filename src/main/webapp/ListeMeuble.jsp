<%@ page import="com.example.meuble.model.Materiel" %>
<%@ page import="com.example.meuble.model.Style" %><%--
  Created by IntelliJ IDEA.
  User: taraj
  Date: 11/12/2023
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Materiel[] allM = (Materiel[])request.getAttribute("materiaux");
    Style s = (Style) request.getAttribute("style");
%>
<%@include file="./Header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste de </title>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/index.css">
</head>
<body style="background-color:#e7e7e7;">
<center>
    <h1><%out.print(s.getLibelle());%></h1>
    <div style="width: 80px;height: 5px;background: #337ab7;border-radius: 7px;margin-bottom: 50px;"></div>
    <table class='table table-hover'>
        <tr>
            <th></th>
            <th>Materiel</th>
        </tr>
        <% for (int i = 0; i < allM.length; i++) {%>
            <tr>
                <td><%out.print(i+1);%></td>
                <td><%out.print(allM[i].getLibelle());%></td>
            </tr>
        <%}%>


    </table>


</center>



</body>
</html>