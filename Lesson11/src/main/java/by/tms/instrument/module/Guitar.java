package by.tms.instrument.module;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Guitar implements Instrument {
    private int numberOfStrings;

    @Override
    public void play() {
        System.out.println("Играет гитара с количество струн, равным " + numberOfStrings);
    }
}
