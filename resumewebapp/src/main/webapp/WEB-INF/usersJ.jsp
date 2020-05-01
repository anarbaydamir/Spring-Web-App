<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: qwant
  Date: 4/5/20
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/users.css"/>
    <script src="https://kit.fontawesome.com/3892d0e7af.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="assets/js/users.js"></script>
    <title>Title</title>
</head>
<body>
    <%
        List<User> list = (List<User>) request.getAttribute("list");
    %>
    <div class="container">
        <form action="logout" method="post">
<%--        <span> Welcome <%=user.getName()%> </span>--%>
        <input type="submit" class="btn btn-primary" name="logout" value="Log Out" style="float: right;">
        </form>
    </div>
    <div class="container mycontainer">
    <div class="row">
        <div class="col-sm-4">
    <form method="get" action="users">
        <div class="form-group">
        <label for="name">name:</label>
        <input class="form-control" placeholder="enter name" type="text" name="name" value=""/>
        </div>
        <div class="form-group">
        <label for="surname">surname:</label>
        <input class="form-control" placeholder="enter surname" type="text" name="surname" value=""/>
        </div>
        <input class="btn btn-primary" type="submit" name="search" value="Search"/>
    </form>
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
            <%
                for (User u: list
                     ) {
            %>
            <tr>
                <td><%=u.getName()%></td>
                <td><%=u.getSurname()%></td>
                <td><%=u.getNationalityId().getNationality()%></td>
                <td style="width: 5px">
                        <input type="hidden" name="id" value="<%=u.getId()%>"/>
                        <input type="hidden" name="action" value="delete"/>
                    <button onclick="getIdForDelete(<%=u.getId()%>)"  class="btn btn-danger" type="submit" value="delete"  data-toggle="modal" data-target="#exampleModal">
                    <i class="fa fa-trash-o"></i>
                    </button>
                </td>
                <td style="width: 5px">
                    <form action="userdetail" method="get">
                        <input type="hidden" name="userId" value="<%=u.getId()%>"/>
                        <button class="btn btn-secondary" type="submit" value="update">
                            <i class="fa fa-pencil"></i>
                        </button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
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
