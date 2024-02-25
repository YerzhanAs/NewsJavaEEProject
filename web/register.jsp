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
                <h4>
                    LOGIN TO SYSTEM
                </h4>
                <%
                    String success = request.getParameter("success");
                    if(success!=null){
                %>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    User added successfully!
                </div>
                <%
                    }
                %>
                <%
                    String passError = request.getParameter("passworderror");
                    if(passError!=null){
                %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Password are not same
                </div>
                <%
                    }
                %>
                <%
                    String emailError = request.getParameter("emailerror");
                    if(emailError!=null){
                %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    User exists
                </div>
                <%
                    }
                %>
                <form action="/toregister" method="post">
                    <div class="form-group">
                       <label>EMAIL: </label>
                        <input type="email" required class="form-control" name="email">
                    </div>
                    <div class="form-group">
                       <label>PASSWORD: </label>
                        <input type="password" required class="form-control" name="password">
                    </div>
                    <div class="form-group">
                        <label>RE TYPE PASSWORD: </label>
                        <input type="password" required class="form-control" name="re_password">
                    </div>
                    <div class="form-group">
                        <label>FULL NAME : </label>
                        <input type="text" required class="form-control" name="full_name">
                    </div>
                    <div class="form-group">
                        <label for="role">Select Role:</label>
                        <select id="role" name="role" required class="form-control">
                            <option value="user">User</option>
                            <option value="admin">Manager</option>
                        </select>
                    </div>
                    <div class="form-group">
                         <button class="btn btn-success">REGISTER</button>
                    </div>
                </form>

            </div>
        </div>
   </div>
</body>
</html>

