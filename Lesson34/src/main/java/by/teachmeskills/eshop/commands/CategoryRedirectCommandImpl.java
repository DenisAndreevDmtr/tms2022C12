package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.utils.CategoriesStorage;
import by.teachmeskills.eshop.utils.PagesPathEnum;
import by.teachmeskills.eshop.utils.ProductsStorage;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORY;
import static by.teachmeskills.eshop.utils.RequestParamsEnum.CATEGORY_ID;

public class CategoryRedirectCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int id = Integer.parseInt(request.getParameter(CATEGORY_ID.getValue()));
        List<Product> products = ProductsStorage.getProducts().stream().filter(x -> x.getIdCategory() == id).collect(Collectors.toList());
        request.setAttribute("namecategory", CategoriesStorage.getCategoryNameById(id));
        request.setAttribute(CATEGORY.getValue(), products);
        return PagesPathEnum.CATEGORY_PAGE.getPath();
    }
}
