
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://kit.fontawesome.com/3892d0e7af.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="assets/js/users.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="logout" method="get">
        <%--        <span> Welcome <%=user.getName()%> </span>--%>
        <input type="submit" class="btn btn-primary" name="logout" value="Log Out" style="float: right;">
    </form>
</div>
<div class="container mycontainer">
    <div class="row">
        <div class="col-sm-4">
            <form:form method="get" action="users" modelAttribute="user">
                <div class="form-group">
                    <label for="name">name:</label>
                    <form:input class="form-control"
                                placeholder="enter name"
                                path="name"/>
                    <form:errors path="name" cssStyle="color: red"/>
                </div>
                <div class="form-group">
                    <label for="surname">surname:</label>
                    <form:input class="form-control"
                                placeholder="enter surname"
                                path="surname"/>
                    <form:errors path="surname" cssStyle="color: red"/>
                </div>
                <form:hidden path="nationalityId"></form:hidden>
                <form:button class="btn btn-primary" id="btnsearch">Search</form:button>
            </form:form>
        </div>
    </div>
    <div>
        <hr/>
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.name}</td>
                <td>${u.surname}</td>
                <td>${u.nationalityId.name}</td>
                <td style="width: 5px">
                    <input type="hidden" name="id" value="${u.id}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button onclick="getIdForDelete(${u.id})"  class="btn btn-danger" type="submit" value="delete"  data-toggle="modal" data-target="#exampleModal">
                        <i class="fa fa-trash-o"></i>
                    </button>
                </td>
                <td style="width: 5px">
                    <form action="userdetail" method="get">
                        <input type="hidden" name="id" value="${u.id}"/>
                        <button class="btn btn-secondary" type="submit" value="update">
                            <i class="fa fa-pencil"></i>
                        </button>
                    </form>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <form action="userdetail" method="post">
                    <input type="hidden" id="idForDelete" name="id" value=""/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
