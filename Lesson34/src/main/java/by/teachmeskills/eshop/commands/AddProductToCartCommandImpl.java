package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.model.Cart;
import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.model.User;
import by.teachmeskills.eshop.utils.ProductsStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.LOGGED_IN_USER;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;


public class AddProductToCartCommandImpl implements BaseCommand {

    private final static Logger log = LoggerFactory.getLogger(AddProductToCartCommandImpl.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = ProductsStorage.getProductById(productId);
        Object objCart = session.getAttribute(SHOPPING_CART.getValue());
        Cart cart = Cart.createCart(objCart);
        cart.addProduct(product);
        session.setAttribute(SHOPPING_CART.getValue(), cart);
        request.setAttribute(PRODUCT.getValue(), product);
        User loggedInUser = (User) session.getAttribute(LOGGED_IN_USER.getValue());
        log.info("user with id " + loggedInUser.getIdUser() + " added to shopping cart product with id " + productId);
        return PRODUCT_PAGE.getPath();
    }
}
