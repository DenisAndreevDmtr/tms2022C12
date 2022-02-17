package by.tms.space.module;

public class SpacePort {

    public void start(IStart iStart) {
        if (iStart.prestartСheck()) {
            iStart.startEngine();
            for (int i = 10; i >= 0; i--) {
                System.out.print(i + " ");
            }
            System.out.println();
            iStart.start();
        } else {
            System.out.println("Предстартовая проверка провалена");
        }
    }
}

