package eshop.utils;

import eshop.commands.AddProductToCartCommandImpl;
import eshop.commands.BaseCommand;
import eshop.commands.CategoryRedirectCommandImpl;
import eshop.commands.DeleteProductFromCartCommandImpl;
import eshop.commands.HomePageCommandImpl;
import eshop.commands.OrderProcessImpl;
import eshop.commands.RedirectProductPageCommandImpl;
import eshop.commands.RedirectToProfileImpl;
import eshop.commands.RedirectToRegisterImpl;
import eshop.commands.RedirectToShoppingCartImpl;
import eshop.commands.RedirectToStatusRegisterImpl;
import eshop.commands.SignInCommandImpl;

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
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        String commandKey = request.getParameter(RequestParamsEnum.COMMAND.getValue());
        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = CommandsEnum.SIGN_IN_COMMAND.getCommand();
        }
        return COMMAND_LIST.get(commandKey);
    }

}

