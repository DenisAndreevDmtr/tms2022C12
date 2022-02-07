package com.tms.task2;

public class FuelTank {
    private final int MAX_VOLUME = 70;
    public final int VOLUME_PER_RUN = 20;

    private String type;
    private int volume;

    public FuelTank(String type, int volume) throws Exception {
        if (volume > MAX_VOLUME) {
            throw new Exception();
        }
        this.type = type;
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean checkFuel() {
        if (volume >= Math.abs(VOLUME_PER_RUN)) {
            return true;
        } else {
            return false;
        }
    }

    public void printFuelLeft() {
        System.out.println(volume);
    }

    public int reduceFuel(int change) {
        volume = volume - change;
        return volume;
    }

    public int increaseFuel(int change) {
        volume = volume + change;
        return volume;
    }
}