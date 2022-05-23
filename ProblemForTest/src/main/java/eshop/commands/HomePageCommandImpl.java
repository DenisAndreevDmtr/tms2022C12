package eshop.commands;

import eshop.exceptions.CommandException;
import eshop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;

public class HomePageCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return PagesPathEnum.HOME_PAGE.getPath();
    }
}

