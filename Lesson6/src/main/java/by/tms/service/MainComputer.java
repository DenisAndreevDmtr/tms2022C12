package by.tms.service;

import by.tms.model.Computer;

public class MainComputer {
    public static void main(String[] args) {
        Computer comp1 = new Computer("Intel", "DDR4", "SSD", 2);
        int countCycles = comp1.getResourceFullCycles();

        for (int i = 0; i < countCycles; i++) {
            System.out.println(i + " цикл");
            comp1.onComputer();
            comp1.offComputer();
            System.out.println(comp1);
        }
    }
}

