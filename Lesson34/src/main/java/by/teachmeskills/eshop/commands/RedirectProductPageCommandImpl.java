package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.utils.ProductsStorage;

import javax.servlet.http.HttpServletRequest;

import static by.teachmeskills.eshop.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT_ID;

public class RedirectProductPageCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = ProductsStorage.getProductById(productId);
        request.setAttribute(PRODUCT.getValue(), product);
        return PRODUCT_PAGE.getPath();

    }
}
