package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;

public class RedirectToRegisterImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return PagesPathEnum.REGISTER_PAGE.getPath();
    }
}