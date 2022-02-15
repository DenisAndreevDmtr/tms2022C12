package by.tms.space.service;

import by.tms.space.module.Shuttle;
import by.tms.space.module.SpacePort;
import by.tms.space.module.SpaceX;

public class MainSpace {
    public static void main(String[] args) {
        SpacePort spacePort = new SpacePort();
        Shuttle shuttle = new Shuttle();
        spacePort.start(shuttle);
        SpaceX spaceX = new SpaceX();
        spacePort.start(spaceX);

    }
}
