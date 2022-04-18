package by.tms.service;

import by.tms.module.User;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher rd;
        User user = (User) req.getSession().getAttribute("user");
        if (Optional.ofNullable(user).isEmpty()) {
            rd = req.getRequestDispatcher("WEB-INF/login.html");
        } else {
            rd = req.getRequestDispatcher("WEB-INF/redirect.jsp");
        }
        rd.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute("user");
        RequestDispatcher rd;
        if (Optional.ofNullable(user).isEmpty()) {
            rd = req.getRequestDispatcher(checkUser(new User(), req));
        } else {
            rd = req.getRequestDispatcher(checkUser(user, req));
        }
        rd.forward(req, resp);
    }

    private String checkUser(User user, HttpServletRequest request) {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (user != null &&
                !validateParamNotNull(login) &&
                !validateParamNotNull(pass) &&
                login.equals(user.getLogin()) &&
                pass.equals(user.getPassword())) {
            request.getSession().setAttribute("user", user);
            return "WEB-INF/redirect.jsp";
        }
        return "WEB-INF/login.html";
    }

    private boolean validateParamNotNull(String param) {
        return Optional.ofNullable(param).isEmpty();
    }
}


