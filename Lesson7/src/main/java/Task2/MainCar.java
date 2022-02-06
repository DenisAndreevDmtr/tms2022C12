package Task2;

public class MainCar {
    public static void main(String[] args) {
        try {
            FuelTank myFuelTank = new FuelTank("бензиновый", 60);
            Engine myEngine = new Engine("Hyundai123", "бензиновый", 25000, "OFF");

            Car myCar = new Car(myEngine, myFuelTank, 18000, "Hyundai", 2018);

            System.out.println("исходные параметры авто");
            System.out.println(myCar.toString());
            System.out.println("начинаем работу с авто");

            while (myFuelTank.checkFuel()) {
                myCar.changeCarStatus();
                System.out.println(myCar.toString());
            }
            System.out.println("нехватка топлива, необходима заправка");
            System.out.println("заправляемся");
            myFuelTank.changeFuel(25);
            System.out.println(myCar.toString());

        } catch (Exception e) {
            System.out.println("Invalid value");
        }
    }
}
