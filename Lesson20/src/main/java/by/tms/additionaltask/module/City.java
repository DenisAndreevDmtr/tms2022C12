package by.tms.additionaltask.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class City {
    private long idCity;
    private String name;

    public City(String name) {
        this.name = name;
    }
}
