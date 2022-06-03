package by.teachmeskills.eshop.commands;


import by.teachmeskills.eshop.composits.OrderProductComposite;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.repositories.impl.OrderRepositoryImpl;
import by.teachmeskills.eshop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.USER_ORDERS;

public class RedirectToProfileImpl implements BaseCommand {

    private OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        int idUser = loggedInUser.getId();
        List<OrderProductComposite> ordersWithProducts = new ArrayList<>();
        List<Integer> idOrders = orderRepository.getAllIdOrdersByUserId(idUser);

        for (int i = 0; i < idOrders.size(); i++) {
            List<Product> productsInOrder = orderRepository.getAllProductsByIdOrder(idOrders.get(i));
            Order order = orderRepository.getOrderByIdOrder(idOrders.get(i));
            OrderProductComposite orderProductComposite = new OrderProductComposite(order, productsInOrder);
            ordersWithProducts.add(orderProductComposite);
        }
        request.setAttribute(USER_ORDERS.getValue(), ordersWithProducts);
        request.setAttribute(LOGGED_IN_USER.getValue(), loggedInUser);
        return PagesPathEnum.PROFILE_PAGE.getPath();
    }
}
