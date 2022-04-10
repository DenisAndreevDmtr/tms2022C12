package by.tms.robot.modele;

import lombok.Getter;

@Getter
public class MilitaryTransport extends FlyingTransport {
    private boolean bailOutSystem;
    private int numberOfMissiles;

    public MilitaryTransport(int volume, int maxSpeed, int weight, String mark, int wingspan, int minRunwayLength, boolean bailoutSystem, int numberOfMissiles) {
        super(volume, maxSpeed, weight, mark, wingspan, minRunwayLength);
        this.bailOutSystem = bailoutSystem;
        this.numberOfMissiles = numberOfMissiles;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bailoutSystem=" + bailOutSystem +
                ", numberOfMissiles=" + numberOfMissiles +
                ", additional info volume in KV =" + volumeHorsePoverToKV();
    }

    @Override
    public double volumeHorsePoverToKV() {
        return super.volumeHorsePoverToKV();
    }

    public String checkMissiles() {
        if (numberOfMissiles > 0) {
            numberOfMissiles -= 1;
            return "Ракета пошла";
        } else {
            return "Боеприпасы отсутствуют";
        }
    }

    public String checkbailOutSystem() {
        if (bailOutSystem) {
            return "Катапультирование прошло успешно";
        } else {
            return "У вас нет такой системы";
        }
    }


}