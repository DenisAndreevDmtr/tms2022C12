package by.tms.service;

import by.tms.model.Computer;

public class MainComputer {
    public static void main(String[] args) {
        Computer comp1 = new Computer("Intel", "DDR4", "SSD", 2);
        System.out.println(comp1);
        comp1.onComputer();
        //comp1.offComputer();
        System.out.println(comp1);
    }
}

