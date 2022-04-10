package by.tms.robot.model;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    public final int OFF = 0;
    public final int ON = 1;
    public final int BURN = 2;

    private String cpu;
    private String ram;
    private String hdd;
    private int resourceFullCycles;
    // 0 означает, что компьютор выключен.
    // 1 означает, что компьютор включен.
    // 2 означает, что компьютор сгорел.
    private int status;

    // по умолчанию ставим, что компьютер выключен
    public Computer() {
        this.status = OFF;
    }

    public Computer(String cpu, String ram, String hdd, int resourceFullCycles) {
        this();
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.resourceFullCycles = resourceFullCycles;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public int getResourceFullCycles() {
        return resourceFullCycles;
    }

    public void setResourceFullCycles(int resourceFullCycles) {
        this.resourceFullCycles = resourceFullCycles;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", resourceFullCycles=" + resourceFullCycles +
                ", status=" + status +
                '}';
    }

    public void onComputer() {
        if (this.status == OFF) {
            Random random = new Random();
            int randomNumber = 0;
            int scanerNumber = Integer.MIN_VALUE;
            do {
                System.out.println("Внимание! Введите 0 или 1");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    scanerNumber = sc.nextInt();
                }
            } while (scanerNumber != 0 && scanerNumber != 1);
            randomNumber = random.nextInt(2);
            if (randomNumber == scanerNumber && resourceFullCycles > 0) {
                status = ON;
            } else {
                status = BURN;
            }

        }
        checkStatus();
    }

    public void offComputer() {
        if (status == ON && resourceFullCycles > 0) {
            resourceFullCycles = resourceFullCycles - 1;
            status = OFF;
            System.out.println("Ресурс цикла уменьшился на 1 единицу");
        }
        checkStatus();
    }

    private void checkStatus() {
        switch (status) {
            case OFF:
                System.out.println("Компьютер выключен");
                break;
            case ON:
                System.out.println("Компьютер включен");
                break;
            case BURN:
                System.out.println("Компьютер сгорел");
                break;
            default:
                break;
        }

    }

}
