package by.tms.modele;

import lombok.Getter;

@Getter
public class FreightTransport extends GroundTransport {
    private int carryingCapacity;

    public FreightTransport(int volume, int maxSpeed, int weight, String mark, int numberOfWheels, int fuelConsumpion, int carryingCapacity) {
        super(volume, maxSpeed, weight, mark, numberOfWheels, fuelConsumpion);
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", carryingCapacity=" + carryingCapacity +
                ", additional info volume in KV =" + volumeHorsePoverToKV();
    }

    @Override
    public double volumeHorsePoverToKV() {
        return super.volumeHorsePoverToKV();
    }

    public String checkCargo(double weigth) {
        if (weigth > carryingCapacity) {
            return "Вам нужен грузовик побольше";
        } else {
            return "Грузовик загружен";
        }
    }

}
