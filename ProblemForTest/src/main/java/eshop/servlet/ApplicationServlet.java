package eshop.servlet;

import eshop.commands.BaseCommand;
import eshop.exceptions.CommandException;
import eshop.utils.CommandFactory;
import eshop.utils.PagesPathEnum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/eshop")
public class ApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BaseCommand requestCommand = CommandFactory.defineCommand(request);
        String path;
        try {
            path = requestCommand.execute(request);
            System.out.println(path);
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        } catch (CommandException e) {
            request.getRequestDispatcher(PagesPathEnum.SIGN_IN_PAGE.getPath()).forward(request, response);
        }
    }
}



