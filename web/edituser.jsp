
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
   <div class="container">
        <div class="row mt-5">
            <div class="col-sm-6 offset-3">
                <%
                    Users users = (Users) request.getAttribute("user");
                    if(users!=null){
                %>
                    <%
                        String success = request.getParameter("success");
                        if(success!=null){
                    %>
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        Edited successfully!
                    </div>
                    <%
                        }
                    %>
                    <%
                        String emailerror = request.getParameter("emailerror");
                        if(emailerror!=null){
                    %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        This email is exist!
                    </div>
                    <%
                        }
                    %>
                    <%
                        String error = request.getParameter("error");
                        if(error!=null){
                    %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        Something went wrong!
                    </div>
                    <%
                        }
                    %>
                    <form action="/edit-user" method="post">
                        <input type="hidden" name="id" value="<%=users.getId()%>">
                        <div class="form-group">
                            <label>Имя: </label>
                            <input type="text" name="name" class="form-control" value="<%=users.getFullName()%>">
                        </div>
                        <div class="form-group">
                            <label>Пароль: </label>
                            <input type="password" name="password" class="form-control" value="<%=users.getPassword()%>">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success">Edit user</button>
                        </div>
                    </form>

                <%
                    }
                %>
            </div>
        </div>
   </div>
</body>
</html>

