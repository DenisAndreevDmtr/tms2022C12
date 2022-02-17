package by.tms.space.module;

public class SpaceX implements IStart {
    @Override
    public boolean prestartСheck() {
        return true;
    }

    @Override
    public void startEngine() {
        System.out.println("Запускаем SpaceX. Двигатели запущены");
    }

    @Override
    public void start() {
        System.out.println("Поехали");

    }
}
