package by.teachmeskills.eshop.service;

import by.teachmeskills.eshop.model.Cart;
import by.teachmeskills.eshop.model.CategoriesStorage;
import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.model.ProductsStorage;

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
import java.util.stream.Collectors;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Product> products = ProductsStorage.getProducts().stream().filter(x -> x.getIdCategory() == id).collect(Collectors.toList());
        req.setAttribute("namecategory", CategoriesStorage.getCategoryNameById(id));
        req.setAttribute("products", products);
        req.getServletContext().getRequestDispatcher("/category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String picture = req.getParameter("picture");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int prc = Integer.parseInt(req.getParameter("price"));
        BigDecimal price = BigDecimal.valueOf(prc);
        int idCategory = Integer.parseInt(req.getParameter("idcategory"));
        Product product = new Product(name, picture, description, price, idCategory);
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<Product> products = cart.getProductsInCart();
        if (products == null) {
            List<Product> productList = new ArrayList<>();
            products = productList;
        }
        products.add(product);
        cart.setProductsInCart(products);
        BigDecimal totalSum = cart.getProductsInCart().stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        session.setAttribute("cart", cart);
        req.setAttribute("totalsum", totalSum);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/usercart.jsp");
        requestDispatcher.forward(req, resp);
    }
}
