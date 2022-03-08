package by.tms.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class Animal implements Serializable {
    private String name;
    private double weight;
}
