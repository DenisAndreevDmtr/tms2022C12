package by.tms.servise;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet("/flight")
public class Example extends HttpServlet {
    private final static List<String> TIME_INTERVAL = Arrays.asList("00:00", "00:30", "01:00", "01:30", "02:00", "02:30");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("times", TIME_INTERVAL);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/flight.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDate = req.getParameter("start_date");
        String endDate = req.getParameter("end_date");
        if (Optional.ofNullable(startDate).isPresent() && Optional.ofNullable(endDate).isPresent()) {
            try {
                req.setCharacterEncoding("cp866");
                Date start_Date = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
                Date end_Date = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
                req.setAttribute("start_date", start_Date);
                req.setAttribute("end_date", end_Date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            req.getRequestDispatcher("/date.jsp").forward(req, resp);
        }
    }
}


