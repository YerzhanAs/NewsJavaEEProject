package kz.bitlab.servlets;

import kz.bitlab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Users users = (Users) req.getSession().getAttribute("CURRENT_USER");

        if (users!=null) {
            req.getSession().removeAttribute("CURRENT_USER");
            resp.sendRedirect("/login");
        }else {
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }

    }
}
