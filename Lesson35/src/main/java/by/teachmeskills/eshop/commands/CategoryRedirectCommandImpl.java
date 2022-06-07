package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.eshop.utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORY;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORY_ID;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.NAME_CATEGORY;

public class CategoryRedirectCommandImpl implements BaseCommand {
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int id = Integer.parseInt(request.getParameter(CATEGORY_ID.getValue()));
        List<Product> products = productRepository.getAllProductsByCategoryId(id);
        request.setAttribute(NAME_CATEGORY.getValue(), categoryRepository.getCategoryNameByID(id));
        request.setAttribute(CATEGORY.getValue(), products);
        return PagesPathEnum.CATEGORY_PAGE.getPath();
    }
}