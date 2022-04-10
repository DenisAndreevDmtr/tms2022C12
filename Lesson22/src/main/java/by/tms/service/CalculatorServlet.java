package by.tms.service;

import by.tms.module.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       resp.setContentType("text/html");
//       String varTextA="Hello World!";
//       req.setAttribute("textA", varTextA);
//        String varTextB="My first jsp page";
//        req.setAttribute("textB", varTextB);
//        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/index.jsp");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/calculator.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double number1 = Double.valueOf(req.getParameter("number1"));
        double number2 = Double.valueOf(req.getParameter("number2"));
        double result = 0;
        String operation = "";
        if (req.getParameter("sum") != null) {
            result = Calculator.sum(number1, number2);
            operation = "sum";
        } else if (req.getParameter("difference") != null) {
            result = Calculator.difference(number1, number2);
            operation = "difference";
        } else if (req.getParameter("multiply") != null) {
            result = Calculator.multiply(number1, number2);
            operation = "multiply";
        } else if (req.getParameter("divide") != null) {
            result = Calculator.divide(number1, number2);
            operation = "divide";
        }
        req.setAttribute("operation", operation);
        req.setAttribute("result", result);
        req.getRequestDispatcher("/calculator.jsp").forward(req, resp);

    }

}

