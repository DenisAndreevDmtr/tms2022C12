package by.teachmeskills.eshop.utils;


import by.teachmeskills.eshop.commands.AddProductToCartCommandImpl;
import by.teachmeskills.eshop.commands.BaseCommand;
import by.teachmeskills.eshop.commands.CategoryRedirectCommandImpl;
import by.teachmeskills.eshop.commands.DeleteProductFromCartCommandImpl;
import by.teachmeskills.eshop.commands.HomePageCommandImpl;
import by.teachmeskills.eshop.commands.OrderProcessImpl;
import by.teachmeskills.eshop.commands.RedirectProductPageCommandImpl;
import by.teachmeskills.eshop.commands.RedirectToProfileImpl;
import by.teachmeskills.eshop.commands.RedirectToRegisterImpl;
import by.teachmeskills.eshop.commands.RedirectToShoppingCartImpl;
import by.teachmeskills.eshop.commands.RedirectToStatusRegisterImpl;
import by.teachmeskills.eshop.commands.SearchCommandImpl;
import by.teachmeskills.eshop.commands.SignInCommandImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, BaseCommand> COMMAND_LIST = new HashMap<>();

    static {
        COMMAND_LIST.put(CommandsEnum.HOME_PAGE_COMMAND.getCommand(), new HomePageCommandImpl());
        COMMAND_LIST.put(CommandsEnum.SIGN_IN_COMMAND.getCommand(), new SignInCommandImpl());
        COMMAND_LIST.put(CommandsEnum.CATEGORY_PAGE_COMMAND.getCommand(), new CategoryRedirectCommandImpl());
        COMMAND_LIST.put(CommandsEnum.ADD_PRODUCT_TO_CART.getCommand(), new AddProductToCartCommandImpl());
        COMMAND_LIST.put(CommandsEnum.DELETE_PRODUCT_FROM_CART.getCommand(), new DeleteProductFromCartCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_SHOPPING_CART_COMMAND.getCommand(), new RedirectToShoppingCartImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_PRODUCT_COMMAND.getCommand(), new RedirectProductPageCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REGISTER_COMMAND.getCommand(), new RedirectToRegisterImpl());
        COMMAND_LIST.put(CommandsEnum.STATUS_REGISTER_COMMAND.getCommand(), new RedirectToStatusRegisterImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_PROFILE.getCommand(), new RedirectToProfileImpl());
        COMMAND_LIST.put(CommandsEnum.ORDER_COMMAND.getCommand(), new OrderProcessImpl());
        COMMAND_LIST.put(CommandsEnum.SEARCH_COMMAND.getCommand(), new SearchCommandImpl());
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        String commandKey = request.getParameter(RequestParamsEnum.COMMAND.getValue());
        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = CommandsEnum.SIGN_IN_COMMAND.getCommand();
        }
        return COMMAND_LIST.get(commandKey);
    }

}

