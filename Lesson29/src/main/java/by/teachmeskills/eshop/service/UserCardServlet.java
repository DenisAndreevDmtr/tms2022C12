package by.teachmeskills.eshop.service;


import by.teachmeskills.eshop.model.CardStorage;
import by.teachmeskills.eshop.model.Product;

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


@WebServlet("/usercard")
public class UserCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("products", session.getAttribute("products"));
        RequestDispatcher rd = req.getRequestDispatcher("usercard.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = CardStorage.getProductsInCard();
        String picture = req.getParameter("picture");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int prc = Integer.parseInt(req.getParameter("price"));
        BigDecimal price = BigDecimal.valueOf(prc);
        int idcategory = Integer.parseInt(req.getParameter("idcategory"));
        Product product = new Product(name, picture, description, price, idcategory);
        products.remove(product);
        products.forEach(x -> System.out.println(x.getName()));
        HttpSession session = req.getSession();
        session.setAttribute("products", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("usercard.jsp");
        requestDispatcher.forward(req, resp);
    }
}
