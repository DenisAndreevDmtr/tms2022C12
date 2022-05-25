package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.model.Order;
import by.teachmeskills.eshop.model.User;
import by.teachmeskills.eshop.utils.OrderStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

import static by.teachmeskills.eshop.utils.PagesPathEnum.PROFILE_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.USER_ORDERS;


public class RedirectToProfileImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        int idUser = loggedInUser.getIdUser();
        List<Order> orderStorage = OrderStorage.getOrderStorage();
        List<Order> orders = orderStorage.stream().filter(x -> x.getIdUser() == idUser).collect(Collectors.toList());
        request.setAttribute(USER_ORDERS.getValue(), orders);
        request.setAttribute(LOGGED_IN_USER.getValue(), loggedInUser);
        return PROFILE_PAGE.getPath();
    }
}
