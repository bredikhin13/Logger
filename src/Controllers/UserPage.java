package Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Resourses.User on 20.04.2016.
 */
public class UserPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String role = (String) session.getAttribute("role");
        if(role.equals("user")){
            getServletContext().getRequestDispatcher("/userpage.jsp").forward(req,resp);
        } else {
            getServletContext().getRequestDispatcher("/wrongrole.jsp").forward(req,resp);
        }
    }
}
