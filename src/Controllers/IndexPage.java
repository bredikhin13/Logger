package Controllers;

import Resourses.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class IndexPage extends HttpServlet {

    ArrayList<User> users;

    private void generateUsers() {
        users = new ArrayList<>();
        users.add(new User("user@mail.com", "1234", "user"));
        users.add(new User("admin@mail.com", "1234", "admin"));
    }

    @Override()
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = req.getParameter("login");
        String pass = req.getParameter("pass");
        generateUsers();
        boolean islogin = false;
        for (User user : users) {
            if (user.getMail().equals(mail)) {
                if (user.getPassword().equals(pass)) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("authorized", true);
                    session.setAttribute("role", user.getRole());
                    session.setAttribute("login", user.getMail());
                    resp.sendRedirect("welcome");
                    islogin = true;
                } else {
                    resp.sendRedirect("wrongaccount");
                }
            }

        }
        if (!islogin) {
            resp.sendRedirect("wrongaccount");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String messsage = (String) session.getAttribute("message");
        if (messsage == null) {
            req.setAttribute("message", messsage);
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
