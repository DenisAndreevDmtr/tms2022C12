package eshop.service;


import eshop.model.Cart;
import eshop.model.Order;
import eshop.model.OrderStorage;
import eshop.model.Product;
import eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<Product> products = cart.getProductsInCart();
        BigDecimal priceOrder = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        LocalDate date = LocalDate.now();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        Order order = new Order(priceOrder, products, date, loggedInUser.getIdUser());
        List<Order> orderStorage = OrderStorage.getOrderStorage();
        orderStorage.add(order);
        OrderStorage.setOrderStorage(orderStorage);
        List<Product> emptyProductList = new ArrayList<>();
        cart.setProductsInCart(emptyProductList);
        session.setAttribute("cart", cart);
        req.setAttribute("idOrder", order.getIdOrder());
        req.setAttribute("priceOrder", priceOrder);
        RequestDispatcher rd = req.getRequestDispatcher("order.jsp");
        rd.forward(req, resp);
    }
}
