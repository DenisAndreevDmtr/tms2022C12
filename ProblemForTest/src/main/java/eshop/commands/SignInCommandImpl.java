package eshop.commands;

import eshop.exceptions.CommandException;
import eshop.model.Cart;
import eshop.model.Category;
import eshop.model.User;
import eshop.utils.CategoriesStorage;
import eshop.utils.PagesPathEnum;
import eshop.utils.RequestParamsEnum;
import eshop.utils.UserStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;


public class SignInCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(RequestParamsEnum.LOGIN.getValue());
        String pass = request.getParameter(RequestParamsEnum.PASSWORD.getValue());

        validateParamNotNull(login);
        validateParamNotNull(pass);

        User user = new User(login, pass);
        return checkReceivedUser(user, request);
    }

    private String checkReceivedUser(User user, HttpServletRequest request) {
        List<User> users = UserStorage.getUsers();
        User admin = new User("admin", "admin");
        users.add(admin);
        UserStorage.setUsers(users);

        if (user != null && UserStorage.сheckUser(request.getParameter(RequestParamsEnum.LOGIN.getValue()), request.getParameter(RequestParamsEnum.PASSWORD.getValue()))) {
            request.getSession().setAttribute("username", user);
            List<Category> categories = CategoriesStorage.getCategories();
            HttpSession session = request.getSession();
            Cart cart = new Cart();
            User loggedInUser = UserStorage.returnUser(request.getParameter("username"), request.getParameter("password"));
            session.setAttribute(CATEGORIES.getValue(), categories);
            request.setAttribute(CATEGORIES.getValue(), categories);
            session.setAttribute(LOGGED_IN_USER.getValue(), loggedInUser);
            session.setAttribute(SHOPPING_CART.getValue(), cart);
            return PagesPathEnum.HOME_PAGE.getPath();
        } else {
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }
    }

}
