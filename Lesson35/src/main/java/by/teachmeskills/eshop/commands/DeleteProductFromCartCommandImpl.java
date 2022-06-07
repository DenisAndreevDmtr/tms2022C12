package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.utils.PagesPathEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;

public class DeleteProductFromCartCommandImpl implements BaseCommand {
    private final static Logger log = LoggerFactory.getLogger(DeleteProductFromCartCommandImpl.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Object objCart = session.getAttribute(SHOPPING_CART.getValue());
        Cart cart = Cart. checkCartExistsOrCreate(objCart);
        cart.removeProduct(productId);
        session.setAttribute(SHOPPING_CART.getValue(), cart);
        User loggedInUser = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        log.info("user with id " + loggedInUser.getId() + " deleted from shopping cart product with id " + productId);
        return PagesPathEnum.CART_PAGE.getPath();
    }
}