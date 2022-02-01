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
            if (r == s) {
                this.status = 1;
                System.out.println("Компьютер включился");
            } else {
                this.status = 2;
                System.out.println("Компьютер cгорел");
            }

        } else if (status == 1) {
            System.out.println("Компьютер и так уже включен");
        } else {
            System.out.println("Компьютер уже сгорел, нельзя включить");
        }
    }

    public void offComputer() {
        if (this.status == 1 && this.resourceFullCycles > 0) {
            this.resourceFullCycles = this.resourceFullCycles - 1;
            this.status = 0;
            System.out.println("Компьютер выключился, ресурс цикла уменьшился на 1 единицу");
            if (this.resourceFullCycles == 0) {
                System.out.println("Компьютер сгорел");
            }
        } else if (this.status == 2) {
            System.out.println("Компьютер уже сгорел");
        } else {
            System.out.println("Компьютер и так уже выключен");
        }
    }
}
