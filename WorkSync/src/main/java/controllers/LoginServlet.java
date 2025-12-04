package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Userdb;
import repository.UserRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name=request.getParameter("username");
        String password=request.getParameter("password");

        Userdb user=UserRepository.getUserByUsername(name);

        if (user!=null && user.getPassword().equals(password)) {
            List<Userdb> users=UserRepository.getAllUsers();
            request.setAttribute("userList",users);
            RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
            rd.forward(request,response);
        } else {
            request.setAttribute("errorMessage", "Invalid credentials, please try again");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
    }
}
