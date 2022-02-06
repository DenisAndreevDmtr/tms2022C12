package Task2;

public class Car {

    private final String ON = "ON";
    private final String OFF = "OFF";
    private final int FIX_DISTANSE = 25;


    private Engine engine;
    private FuelTank fuelTank;
    private int distance;
    private String mark;
    private int year;

    public Car(Engine engine, FuelTank fuelTank) {
        this.engine = engine;
        this.fuelTank = fuelTank;
    }

    public Car(Engine engine, FuelTank fuelTank, int distance, String mark, int year) {
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.distance = distance;
        this.mark = mark;
        this.year = year;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "Car{" +
                "engine:" + "name= " + engine.getName() + " type= " + engine.getType() + " capacity= " + engine.getEngineCapacity() + " status engine= " + engine.getStatusEngine() +
                ", fuelTank:" + " type= " + fuelTank.getType() + " volume= " + fuelTank.getVolume() +
                ", distance=" + distance +
                ", mark='" + mark + '\'' +
                ", year=" + year +
                '}';
    }


    public void changeCarStatus() {
        if (engine.getStatusEngine() == OFF && fuelTank.checkFuel()) {
            engine.changeStatusEngine();
            System.out.println("Машина поехала");
        } else if (engine.getStatusEngine() == ON) {
            changeDistance();
            fuelTank.changeFuel(fuelTank.VOLUME_PER_RUN);
            engine.changeStatusEngine();
            System.out.println("Машина остановлена двигатель заглушен");
            System.out.println("проехано " + distance);
        } else if (!fuelTank.checkFuel()) {
            engine.stopEngine();
            System.out.println("двигатель не может быть запущен из-за отсутсвия топлива");
        }
    }

    public void changeDistance() {
        distance = distance + FIX_DISTANSE;
    }


}
