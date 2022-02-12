package by.tms.modele;

import lombok.Getter;

@Getter
public class FlyingTransport extends Transport {
    private int wingspan;
    private int minRunwayLength;

    public FlyingTransport(int volume, int maxSpeed, int weight, String mark, int wingspan, int minRunwayLength) {
        super(volume, maxSpeed, weight, mark);
        this.wingspan = wingspan;
        this.minRunwayLength = minRunwayLength;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", wingspan=" + wingspan +
                ", minRunwayLength=" + minRunwayLength +
                ", additional info volume in KV =" + volumeHorsePoverToKV();
    }

    @Override
    public double volumeHorsePoverToKV() {
        return super.volumeHorsePoverToKV();
    }
}
