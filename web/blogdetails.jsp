<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<div class="container" style="min-height: 500px;">

    <div class="row mt-3">

        <div class="col-12">

            <%

                News news = (News) request.getAttribute("news");

                if(news!=null){

            %>

            <div class="row mt-3">

                <div class="col-11 mx-auto p-3" style="background-color: lightgrey;">

                    <h2><%=news.getTitle()%></h2>

                    <p class="mt-2"><%=news.getContent()%></p>

                    <p class="mt-2">

                        Category <strong><%=news.getCategoryId().getName()%></strong>

                        at <strong><%=news.getPostDate()%></strong>

                    </p>

                    <%

                        if(currentUser!=null){

                    %>

                    <div class="row mt-2">

                        <div class="col-12">

                            <form action="/addcomment" method="post">

                                <input type="hidden" name="blog_id" value="<%=news.getId()%>">

                                <textarea class="form-control" name="comment" placeholder="Write a comment"></textarea>

                                <button class="btn btn-success mt-3">ADD COMMENT</button>

                            </form>

                        </div>

                    </div>

                    <%

                        }

                    %>

                    <hr>

                    <%

                        ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");

                        if(comments!=null){

                            for(Comment comment : comments){

                    %>

                    <div class="row mt-2">

                        <div class="col-12">

                            <h5><%=comment.getUserId().getFullName()%></h5>

                            <p><%=comment.getComment()%></p>

                            <p>At <strong><%=comment.getPostDate()%></strong></p>

                        </div>

                    </div>

                    <%

                            }

                        }

                    %>

                </div>

            </div>

            <%

                }

            %>

        </div>

    </div>

</div>
</body>
</html>

