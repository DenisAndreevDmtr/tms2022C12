package by.tms.instrument.module;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pipe implements Instrument {
    private int diametr;

    @Override
    public void play() {
        System.out.println("Играет труба диметром " + diametr);
    }
}
