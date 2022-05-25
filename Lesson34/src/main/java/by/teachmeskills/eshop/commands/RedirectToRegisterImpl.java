package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.teachmeskills.eshop.utils.PagesPathEnum.REGISTER_PAGE;


public class RedirectToRegisterImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return REGISTER_PAGE.getPath();

    }
}
