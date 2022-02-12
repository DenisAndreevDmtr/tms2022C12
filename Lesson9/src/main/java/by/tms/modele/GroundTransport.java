package by.tms.modele;

import lombok.Getter;

@Getter
public class GroundTransport extends Transport {
    private int numberOfWheels;
    private int fuelConsumpion;

    public GroundTransport(int volume, int maxSpeed, int weight, String mark, int numberOfWheels, int fuelConsumpion) {
        super(volume, maxSpeed, weight, mark);
        this.numberOfWheels = numberOfWheels;
        this.fuelConsumpion = fuelConsumpion;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfWheels=" + numberOfWheels +
                ", fuelConsumpion=" + fuelConsumpion;
    }
}

