package by.tms.instrument.service;

import by.tms.instrument.module.Instrument;
import by.tms.instrument.module.Instrument.Type;
import by.tms.instrument.utils.CreatorIntsruments;

import java.util.Random;

public class MainInstrument {
    public static void main(String[] args) {
        Instrument[] mas = new Instrument[15];
        Type[] instruments = Type.values();
        Random random = new Random();
        for (int i = 0; i < mas.length; i++) {
            mas[i] = CreatorIntsruments.createInstrument(instruments[random.nextInt(3)], i + 1);
            mas[i].play();
        }
    }
}
