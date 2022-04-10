package by.tms.robot.modele;

import lombok.Getter;

@Getter
public class CivilTransport extends FlyingTransport {
    private int numberOfPassengers;
    private boolean bussinessClass;

    public CivilTransport(int volume, int maxSpeed, int weight, String mark, int wingspan, int minRunwayLength, int numberOfPassengers, boolean bussinessClass) {
        super(volume, maxSpeed, weight, mark, wingspan, minRunwayLength);
        this.numberOfPassengers = numberOfPassengers;
        this.bussinessClass = bussinessClass;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfPassengers=" + numberOfPassengers +
                ", bussinessClass=" + bussinessClass +
                ", additional info volume in KV =" + volumeHorsePoverToKV();
    }

    @Override
    public double volumeHorsePoverToKV() {
        return super.volumeHorsePoverToKV();
    }

    public String checkNumberPassenger(int passengers) {
        if (numberOfPassengers > passengers) {
            return "Самолет загружен";
        } else {
            return "Нужен самолет побольше";
        }
    }
}
