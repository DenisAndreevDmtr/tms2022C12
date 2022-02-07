package com.tms.task2;

public class Engine {
    public static final String ON = "ON";
    public static final String OFF = "OFF";

    private String name;
    private String type;
    private int engineCapacity;
    private String statusEngine;

    public Engine(String name, String type, int engineCapacity, String statusEngine) {
        this.name = name;
        this.type = type;
        this.engineCapacity = engineCapacity;
        this.statusEngine = statusEngine;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public String getStatusEngine() {
        return statusEngine;
    }

    public void changeStatusEngine() {
        if (statusEngine == ON) {
            statusEngine = OFF;
            System.out.println("двигатель выключен");
        } else {
            statusEngine = ON;
            System.out.println("двигатель включен");
        }
    }

    public void stopEngine() {
        statusEngine = OFF;
    }

}
