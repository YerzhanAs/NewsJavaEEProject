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

@WebServlet(value = "/edit-category")
public class EditCategoryServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");

        req.setCharacterEncoding("utf8");

        String redirect = "/edit-user?id=" + id + "&error";

        NewsCategories newsCategories = DBManager.getCategoryById(id);

        if(newsCategories!=null){

            newsCategories.setName(name);


            if(DBManager.editCategory(newsCategories)) {
                redirect="/edit-category?id=" + id + "&success";
            }else {
                redirect="/edit-category?id=" + id + "&editerror";
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

            NewsCategories newsCategories = DBManager.getCategoryById(id);

            if(newsCategories!=null){
                req.setAttribute("category", newsCategories);
                req.getRequestDispatcher("/editcategory.jsp").forward(req, resp);
            }

        }else {
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }
    }

}
