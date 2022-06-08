package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.impl.OrderRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.eshop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.USER_ORDERS;

public class RedirectToProfileImpl implements BaseCommand {
    private final OrderRepository orderRepository = new OrderRepositoryImpl();
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        int idUser = loggedInUser.getId();
        List<Order>userOrders=new ArrayList<>();
        List<Integer> ordersIds = orderRepository.getAllOrdersIdsByUserId(idUser);
        for (int i = 0; i < ordersIds.size(); i++) {
            List<Product> orderProducts = productRepository.getAllProductsByOrderId(ordersIds.get(i));
            Order order = orderRepository.getOrderById(ordersIds.get(i));
            order.setProductsInOrder(orderProducts);
            userOrders.add(order);
        }
        request.setAttribute(USER_ORDERS.getValue(), userOrders);
        request.setAttribute(LOGGED_IN_USER.getValue(), loggedInUser);
        return PagesPathEnum.PROFILE_PAGE.getPath();
    }
}