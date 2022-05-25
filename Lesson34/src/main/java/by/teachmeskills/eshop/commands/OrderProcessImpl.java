package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.model.Cart;
import by.teachmeskills.eshop.model.Order;
import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.model.User;
import by.teachmeskills.eshop.utils.OrderStorage;
import by.teachmeskills.eshop.utils.PagesPathEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static by.teachmeskills.eshop.utils.RequestParamsEnum.ID_ORDER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRICE_ORDER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;


public class OrderProcessImpl implements BaseCommand {

    private final static Logger log = LoggerFactory.getLogger(OrderProcessImpl.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute(SHOPPING_CART.getValue());
        List<Product> products = cart.getProducts();
        BigDecimal priceOrder = cart.getTotalPrice();
        LocalDate date = LocalDate.now();
        User loggedInUser = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        Order order = new Order(priceOrder, products, date, loggedInUser.getIdUser());
        List<Order> orderStorage = OrderStorage.getOrderStorage();
        orderStorage.add(order);
        OrderStorage.setOrderStorage(orderStorage);
        cart.clear();
        cart.setTotalPrice(new BigDecimal(0));
        session.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart);
        request.setAttribute(ID_ORDER.getValue(), order.getIdOrder());
        request.setAttribute(PRICE_ORDER.getValue(), priceOrder);
        log.info("user with id " + loggedInUser.getIdUser() + " purchased order with id " + order.getIdOrder());

        return PagesPathEnum.ORDER_PAGE.getPath();
    }
}

