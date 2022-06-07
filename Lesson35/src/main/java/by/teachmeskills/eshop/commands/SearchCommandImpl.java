package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.eshop.utils.PagesPathEnum;
import by.teachmeskills.eshop.utils.RequestParamsEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static by.teachmeskills.eshop.utils.RequestParamsEnum.SEARCH_RESULT;

public class SearchCommandImpl implements BaseCommand {
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Product> requestProducts = new ArrayList<>();
        String searchParametr = request.getParameter(RequestParamsEnum.SEARCH_PARAMETR.getValue());
        if (Optional.ofNullable(searchParametr).isEmpty()) {
            return PagesPathEnum.SEARCH_PRODUCT_PAGE.getPath();
        } else {
            List<Product> productListResult = productRepository.getListProductsByNameOrDesc(searchParametr);
            requestProducts.addAll(productListResult.stream().filter(x -> x.getName().contains(searchParametr)).collect(Collectors.toList()));
            requestProducts.addAll(productListResult.stream().filter(x -> !x.getName().contains(searchParametr)).collect(Collectors.toList()));
        }
        request.setAttribute(SEARCH_RESULT.getValue(), requestProducts);
        return PagesPathEnum.SEARCH_PRODUCT_PAGE.getPath();
    }
}