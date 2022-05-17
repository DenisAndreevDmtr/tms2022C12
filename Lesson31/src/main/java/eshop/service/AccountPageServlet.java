package eshop.service;

import eshop.model.Order;
import eshop.model.OrderStorage;

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

@WebServlet("/accountpage")
public class AccountPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("userlogin", session.getAttribute("userlogin"));
        req.setAttribute("userpassword", session.getAttribute("userpassword"));
        req.setAttribute("username", session.getAttribute("username"));
        req.setAttribute("usersurname", session.getAttribute("usersurname"));
        req.setAttribute("userdateborn", session.getAttribute("userdateborn"));
        req.setAttribute("useremail", session.getAttribute("useremail"));
        int idUser = (Integer) session.getAttribute("userid");
        List<Order> orderStorage = OrderStorage.getOrderStorage();
        List<Order> orders = orderStorage.stream().filter(x -> x.getIdUser() == idUser).collect(Collectors.toList());
        req.setAttribute("orders", orders);
        RequestDispatcher rd = req.getRequestDispatcher("accountpage.jsp");
        rd.forward(req, resp);
    }
}
