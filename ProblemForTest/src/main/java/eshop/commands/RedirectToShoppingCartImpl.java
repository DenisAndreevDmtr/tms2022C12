package eshop.commands;

import eshop.exceptions.CommandException;
import eshop.model.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.utils.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART_SUM;

public class RedirectToShoppingCartImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute(SHOPPING_CART.getValue());
        System.out.println("123");
        if (cart == null) {
            request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), "");
        } else {
            request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getProducts());
            request.setAttribute(SHOPPING_CART_SUM.getValue(), cart.getTotalPrice());
        }
        session.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getProducts());
        return CART_PAGE.getPath();
    }
}
