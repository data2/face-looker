<%--
  Created by IntelliJ IDEA.
  User: wanglei
  Date: 2016/10/4
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>人脸识别 facelooker</title>
</head>
<body>
<form action="${basePath}face/upload.do" method="post" enctype="multipart/form-data">
    <label>选择图片</label><input type="file" name="file"/><br/>
    <input type="submit" value="提  交"/>
</form>
</body>
</html>
