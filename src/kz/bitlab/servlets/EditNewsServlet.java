package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.model.News;
import kz.bitlab.model.NewsCategories;
import kz.bitlab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/edit-news")
public class EditNewsServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Long category = Long.parseLong(req.getParameter("category"));

        req.setCharacterEncoding("utf8");

        String redirect = "/edit-user?id=" + id + "&error";

        News news= DBManager.getNewsById(id);
        NewsCategories newsCategories = DBManager.getCategoryById(category);

        if(category!=null) {
            if (news != null) {

                news.setTitle(title);
                news.setContent(content);
                news.setCategoryId(newsCategories);

                if (DBManager.editNews(news)) {
                    redirect = "/edit-news?id=" + id + "&success";
                } else {
                    redirect = "/edit-news?id=" + id + "&editerror";
                }
            }
        }

        resp.sendRedirect(redirect);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = 0L;

        Users usersLogin = (Users) req.getSession().getAttribute("CURRENT_USER");

        if (usersLogin!=null && usersLogin.getRoleId().equals("1")) {

            try {
                id = Long.parseLong(req.getParameter("id"));
            }
            catch (Exception e) {
            }

            News news = DBManager.getNewsById(id);

            if(news!=null){
                req.setAttribute("news", news);
                ArrayList<NewsCategories> categories = DBManager.getNewsCategories();
                req.setAttribute("categories", categories);
                req.getRequestDispatcher("/editnews.jsp").forward(req, resp);
            }

        }else {
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }
    }

}
