package by.tms.robot.service;

import by.tms.robot.module.*;

public class MainRobot {
    public static void main(String[] args) {
/*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */
        Robot robot1 = new Robot(new SonyHead(2), new SonyHand(3), new SamsungLeg(5));
        Robot robot2 = new Robot(new SamsungHead(10), new SonyHand(5), new ToshibaLeg(8));
        Robot robot3 = new Robot(new ToshibaHead(7), new SamsungHand(8), new SonyLeg(6));
        robot1.action();
        System.out.println(robot1.getPrice());
        System.out.println("________");
        robot2.action();
        System.out.println(robot2.getPrice());
        System.out.println("________");
        robot3.action();
        System.out.println(robot3.getPrice());
        System.out.println("________");
        System.out.println(Robot.robotMaxPrice(robot1, robot2, robot3));
    }

}
