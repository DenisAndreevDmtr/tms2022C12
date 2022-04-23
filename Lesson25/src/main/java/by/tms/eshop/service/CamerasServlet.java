package by.tms.eshop.service;

import by.tms.eshop.model.Camera;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebServlet("/cameras")
public class CamerasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Camera> cameras = new ArrayList<>();
        Camera camera1 = new Camera("Canon", "camera1.jpg", "Good camera", new BigDecimal(200));
        Camera camera2 = new Camera("Nikon", "camera2.jpg", "Very good camera", new BigDecimal(250));
        cameras.add(camera1);
        cameras.add(camera2);
        req.setAttribute("cameras", cameras);
        RequestDispatcher rd = req.getRequestDispatcher("cameras.jsp");
        rd.forward(req, resp);
    }
}
