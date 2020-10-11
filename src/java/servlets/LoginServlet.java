package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 710429
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        
         String action = request.getParameter("action");
        if (action != null && action.equals("reset")) {
            session.invalidate();
            session = request.getSession();
        }
        
        if(session.getAttribute("username") != null) {
            response.sendRedirect("home");
        }
        else
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null || username.equals("") || (password == null) || password.equals("")) {
            request.setAttribute("errorMessage", "Error: User name and password must be filled in");
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             return;
        }
        
        AccountService aService = new AccountService();
        User loginAttempt = aService.login(username, password); 
        
        if(loginAttempt == null) {
            request.setAttribute("errorMessage", "Wrong login information");
            session.setAttribute("username", username);
            session.setAttribute("password", null);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);    
        }
        else {
            session.setAttribute("username", loginAttempt.getUsername());
            response.sendRedirect("home"); 
        }
    }

}
