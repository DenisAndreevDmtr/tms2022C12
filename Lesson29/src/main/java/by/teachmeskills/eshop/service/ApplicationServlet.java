package by.teachmeskills.eshop.service;


import by.teachmeskills.eshop.exceptions.RequestParamNullException;
import by.teachmeskills.eshop.model.CategoriesStorage;
import by.teachmeskills.eshop.model.Category;
import by.teachmeskills.eshop.model.User;
import by.teachmeskills.eshop.model.UserStorage;
import by.teachmeskills.eshop.utils.HttpRequestParamValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/login")
public class ApplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("signin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String pass = req.getParameter("password");
        User user = null;

        try {
            HttpRequestParamValidator.validateParamNotNull(login);
            HttpRequestParamValidator.validateParamNotNull(pass);


        } catch (RequestParamNullException e) {
            System.out.println(e.getMessage());
        }

        RequestDispatcher rd = req.getRequestDispatcher(checkReceivedUser(user, req));
        rd.forward(req, resp);

    }

    private String checkReceivedUser(User user, HttpServletRequest request) {
        List<User> users = UserStorage.getUsers();
        User admin = new User("admin", "admin");
        users.add(admin);
        UserStorage.setUsers(users);
        if (UserStorage.сheckUser(request.getParameter("username"), request.getParameter("password"))) {
            request.getSession().setAttribute("username", user);
            List<Category> categories = CategoriesStorage.getCategories();
            HttpSession session = request.getSession();
            session.setAttribute("categories", categories);
            request.setAttribute("categories", categories);
            return "devices.jsp";
        } else {
            return "signin.jsp";
        }
    }
}

