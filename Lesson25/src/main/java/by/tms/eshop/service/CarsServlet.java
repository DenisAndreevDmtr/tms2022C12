package by.tms.eshop.service;


import by.tms.eshop.model.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Car> cars = new ArrayList<>();
        Car car1 = new Car("BMW", "car1.jpg", "Good car", new BigDecimal(2300));
        Car car2 = new Car("Nissan", "car2.jpg", "Very good car", new BigDecimal(2450));
        cars.add(car1);
        cars.add(car2);
        req.setAttribute("cars", cars);
        RequestDispatcher rd = req.getRequestDispatcher("cars.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
