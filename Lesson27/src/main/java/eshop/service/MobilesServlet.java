package eshop.service;


import eshop.model.CardStorage;
import eshop.model.Mobile;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mobiles")
public class MobilesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Mobile> mobiles = new ArrayList<>();
        Mobile mobile1 = new Mobile("HTC", "mobile1.jpg", "Good mobile phone", new BigDecimal(500));
        Mobile mobile2 = new Mobile("ZTE", "mobile2.jpg", "Very good mobile phone", new BigDecimal(550));
        mobiles.add(mobile1);
        mobiles.add(mobile2);
        req.setAttribute("mobiles", mobiles);
        RequestDispatcher rd = req.getRequestDispatcher("mobiles.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String picture = req.getParameter("picture");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int prc = Integer.parseInt(req.getParameter("price"));
        BigDecimal price = BigDecimal.valueOf(prc);
        Product product = new Product(name, picture, description, price);
        List<Product> products = CardStorage.getProductsInCard();
        products.add(product);
        CardStorage.setProductsInCard(products);
        HttpSession session = req.getSession();
        session.setAttribute("products", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("usercard.jsp");
        requestDispatcher.forward(req, resp);
    }
}
