package eshop.service;


import eshop.exceptions.RequestParamNullException;
import eshop.model.CategoriesStorage;
import eshop.model.Category;
import eshop.model.User;
import eshop.model.UserStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static eshop.utils.HttpRequestParamValidator.validateParamNotNull;


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
            validateParamNotNull(login);
            validateParamNotNull(pass);


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
            User userThatHasLoggedIn = UserStorage.returnUser(request.getParameter("username"), request.getParameter("password"));
            session.setAttribute("categories", categories);
            request.setAttribute("categories", categories);
            session.setAttribute("userlogin", userThatHasLoggedIn.getLogin());
            session.setAttribute("userpassword", userThatHasLoggedIn.getPassword());
            session.setAttribute("username", userThatHasLoggedIn.getName());
            session.setAttribute("usersurname", userThatHasLoggedIn.getSurname());
            session.setAttribute("userdateborn", userThatHasLoggedIn.getDateBorn());
            session.setAttribute("useremail", userThatHasLoggedIn.getEMail());
            return "devices.jsp";
        } else {
            return "signin.jsp";
        }
    }
}

