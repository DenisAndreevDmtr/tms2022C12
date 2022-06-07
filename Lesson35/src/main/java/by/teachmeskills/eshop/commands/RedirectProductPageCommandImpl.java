package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.eshop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;

import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.PRODUCT_ID;

public class RedirectProductPageCommandImpl implements BaseCommand {
    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = productRepository.getProductById(productId);
        request.setAttribute(PRODUCT.getValue(), product);
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}