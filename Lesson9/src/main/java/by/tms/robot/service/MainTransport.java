package by.tms.robot.service;

import by.tms.robot.modele.CivilTransport;
import by.tms.robot.modele.FreightTransport;
import by.tms.robot.modele.MilitaryTransport;
import by.tms.robot.modele.PassangerCar;

public class MainTransport {
    public static void main(String[] args) {
        PassangerCar car = new PassangerCar(150, 220, 390, "Audi", 4, 50, "Cедан", 4);
        System.out.println(car);
        System.out.println(car.calculateKilometrsAndFuelCostsAtMaxSpeed(5.2));
        FreightTransport van = new FreightTransport(400, 120, 2000, "Ford", 4, 90, 400);
        System.out.println(van.checkCargo(350));
        CivilTransport airplane = new CivilTransport(3000, 800, 2300, "Air2", 15, 40, 8, true);
        System.out.println(airplane.checkNumberPassenger(4));
        MilitaryTransport militaryplane = new MilitaryTransport(5000, 3000, 4000, "Истрибитель", 18, 60, false, 4);
        System.out.println(militaryplane.checkMissiles());
        System.out.println(militaryplane.checkbailOutSystem());
    }
}
