package by.tms.service;

import by.tms.module.Application;
import by.tms.module.Supermarket;

public class MainSupermarket {
    public static void main(String[] args) {
//        Product product1 = new Product(1, "Морковь", 30);
//        Product product2 = new Product(2, "Картофель", 20);
//        Product product3 = new Product(3, "Cвекла", 26);
//        Product product4 = new Product(2, "Картофель1", 25);
        Supermarket supermarket = new Supermarket();//       list1.addProduct(product1);
//        list1.addProduct(product2);
//        list1.addProduct(product3);
//        list1.sortListPriceAscending();
//        System.out.println(list1.getProducts());
//        list1.removeProduct(2l);
//        list1.sortListInOrderLastInFirstOut();
//        System.out.println(list1.getProducts());
//        list1.redactListWithProduct(product4);
//        System.out.println(list1.getProducts());
        Application application = new Application(supermarket);
        application.buyProductsInSupermarket();
    }
}
