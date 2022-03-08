package by.tms.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MinMax<T extends Comparable> {
    private T[] values;

    public void getInformationAboutObject() {
        T maxValue = values[0];
        T minValue = values[0];
        for (int i = 0; i < values.length; i++) {
            maxValue = max(maxValue, values[i]);
            minValue = min(minValue, values[i]);
            System.out.println(values[i] + " ");
        }
        System.out.println("Максимальный элемент иммет значение " + maxValue);
        System.out.println("Минимальный элемент иммет значение " + minValue);
    }

    private T max(T a, T b) {
        if (a.compareTo(b) < 0) {
            return b;
        } else {
            return a;
        }
    }

    private T min(T a, T b) {
        if (a.compareTo(b) > 0) {
            return b;
        } else {
            return a;
        }
    }
}
