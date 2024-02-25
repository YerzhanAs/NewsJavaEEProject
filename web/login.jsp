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
                    String passError = request.getParameter("passworderror");
                    if(passError!=null){
                %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                   Incorrect password
                </div>
                <%
                    }
                %>
                <%
                    String emailError = request.getParameter("emailerror ");
                    if(emailError!=null){
                %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Incorrect email
                </div>
                <%
                    }
                %>
                <form action="/auth" method="post">
                    <div class="form-group">
                       <label>EMAIL: </label>
                        <input type="email" required class="form-control" name="email">
                    </div>
                    <div class="form-group">
                       <label>PASSWORD: </label>
                        <input type="password" required class="form-control" name="password">
                    </div>
                    <div class="form-group">
                         <button class="btn btn-success">LOGIN</button>
                    </div>
                </form>

            </div>
        </div>
   </div>
</body>
</html>

