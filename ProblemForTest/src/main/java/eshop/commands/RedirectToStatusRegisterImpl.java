package eshop.commands;

import eshop.exceptions.CommandException;
import eshop.model.User;
import eshop.utils.RequestParamsEnum;
import eshop.utils.UserStorage;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static by.teachmeskills.eshop.utils.PagesPathEnum.STATUS_REGISTER_PAGE;

public class RedirectToStatusRegisterImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(RequestParamsEnum.LOGIN.getValue());
        String password = request.getParameter(RequestParamsEnum.PASSWORD.getValue());
        String confirmPassword = request.getParameter(RequestParamsEnum.CONFIRM_PASSWORD.getValue());
        String name = request.getParameter(RequestParamsEnum.NAME.getValue());
        String surname = request.getParameter(RequestParamsEnum.SURNAME.getValue());
        String dateBorn = request.getParameter(RequestParamsEnum.DATE_BORN.getValue());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateBorn, formatter);
        String email = request.getParameter(RequestParamsEnum.EMAIL.getValue());
        if (!UserStorage.сheckUserExist(login)) {
            User registeredUser = new User(login, password, confirmPassword, name, surname, date, email);
            List<User> users = UserStorage.getUsers();
            users.add(registeredUser);
            UserStorage.setUsers(users);
            request.setAttribute(RequestParamsEnum.LOGIN.getValue(), login);
        }
        return STATUS_REGISTER_PAGE.getPath();
    }
}
