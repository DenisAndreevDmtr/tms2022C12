package by.tms.eshop.service;


import by.tms.eshop.model.Fridge;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

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
}
