package by.tms.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

@Getter
@Setter
@AllArgsConstructor
public class Supermarket {
    private ArrayList<Product> products;

    public Supermarket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        boolean flag = true;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == product.getId()) {
                flag = false;
            }
        }
//        if (!products.contains(product)) {
//            products.add(product);
//        }
        if (flag) {
            products.add(product);
        }
    }

    public void removeProduct(Long id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
            }
        }
    }

    public void redactListWithProduct(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                p.setId(product.getId());
                p.setPrice(product.getPrice());
                p.setName(product.getName());
            }
        }
    }

    public void sortListPriceAscending() {
        products.sort(ascendingComporator());
    }

    public void sortListPriceDescending() {
        products.sort(ascendingComporator().reversed());
    }

    public void sortListInOrderLastInFirstOut() {
        products.sort(lifo());
    }

    private Comparator<Product> ascendingComporator() {
        return new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Long.compare(o1.getPrice(), o2.getPrice());
            }
        };
    }

    private Comparator<Product> lifo() {
        return new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getOrderCreatinon(), o2.getOrderCreatinon());
            }
        };
    }

}