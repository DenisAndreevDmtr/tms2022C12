package by.tms.module2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Customer extends Thread {
    private long id;
    private Product product;
    private CashBox cashBox;

    public Customer(long id, Product product) {
        this.id = id;
        this.product = product;
    }

    private synchronized void changeStatusCashBoxIsBusy() {
        cashBox.setReady(false);
    }

    private synchronized void changeStatusCashBoxIsReady() {
        cashBox.setReady(true);
    }

    @Override
    public void run() {
        while (!cashBox.isReady()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
        changeStatusCashBoxIsBusy();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        System.out.println("очередь в кассу " + getCashBox().getNumber() + " занята Customer " + id);
        System.out.println("Customer " + getId() + " приобрел на кассе №" + cashBox.getNumber() + " продукт " + product.getName());

        cashBox.setQueueSize(cashBox.getQueueSize() - 1);
        changeStatusCashBoxIsReady();
        System.out.println("очередь в кассу " + getCashBox().getNumber() + " свободна");
    }
}
