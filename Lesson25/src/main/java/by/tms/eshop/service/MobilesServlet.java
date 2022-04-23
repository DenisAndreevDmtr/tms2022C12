package by.tms.eshop.service;


import by.tms.eshop.model.Mobile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

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
}
