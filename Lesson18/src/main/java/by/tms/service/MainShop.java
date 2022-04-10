package by.tms.service;

import by.tms.utils.Customer;
import by.tms.utils.LeastQueueCashBoxStrategy;
import by.tms.utils.RandomCashBoxStrategy;
import by.tms.utils.Shop;

import java.util.Random;


public class MainShop {
    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop(3);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Customer b = new Customer(shop, "Customer" + i, new String[]{"Вода", "Колбаса"},
                    random.nextInt(2) == 0 ? new LeastQueueCashBoxStrategy() : new RandomCashBoxStrategy());
            b.start();
            Thread.sleep(100);
        }

    }
}


