package by.tms.instrument.module;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Drum implements Instrument {
    private int size;

    @Override
    public void play() {
        System.out.println("Играет барабан размером " + size);
    }
}
