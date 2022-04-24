package eshop.service;


import eshop.model.CardStorage;
import eshop.model.Fridge;
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

@WebServlet("/fridges")
public class FridgesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Fridge> fridges = new ArrayList<>();
        Fridge fridge1 = new Fridge("LG", "fridge1.jpg", "Good fridge", new BigDecimal(900));
        Fridge fridge2 = new Fridge("SAMSUNG", "fridge2.jpg", "Very good fridge", new BigDecimal(1050));
        fridges.add(fridge1);
        fridges.add(fridge2);
        req.setAttribute("fridges", fridges);
        RequestDispatcher rd = req.getRequestDispatcher("fridges.jsp");
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
