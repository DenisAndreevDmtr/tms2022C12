package by.tms.modele;

import by.tms.utils.Constants;
import lombok.Getter;

@Getter
public class Transport {
    private int volume;
    private int maxSpeed;
    private int weight;
    private String mark;

    public Transport(int volume, int maxSpeed, int weight, String mark) {
        this.volume = volume;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mark = mark;
    }

    public double volumeHorsePoverToKV() {
        double kiloVat = volume * Constants.VOLUME_KV;
        return kiloVat;
    }

    @Override
    public String toString() {
        return "Transport:" +
                "volume=" + volume +
                ", maxSpeed=" + maxSpeed +
                ", weight=" + weight +
                ", mark='" + mark + '\''
                ;
    }


    public String getMark() {
        return mark;
    }
}
