package eshop.commands;

import eshop.exceptions.CommandException;
import eshop.model.Cart;
import eshop.model.Product;
import eshop.utils.ProductsStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.utils.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.SHOPPING_CART_SUM;

public class DeleteProductFromCartCommandImpl implements BaseCommand {

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
        cart.removeProduct(productId);
        session.setAttribute(SHOPPING_CART.getValue(), cart);
//        request.setAttribute(PRODUCT.getValue(), product);
        request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getProducts());
        request.setAttribute(SHOPPING_CART_SUM.getValue(), cart.getTotalPrice());
        return CART_PAGE.getPath();
    }
}
