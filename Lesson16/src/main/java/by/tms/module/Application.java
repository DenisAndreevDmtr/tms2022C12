package by.tms.module;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
public class Application {

    public Supermarket supermarket;

    public Application(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    public void buyProductsInSupermarket() {
        Scanner sc = new Scanner(System.in);
        int l;
        do {
            System.out.println("Выбереите следующую операцию: \n" +
                    "1. Добавить продукт\n" +
                    "2. Удалить продукт\n" +
                    "3. Редактировать товар\n" +
                    "4. Показать все продукты\n" +
                    "0. Выйти из приложения\n"
            );
            do {
                System.out.println("Введите число от 0 до 4 в соответствии с запросом выше");
                while (!sc.hasNextInt()) {
                    System.out.println("Введите число от 0 до 4 в соответствии с запросом выше");
                    sc.next();
                }
                l = sc.nextInt();
            } while (l > 4 || l < 0);
            switch (l) {
                case (1):
                    Product product = createProduct();
                    supermarket.addProduct(product);
                    break;
                case (2):
                    long id;
                    do {
                        System.out.println("Введите id продукта, который требуется удалить");
                        while (!sc.hasNextLong()) {
                            System.out.println("Неверный формат id");
                            sc.next();
                        }
                        id = sc.nextLong();
                    }
                    while (id <= 0);
                    supermarket.removeProduct(id);
                    break;
                case (3):
                    Product product1 = createProduct();
                    supermarket.redactListWithProduct(product1);
                    break;
                case (4):
                    chooseVariantsOfSorts();
                    break;
                default:
                    System.out.println("Ошибка!");


            }

        } while (l != 0);
        System.out.println("Выход и приложения, удачного дня!");
    }

    private Product createProduct() {
        long id = 0;
        String name = null;
        int price = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ввести и 3 параметра последовательно:id(целочисленное число), название продукта(строка), цена(целочисленное число)");
            while (!sc.hasNextLong()) {
                System.out.println("Введен неправильный формат id");
                sc.next();
            }
            id = sc.nextLong();
            while (!sc.hasNext()) {
                System.out.println("Введен неправильный формат названия");
                sc.next();
            }
            name = sc.next();
            while (!sc.hasNextInt()) {
                System.out.println("Введен неправильный формат цены");
                sc.next();
            }
            price = sc.nextInt();

            System.out.println(id + " " + name + " " + price);
        } while (id == 0 || name == null || price == 0);
        Product product = new Product(id, name, price);
        return product;
    }

    private void chooseVariantsOfSorts() {
        Scanner sc = new Scanner(System.in);
        int l;
        do {
            System.out.println("Выбереите следующий вариант просмотра: \n" +
                    "1. По возрастанию цены\n" +
                    "2. По убыванию цены\n" +
                    "3. По добавлению (последние добавленные отражаются в начале списка\n"

            );
            do {
                System.out.println("Введите число от 1 до 3 в соответствии с запросом выше");
                while (!sc.hasNextInt()) {
                    System.out.println("Введите число от 1 до 3 в соответствии с запросом выше");
                    sc.next();
                }
                l = sc.nextInt();
            } while (l > 3 || l < 0);
            switch (l) {
                case 1:
                    supermarket.sortListPriceAscending();
                    System.out.println(supermarket.getProducts());
                    break;
                case 2:
                    supermarket.sortListPriceDescending();
                    System.out.println(supermarket.getProducts());
                    break;
                case 3:
                    supermarket.sortListInOrderLastInFirstOut();
                    System.out.println(supermarket.getProducts());
                    break;
                default:
                    System.out.println("Ошибка!");
            }
        } while (l > 3 || l < 1);
    }
}
