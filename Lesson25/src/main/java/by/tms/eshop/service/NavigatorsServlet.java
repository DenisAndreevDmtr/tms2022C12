package by.tms.eshop.service;


import by.tms.eshop.model.Navigator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebServlet("/navigators")
public class NavigatorsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Navigator> navigators = new ArrayList<>();
        Navigator navigator1 = new Navigator("Navitel", "navigator1.jpg", "Good navigator", new BigDecimal(300));
        Navigator navigator2 = new Navigator("Prestigio", "navigator2.jpg", "Very good navigator", new BigDecimal(450));
        navigators.add(navigator1);
        navigators.add(navigator2);
        req.setAttribute("navigators", navigators);
        RequestDispatcher rd = req.getRequestDispatcher("navigators.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
