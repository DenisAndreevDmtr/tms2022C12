package by.tms.service;

import by.tms.module2.CashBox;
import by.tms.module2.Customer;
import by.tms.module2.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainShop2 {
    public static void main(String[] args) {
        CashBox cashBox1 = new CashBox(1, true);
        CashBox cashBox2 = new CashBox(2, true);
        List<Customer> customers = Arrays.asList(
                new Customer(1, new Product("Молоко")),
                new Customer(2, new Product("Хлеб")),
                new Customer(3, new Product("Cахар")),
                new Customer(4, new Product("Соль")));
        for (int i = 0; i < customers.size(); i++) {
            Random random = new Random();
            switch (random.nextInt(2)) {
                case (0):
                    customers.get(i).setCashBox(cashBox1);
                    cashBox1.setQueueSize(cashBox1.getQueueSize() + 1);
                    break;
                case (1):
                    customers.get(i).setCashBox(cashBox2);
                    cashBox2.setQueueSize(cashBox2.getQueueSize() + 1);
                    break;
                default:
                    break;
            }
        }
        customers.forEach(x -> x.start());
    }
}
