package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;

public class RedirectToShoppingCartImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute(SHOPPING_CART.getValue());
        if (cart == null) {
            request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), "");
        }
        session.setAttribute(SHOPPING_CART.getValue(), cart);
        return PagesPathEnum.CART_PAGE.getPath();
    }
}
