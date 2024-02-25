package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.model.NewsCategories;
import kz.bitlab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/addcategory")
public class AddNewsCategoreisServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        req.setCharacterEncoding("utf8");

        String redirect = "/addcategory?error";

        if(DBManager.addNewsCategory(new NewsCategories(null, name))){
            redirect ="/addcategory?success";
        }

        resp.sendRedirect(redirect);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = (Users) req.getSession().getAttribute("CURRENT_USER");

        if (users!=null && users.getRoleId().equals("1")){
            ArrayList<NewsCategories> categories = DBManager.getNewsCategories();
            req.setAttribute("categories", categories);

            req.getRequestDispatcher("/addcategory.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }
    }
}
