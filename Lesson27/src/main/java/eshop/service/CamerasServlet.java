package eshop.service;


import eshop.model.Camera;
import eshop.model.CardStorage;
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

@WebServlet("/cameras")
public class CamerasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Camera> cameras = new ArrayList<>();
        Camera camera1 = new Camera("Canon", "camera1.jpg", "Good camera", new BigDecimal(200));
        Camera camera2 = new Camera("Nikon", "camera2.jpg", "Very good camera", new BigDecimal(250));
        cameras.add(camera1);
        cameras.add(camera2);
        req.setAttribute("cameras", cameras);
        RequestDispatcher rd = req.getRequestDispatcher("cameras.jsp");
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
