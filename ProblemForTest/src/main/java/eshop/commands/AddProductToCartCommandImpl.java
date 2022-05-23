package eshop.commands;

import eshop.exceptions.CommandException;
import eshop.model.Cart;
import eshop.model.Product;
import eshop.utils.ProductsStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;

public class AddProductToCartCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = ProductsStorage.getProductById(productId);

        Cart cart;
        Object objCart = session.getAttribute(SHOPPING_CART.getValue());

        if (objCart != null) {
            cart = (Cart) objCart;
        } else {
            cart = new Cart();
//            session.setAttribute(SHOPPING_CART.getValue(), cart);
        }
        cart.addProduct(product);
        session.setAttribute(SHOPPING_CART.getValue(), cart);
        request.setAttribute(PRODUCT.getValue(), product);

        return PRODUCT_PAGE.getPath();
    }
}
