package by.tms.bussinescard.service;


import by.tms.bussinescard.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/businesscard")
public class BusinessCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person("Denis", "Andreev", 27, "person.jpg", "Java Core, Java EE, MYSQL, Tomcat, Github", "Finance, Economy, Accounting", "Belarusian National Technical University", "Russian - native speaker, English - C1", "andreevdenisdmtr@gmail.com");
        req.setAttribute("person", person);
        RequestDispatcher rd = req.getRequestDispatcher("businesscard.jsp");
        rd.forward(req, resp);
    }
}
