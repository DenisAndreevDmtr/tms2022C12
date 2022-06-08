package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.UserRepository;
import by.teachmeskills.eshop.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.UserRepositoryImpl;
import by.teachmeskills.eshop.utils.PagesPathEnum;
import by.teachmeskills.eshop.utils.RequestParamsEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;

public class SignInCommandImpl implements BaseCommand {
    private final static Logger log = LoggerFactory.getLogger(SignInCommandImpl.class);
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();

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
        String login = request.getParameter(RequestParamsEnum.LOGIN.getValue());
        String password = request.getParameter(RequestParamsEnum.PASSWORD.getValue());
        Optional<User> userOptional = userRepository.getUserByLoginAndPassword(login, password);
        if (userOptional.isPresent() && user != null) {
            User loggedInUser = userOptional.get();
            request.getSession().setAttribute(RequestParamsEnum.LOGIN.getValue(), user);
            List<Category> categories = categoryRepository.getAllCategories();
            HttpSession session = request.getSession();
            Cart cart = new Cart();
            session.setAttribute(CATEGORIES.getValue(), categories);
            session.setAttribute(LOGGED_IN_USER.getValue(), loggedInUser);
            session.setAttribute(SHOPPING_CART.getValue(), cart);
            log.info("user with id " + loggedInUser.getId() + " logged in");
            return PagesPathEnum.HOME_PAGE.getPath();
        } else {
            log.warn("user with login " + user.getLogin() + " and password " + user.getPassword() + " failed to login");
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }
    }
}