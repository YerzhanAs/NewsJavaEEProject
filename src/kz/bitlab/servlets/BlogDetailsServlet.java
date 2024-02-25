package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.model.Comment;
import kz.bitlab.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/readblog")
public class BlogDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        News news = DBManager.getNewsById(id);

        request.setAttribute("news", news);

        if(news!=null){

            ArrayList<Comment> comments = DBManager.getAllComments(news.getId());

            request.setAttribute("comments", comments);

        }

        request.getRequestDispatcher("/blogdetails.jsp").forward(request, response);

    }

}
