package by.tms.eshop.service;


import by.tms.eshop.model.Laptop;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebServlet("/laptops")
public class LaptopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Laptop> laptops = new ArrayList<>();
        Laptop laptop1 = new Laptop("HP", "laptop1.png", "Good laptop", new BigDecimal(800));
        Laptop laptop2 = new Laptop("DELL", "laptop2.jpg", "Very good laptop", new BigDecimal(950));
        laptops.add(laptop1);
        laptops.add(laptop2);
        req.setAttribute("laptops", laptops);
        RequestDispatcher rd = req.getRequestDispatcher("laptops.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
