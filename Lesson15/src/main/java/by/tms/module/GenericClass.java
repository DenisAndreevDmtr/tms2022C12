package by.tms.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class GenericClass<T extends Comparable, V extends Animal & Serializable, K extends Number> {
    private T firstParametr;
    private V secondParametr;
    private K thirdParamatr;

    public void getClassOfParametrs() {
        System.out.println("firstParametr " + firstParametr.getClass() + "\n" +
                "secondParametr " + secondParametr.getClass() + "\n" +
                "thirdParametr " + thirdParamatr.getClass() + "\n"
        );
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "firstParametr=" + firstParametr +
                ", secondParametr: " + "nameAnimal=" + secondParametr.getName() + " weightAnimal=" + secondParametr.getWeight() +
                ", thirdParamatr: " + "numberValue=" + thirdParamatr.getValue() + " nameNumber=" + thirdParamatr.getName() +
                '}';
    }
}
