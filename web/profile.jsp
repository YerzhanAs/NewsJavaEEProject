<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<div class="container mt-5">
    <div class="row">
        <div class="col-sm-12">
            <h2 class="mb-4">
                Профиль пользователя: <%=(ONLINE ? currentUser.getFullName() : "Нет пользователя")%>
            </h2>
            <% if (ONLINE) { %>
            <div class="card">
                <div class="card-body">
                    <p class="card-text">Имя пользователя: <%= currentUser.getFullName() %></p>
                    <p class="card-text">Email: <%= currentUser.getEmail() %></p>
                    <p class="card-text">Роль: <%= currentUser.getRoleId() == "1" ? "Администратор" : "Пользователь" %></p>
                    <a href="/edit-user?id=<%=currentUser.getId()%>" class="btn btn-info btn-sm">Редактировать</a>
                </div>
            </div>
            <% } else { %>
            <div class="alert alert-warning" role="alert">
                Пользователь не найден.
            </div>
            <% } %>
        </div>
    </div>
</div>
</body>
</html>

