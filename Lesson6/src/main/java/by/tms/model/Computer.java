package by.tms.model;

import java.util.Random;
import java.util.Scanner;

public class Computer {
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
        this.status = 0;
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
        if (this.status == 0) {
            Random random = new Random();
            int r = 0;
            int s = Integer.MIN_VALUE;
            do {
                System.out.println("Внимание! Введите 0 или 1");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    s = sc.nextInt();
                }
            } while (s != 0 && s != 1);
            r = random.nextInt(2);
            if (r == s && resourceFullCycles > 0) {
                status = 1;
            } else {
                status = 2;
            }

        }
        checkStatus();
    }

    public void offComputer() {
        if (status == 1 && resourceFullCycles > 0) {
            resourceFullCycles = resourceFullCycles - 1;
            status = 0;
            System.out.println("Ресурс цикла уменьшился на 1 единицу");
        }
        checkStatus();
    }

    private void checkStatus() {
        switch (status) {
            case 0:
                System.out.println("Компьютер выключен");
                break;
            case 1:
                System.out.println("Компьютер включен");
                break;
            case 2:
                System.out.println("Компьютер сгорел");
                break;
            default:
                break;
        }

    }

}
