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

@WebServlet(value = "/addnews")
public class AddNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Long category = Long.parseLong(req.getParameter("category"));

        req.setCharacterEncoding("utf8");

        String redirect = "/addnews?error";

        NewsCategories newsCategories = DBManager.getCategoryById(category);

        if(newsCategories!=null) {
            if (DBManager.addNews(new News(null, null, newsCategories, title, content))) {
                redirect = "/addnews?success";
            }
        }

        resp.sendRedirect(redirect);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users currentUser = (Users) req.getSession().getAttribute("CURRENT_USER");

        if(currentUser!=null && currentUser.getRoleId().equals("1")) {
            ArrayList<NewsCategories> categories = DBManager.getNewsCategories();
            req.setAttribute("categories", categories);

            ArrayList<News> news= DBManager.getNews();
            req.setAttribute("news", news);
            req.getRequestDispatcher("/addnews.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("/login");
        }

    }
}
