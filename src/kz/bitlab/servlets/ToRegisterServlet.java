package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value ="/toregister")
public class ToRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re_password");
        String fullName = req.getParameter("full_name");
        String role = req.getParameter("role");
        req.setCharacterEncoding("utf8");

        String redirect = "/register?passworderror";

        if(password.equals(rePassword)){

            redirect="/register?emailerror";

            Users user = DBManager.getUser(email);

            if(user==null){

                if(role.equals("admin")) {
                    role = "1";
                }else{
                    role = "2";
                }
                Users newUser = new Users(null, email, password, fullName, role);

                if(DBManager.addUser(newUser)) {
                    redirect = "/register?success";
                }
            }

        }

        resp.sendRedirect(redirect);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
