<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    // 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("basePath",basePath);
%>
<%--jsp文件相关--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
</head>
<body>
<h2><a href="<c:url value='/bill/getBillList'/>">${requestScope.get("basePath")}bill/getBillList</a></h2>
<h2><a href="<c:url value='/bill/getBillById?bId=1000'/>">${requestScope.get("basePath")}bill/getBillById?bId=1000</a></h2>
</body>
</html>