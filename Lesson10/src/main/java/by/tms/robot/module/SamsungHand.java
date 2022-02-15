package by.tms.robot.module;

public class SamsungHand implements IHand {

    private int price;

    public SamsungHand() {
    }

    public SamsungHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Рука Samsung поднялась");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
