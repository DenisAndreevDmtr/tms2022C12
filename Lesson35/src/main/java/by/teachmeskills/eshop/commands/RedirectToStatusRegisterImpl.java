package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.UserRepository;
import by.teachmeskills.eshop.repositories.impl.UserRepositoryImpl;
import by.teachmeskills.eshop.utils.PagesPathEnum;
import by.teachmeskills.eshop.utils.RequestParamsEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RedirectToStatusRegisterImpl implements BaseCommand {

    private final static Logger log = LoggerFactory.getLogger(RedirectToStatusRegisterImpl.class);
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(RequestParamsEnum.LOGIN.getValue());
        String password = request.getParameter(RequestParamsEnum.PASSWORD.getValue());
        String name = request.getParameter(RequestParamsEnum.NAME.getValue());
        String surname = request.getParameter(RequestParamsEnum.SURNAME.getValue());
        String dateBorn = request.getParameter(RequestParamsEnum.DATE_BORN.getValue());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateBorn, formatter);
        String email = request.getParameter(RequestParamsEnum.EMAIL.getValue());
        request.setAttribute(RequestParamsEnum.LOGIN.getValue(), login);
        if (userRepository.getUserByLogin(login).isEmpty()) {

            User registeredUser = new User(login, password, name, surname, date, email, new BigDecimal(0));
            User savedUser = userRepository.create(registeredUser);
            log.info("user with login " + savedUser.getLogin() + " and password " + savedUser.getPassword() + " registered and saved into db. New user id is " + savedUser.getId());
            return PagesPathEnum.STATUS_REGISTER_PAGE.getPath();
        } else {
            log.warn("user tried login " + login + " and failed. Such user has already exist");
            return PagesPathEnum.STATUS_FAIL_PAGE.getPath();
        }
    }
}
