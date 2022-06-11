package by.teachmeskills.eshop.service;

import by.teachmeskills.eshop.model.Order;
import by.teachmeskills.eshop.model.OrderStorage;
import by.teachmeskills.eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/profile")
public class UserProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        System.out.println(loggedInUser.getLogin());
        req.setAttribute("loggedInUser", loggedInUser);
        int idUser = loggedInUser.getIdUser();
        List<Order> orderStorage = OrderStorage.getOrderStorage();
        List<Order> orders = orderStorage.stream().filter(x -> x.getIdUser() == idUser).collect(Collectors.toList());
        System.out.println(orders.size());
        req.setAttribute("orders", orders);
        RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
        rd.forward(req, resp);
    }
}
