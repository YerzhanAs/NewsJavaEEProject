<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.News" %>
<%@ page import="kz.bitlab.model.NewsCategories" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <%
                String success = request.getParameter("success");
                if(success != null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                News added successfully!
            </div>
            <%
                }
            %>
            <%
                String error = request.getParameter("error");
                if(error != null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Something went wrong!
            </div>
            <%
                }
            %>
            <form action="/addnews" method="post">
                <div class="form-group">
                    <label>Title:</label>
                    <input type="text" name="title" class="form-control">
                </div>
                <div class="form-group">
                    <label>Content:</label>
                    <textarea name="content" class="form-control" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <label>Category:</label>
                    <select id="category" name="category" required class="form-control">
                        <%
                            ArrayList<NewsCategories> categories = (ArrayList<NewsCategories>) request.getAttribute("categories");
                            if(categories != null) {
                                for (NewsCategories category : categories) {
                        %>
                        <option value="<%= category.getId() %>"><%= category.getName() %></option>
                        <%
                                }
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <button class="btn btn-success">Add News</button>
                </div>
            </form>
            <h4>List of News</h4>
            <table class="table">
                <thead>
                <th>ID</th>
                <th>Title</th>
                <th>Category</th>
                <th>Edit</th>
                <th>Delete</th>
                </thead>
                <tbody>
                <%
                    ArrayList<News> newsList = (ArrayList<News>) request.getAttribute("news");
                    if(newsList != null){
                        for (News news : newsList) {
                %>
                <tr>
                    <td><%= news.getId() %></td>
                    <td><%= news.getTitle() %></td>
                    <td><%= news.getCategoryId().getName()%></td>
                    <td>
                        <a href="/edit-news?id=<%= news.getId() %>" class="btn btn-info btn-sm">Edit</a>
                    </td>
                    <td>
                        <form action="/deletenews" method="post">
                            <input type="hidden" name="id" value="<%= news.getId() %>">
                            <button class="btn btn-danger btn-sm">Delete</button>
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
