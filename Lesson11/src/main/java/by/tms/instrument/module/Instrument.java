package by.tms.instrument.module;

public interface Instrument {
    void play();

    final String KEY = "До Мажор";

    public enum Type {
        GUITAR, DRUM, PIPE;
    }
}
