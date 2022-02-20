package by.tms.instrument.utils;

import by.tms.instrument.module.Drum;
import by.tms.instrument.module.Guitar;
import by.tms.instrument.module.Instrument;
import by.tms.instrument.module.Instrument.Type;
import by.tms.instrument.module.Pipe;

public class CreatorIntsruments {

    public static Instrument createInstrument(Type type, int parametr) {
        Instrument instrument = null;
        switch (type) {
            case DRUM -> {
                Drum drum = new Drum(parametr);
                instrument = drum;
            }
            case PIPE -> {
                Pipe pipe = new Pipe(parametr);
                instrument = pipe;
            }
            case GUITAR -> {
                Guitar guitar = new Guitar(parametr);
                instrument = guitar;
            }
            default -> {
                break;
            }
        }
        return instrument;
    }
}
