package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String redirect = "/login?emailerror";

        Users user = DBManager.getUser(email);

        if(user!=null){

            redirect = "/login?passworderror";

            if(user.getPassword().equals(password)){
                req.getSession().setAttribute("CURRENT_USER", user);
                redirect="/";
            }

        }

        resp.sendRedirect(redirect);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
