package by.tms.realization;

public class Main {
    public static void main(String[] args) {
        LuxuryCar car = new LuxuryCar(4, 4, 1000);
        car.setCabriolet(false);
        LuxuryCar cloneLuxuryCar = (LuxuryCar) car.copy();
        cloneLuxuryCar.setPrice(1200);
        cloneLuxuryCar.setDoors(2);
        cloneLuxuryCar.setCabriolet(true);
        EconomCar ecar = new EconomCar(4, 2, 300);
        ecar.setLuggageBoot(true);
        EconomCar cloneEcar = (EconomCar) ecar.copy();
        cloneEcar.setPrice(500);
        cloneEcar.setDoors(4);
        cloneEcar.setLuggageBoot(false);
        System.out.println("характеристики экземпляра: " + car.toString());
        System.out.println("характеристики копии: " + cloneLuxuryCar.toString());
        System.out.println("характеристики экземпляра: " + ecar.toString());
        System.out.println("характеристики копии: " + cloneEcar.toString());
    }
}
