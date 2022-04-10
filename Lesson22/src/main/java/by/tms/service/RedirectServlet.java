package by.tms.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx = req.getSession().getServletContext();
        if (ctx.getAttribute("login") != null && ctx.getAttribute("password") != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/redirect.jsp");
            requestDispatcher.forward(req, resp);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("logout") != null) {
            ServletContext ctx = req.getSession().getServletContext();
            ctx.setAttribute("login", null);
            ctx.setAttribute("password", null);
            req.getRequestDispatcher("/login.html").forward(req, resp);
        }
    }
}