package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.model.Cart;
import by.teachmeskills.eshop.model.Category;
import by.teachmeskills.eshop.model.User;
import by.teachmeskills.eshop.utils.CategoriesStorage;
import by.teachmeskills.eshop.utils.PagesPathEnum;
import by.teachmeskills.eshop.utils.RequestParamsEnum;
import by.teachmeskills.eshop.utils.UserStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;


public class SignInCommandImpl implements BaseCommand {

    private final static Logger log = LoggerFactory.getLogger(SignInCommandImpl.class);

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
            request.getSession().setAttribute(RequestParamsEnum.LOGIN.getValue(), user);
            List<Category> categories = CategoriesStorage.getCategories();
            HttpSession session = request.getSession();
            Cart cart = new Cart();
            User loggedInUser = UserStorage.returnUser(request.getParameter(RequestParamsEnum.LOGIN.getValue()), request.getParameter(RequestParamsEnum.PASSWORD.getValue()));
            session.setAttribute(CATEGORIES.getValue(), categories);
            request.setAttribute(CATEGORIES.getValue(), categories);
            session.setAttribute(LOGGED_IN_USER.getValue(), loggedInUser);
            session.setAttribute(SHOPPING_CART.getValue(), cart);
            log.info("user with id " + loggedInUser.getIdUser() + " logged in");
            return PagesPathEnum.HOME_PAGE.getPath();
        } else {
            log.warn("user with login " + user.getLogin() + " and password " + user.getPassword() + " failed to login");
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }
    }

}
