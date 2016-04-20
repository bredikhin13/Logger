package Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Resourses.User on 11.04.2016.
 */
public class WelcomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(true);
        Boolean flag = (Boolean) session.getAttribute("authorized");
        if (flag == null || flag == false) {
            session.setAttribute("message","Please register");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.setAttribute("login",session.getAttribute("login"));
            req.setAttribute("role",session.getAttribute("role"));
            getServletContext().getRequestDispatcher("/myjsp.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
//        session.removeAttribute("authorized");
//        session.removeAttribute("role");
//        session.removeAttribute("login");
        resp.sendRedirect("index");
    }
}
