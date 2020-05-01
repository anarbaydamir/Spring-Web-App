<%--
  Created by IntelliJ IDEA.
  User: qwant
  Date: 4/10/20
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Logout</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="login_background">
    <form action="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}">
        <button type="submit" class="btn btn-primary" name="login">Logout</button>
    </form>
</body>
</html>
