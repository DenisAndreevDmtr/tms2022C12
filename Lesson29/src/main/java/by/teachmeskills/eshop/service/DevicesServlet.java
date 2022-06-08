package by.teachmeskills.eshop.service;


import by.teachmeskills.eshop.model.CategoriesStorage;
import by.teachmeskills.eshop.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/devices")
public class DevicesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("categories", session.getAttribute("categories"));
        RequestDispatcher rd = req.getRequestDispatcher("devices.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Category> categories = CategoriesStorage.getCategories();
        HttpSession session = req.getSession();
        session.setAttribute("categories", categories);
        req.setAttribute("categories", categories);
        req.setAttribute("id", id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("category.jsp");
        requestDispatcher.forward(req, resp);
    }
}
