package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.model.News;
import kz.bitlab.model.NewsCategories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deletenews")
public class DeleteNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));

        News news = DBManager.getNewsById(id);

        if(news!=null){

            if(DBManager.deleteNews(news)) {
                resp.sendRedirect("/addnews");
            }else {
                resp.sendRedirect("/addnews" + id + "&error");
            }

        }else {
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
