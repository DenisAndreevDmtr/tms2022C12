package by.tms.service;

import by.tms.module.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
        requestDispatcher.forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        System.out.println("session" + req.getSession().getAttribute("login"));
//
//        User user = new User();
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//
//        if (!user.getLogin().equals(login) || !user.getPassword().equals(password)) {
//            resp.getWriter().write("Incorrect password or login");
//        } else {
//            ServletContext ctx = req.getSession().getServletContext();
//            ctx.setAttribute("login", login);
//            ctx.setAttribute("password", password);
//            req.getRequestDispatcher("/redirect.jsp").forward(req, resp);
//
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (!user.getLogin().equals(login) || !user.getPassword().equals(password)) {
            resp.getWriter().write("Incorrect password or login");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(checkUser(user, req));
            rd.forward(req, resp);
        }
    }

    private String checkUser(User user, HttpServletRequest request) {
        if (user != null &&
                request.getParameter("login").equals(user.getLogin()) &&
                request.getParameter("password").equals(user.getPassword())) {
            request.getSession().setAttribute("login", request.getParameter("login"));

            return "redirect.jsp";
        }
        return "login.html";
    }


}
