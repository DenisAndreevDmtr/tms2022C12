package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.model.Cart;
import by.teachmeskills.eshop.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.utils.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART_SUM;


public class DeleteProductFromCartCommandImpl implements BaseCommand {

    private final static Logger log = LoggerFactory.getLogger(DeleteProductFromCartCommandImpl.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Cart cart;
        Object objCart = session.getAttribute(SHOPPING_CART.getValue());

        if (objCart != null) {
            cart = (Cart) objCart;
        } else {
            cart = new Cart();
        }
        cart.removeProduct(productId);
        session.setAttribute(SHOPPING_CART.getValue(), cart);
        request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getProducts());
        request.setAttribute(SHOPPING_CART_SUM.getValue(), cart.getTotalPrice());
        User loggedInUser = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        log.info("user with id " + loggedInUser.getIdUser() + " deleted from shopping cart product with id " + productId);
        return CART_PAGE.getPath();
    }
}
