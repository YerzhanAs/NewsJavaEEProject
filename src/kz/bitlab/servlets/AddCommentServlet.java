package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.model.Comment;
import kz.bitlab.model.News;
import kz.bitlab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addcomment")
public class AddCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/login";

        request.setCharacterEncoding("utf8");

        Users currentUser = (Users) request.getSession().getAttribute("CURRENT_USER");

        if(currentUser!=null) {

            String commentText = request.getParameter("comment");

            Long newsId= Long.parseLong(request.getParameter("news_id"));

            News news= DBManager.getNewsById(newsId);

            if(news!=null){

                Comment comment = new Comment();

                comment.setComment(commentText);

                comment.setUserId(currentUser);

                comment.setNewsId(news);

                if(DBManager.addComment(comment)){

                    redirect = "/readblog?id="+news;

                }

            }

        }

        response.sendRedirect(redirect);

    }

}
