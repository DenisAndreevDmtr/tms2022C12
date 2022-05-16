package eshop.service;


import eshop.model.Cart;
import eshop.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@WebServlet("/usercart")
public class UserCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("cart", session.getAttribute("cart"));
        RequestDispatcher rd = req.getRequestDispatcher("usercart.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<Product> products = cart.getProductsInCart();
        String picture = req.getParameter("picture");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int prc = Integer.parseInt(req.getParameter("price"));
        BigDecimal price = BigDecimal.valueOf(prc);
        int idcategory = Integer.parseInt(req.getParameter("idcategory"));
        Product product = new Product(name, picture, description, price, idcategory);
        products.remove(product);
        cart.setProductsInCart(products);
        session.setAttribute("cart", cart);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("usercart.jsp");
        requestDispatcher.forward(req, resp);
    }
}
