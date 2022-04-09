package by.tms.task1.service;

import by.tms.task1.module.Product;
import by.tms.task1.utils.CRUDUtilsTask1;

public class MainTask1 {
    public static void main(String[] args) {
        System.out.println("Вывод всех продуктов");
        CRUDUtilsTask1.getAllProducts().forEach(System.out::println);
        Product productNew = new Product("hat", "good hat", 15, true);
        System.out.println("Выполнение добавления продукта");
        CRUDUtilsTask1.addProduct(productNew).forEach(System.out::println);
        System.out.println("Выполнение редактирования товара");
        CRUDUtilsTask1.updateProduct(7, 0, false).forEach(System.out::println);
        System.out.println("Выполнение задания удаления");
        CRUDUtilsTask1.deleteProduct(9).forEach(System.out::println);
    }
}
