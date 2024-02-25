<%@include file="user.jsp"%>
<%@include file="head.jsp"%>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #782b3d">
    <a class="navbar-brand" href="/">BBC.KZ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <%
                if(ONLINE){
            %>
                <li class="nav-item">
                    <a class="nav-link" href="/profile"><%=currentUser.getFullName()%></a>
                </li>
                <%
                    if(currentUser.getRoleId().equals("1"))
                    {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/addcategory">Edit Category</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/addnews">Edit News</a>
                </li>
                <%
                    }
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>

            <%
                }else{
            %>
                <li class="nav-item">
                    <a class="nav-link" href="/">News</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>
            <%
                }
            %>
        </ul>
    </div>
</nav>
