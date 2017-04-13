<%--
  Created by IntelliJ IDEA.
  User: coldplay
  Date: 17-4-10
  Time: 下午11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>INSTANCE OF UPLOAD FILE</h1>
    <form action="/TomcatTest/UploadServlet" method="post" enctype="multipart/form-data">
        CHOOSE A FILE:
        <input type="file" name="uploadFile">
        <br><br>
        <input type="submit" value="upload">
    </form>
</body>
</html>
