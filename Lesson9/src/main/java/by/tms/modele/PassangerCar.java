package by.tms.modele;

import lombok.Getter;

@Getter
public class PassangerCar extends GroundTransport {
    private String bodyType;
    private int numberOfPassengers;

    public PassangerCar(int volume, int maxSpeed, int weight, String mark, int numberOfWheels, int fuelConsumpion, String bodyType, int numberOfPassengers) {
        super(volume, maxSpeed, weight, mark, numberOfWheels, fuelConsumpion);
        this.bodyType = bodyType;
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bodyType=" + bodyType +
                ", numberOfPassengers=" + numberOfPassengers +
                ", additional info volume in KV =" + volumeHorsePoverToKV();
    }

    @Override
    public double volumeHorsePoverToKV() {
        return super.volumeHorsePoverToKV();
    }

    public String calculateKilometrsAndFuelCostsAtMaxSpeed(double time) {
        double kilometrs = time * super.getMaxSpeed();
        double fuelCosts = kilometrs * getFuelConsumpion();

        return "За время " + time + " ч, автомобиль " + super.getMark() +
                " двигаясь с максимальной скоростью " + super.getMaxSpeed() + " км/ч  проедет " +
                kilometrs + " км и израсходует " + fuelCosts + " литров топлива.";
    }


}
