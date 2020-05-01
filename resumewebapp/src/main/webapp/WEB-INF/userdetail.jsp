<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<form:form method="post" action="userdetail" modelAttribute="user">
    <div class="container">
    <div class="row">
    <div class="col-sm-4">
        <form:hidden path="id"/>
    <div class="form-group">
        <label for="name">name:</label>
        <form:input class="form-control" path="name"/>
    </div>
    <div class="form-group">
        <label for="surname">surname:</label>
        <form:input class="form-control" path="surname"/>
    </div>
    <div class="form-group">
        <label for="email">email:</label>
        <form:input class="form-control" path="email"/>
    </div>
    <div class="form-group">
        <label for="phoneNumber">phone number:</label>
        <form:input class="form-control" path="phoneNumber"/>
    </div>
        <form:button class="btn btn-primary" id="btnSave">Save</form:button>
    </div>
    </div>
    </div>
</form:form>
</body>
</html>
