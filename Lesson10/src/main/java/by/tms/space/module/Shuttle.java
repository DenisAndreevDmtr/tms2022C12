package by.tms.space.module;

import java.util.Random;

public class Shuttle implements IStart {
    @Override
    public boolean prestartСheck() {
        Random random = new Random();
        int r = random.nextInt(11);
        if (r > 3) {
            return true;
        }
        return false;
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатели Шатла запущены");
        System.out.println("Все системы в норме");

    }

    @Override
    public void start() {
        System.out.println("Старт шатла");
    }
}
