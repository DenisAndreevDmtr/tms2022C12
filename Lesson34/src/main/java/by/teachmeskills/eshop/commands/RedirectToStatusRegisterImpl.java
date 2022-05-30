package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.model.User;
import by.teachmeskills.eshop.utils.RequestParamsEnum;
import by.teachmeskills.eshop.utils.UserStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static by.teachmeskills.eshop.utils.PagesPathEnum.STATUS_FAIL_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.STATUS_REGISTER_PAGE;


public class RedirectToStatusRegisterImpl implements BaseCommand {

    private final static Logger log = LoggerFactory.getLogger(RedirectToStatusRegisterImpl.class);

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
        if ((!UserStorage.сheckUserExist(login)) && (!(login.equalsIgnoreCase("admin")))) {
            User registeredUser = new User(login, password, confirmPassword, name, surname, date, email);
            List<User> users = UserStorage.getUsers();
            users.add(registeredUser);
            UserStorage.setUsers(users);
            request.setAttribute(RequestParamsEnum.LOGIN.getValue(), login);
            log.info("user with login " + registeredUser.getLogin() + " and password " + registeredUser.getPassword() + " registered. New user id is " + registeredUser.getIdUser());
            return STATUS_REGISTER_PAGE.getPath();
        } else {
            log.warn("user tried login " + login + " and failed. Such user has already exist");
            return STATUS_FAIL_PAGE.getPath();
        }
    }
}
