package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.model.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit-user")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        req.setCharacterEncoding("utf8");

        String redirect = "/edit-user?id=" + id + "&error";

        Users user = DBManager.getUserById(id);

            if(user!=null){

                user.setFullName(name);
                user.setPassword(password);

                if(DBManager.editUser(user)) {
                    changeDataInSession(user, req);
                    redirect="/edit-user?id=" + id + "&success";
                }else {
                    redirect="/edit-user?id=" + id + "&editerror";
                }
            }

        resp.sendRedirect(redirect);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = 0L;

        Users usersLogin = (Users) req.getSession().getAttribute("CURRENT_USER");

        if (usersLogin!=null) {

            try {
                id = Long.parseLong(req.getParameter("id"));
            }
            catch (Exception e) {
            }
            Users users = DBManager.getUserById(id);

            if (users != null) {
                req.setAttribute("user", users);
                req.getRequestDispatcher("/edituser.jsp").forward(req, resp);
            } else{
                req.getRequestDispatcher("/404.jsp").forward(req, resp);
            }
        }else {
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }
    }

    private void changeDataInSession(Users editUsers, HttpServletRequest req){
        Users userLogin = (Users) req.getSession().getAttribute("CURRENT_USER");
        userLogin.setEmail(editUsers.getEmail());
        userLogin.setPassword(editUsers.getPassword());
        userLogin.setFullName(editUsers.getFullName());
    }

}
