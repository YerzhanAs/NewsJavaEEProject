<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.NewsCategories" %>
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
                String success = request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Category added successfully!
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
            <form action="/addcategory" method="post">
                <div class="form-group">
                    <label>NAME: </label>
                    <input type="text" name="name" class="form-control">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">ADD Category</button>
                </div>
            </form>
                <h4>
                    List of Categories
                </h4>
                <table class="table">
                    <thead>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>EDIT</th>
                    <th>DELETE</th>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<NewsCategories> categories = (ArrayList<NewsCategories>) request.getAttribute("categories");

                        if(categories!=null){
                            for (NewsCategories category : categories) {

                    %>
                    <tr>
                        <td>
                            <%=category.getId()%>
                        </td>
                        <td>
                            <%=category.getName()%>
                        </td>
                        <td>
                            <a href="/edit-category?id=<%=category.getId()%>" class="btn btn-info btn-sm">EDIT</a>
                        </td>
                        <td>
                            <form action="/deletecategory" method="post">
                             <input type="hidden" name="id" value="<%=category.getId()%>">
                            <button class="btn btn-danger">DELETE</button>
                            </form>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
        </div>
    </div>
</div>
</body>
</html>


