package by.teachmeskills.eshop.repositories;


import by.teachmeskills.eshop.entities.Product;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product> {
    List<Product> getAllProducts();

    List<Product> getAllProductsByIdCategory(int id);

    Product getProductById(int id);

    List<Product> getListProductsbyRequest(String request);
}
