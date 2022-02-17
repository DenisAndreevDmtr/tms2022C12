package by.tms.clothes.module;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Person {
    private String name;
    private Jacket jacket;
    private Pants pants;
    private Shoes shoes;

    public void actionPutOn() {
        System.out.println(name + " одевается:");
        jacket.putOn();
        pants.putOn();
        shoes.putOn();
    }

    public void actionPutOff() {
        System.out.println(name + " снимает    одежду:");
        jacket.takeOff();
        pants.takeOff();
        shoes.takeOff();
    }

    public int getPrise() {
        int price = jacket.getPrice() + pants.getPrice() + shoes.getPrice();
        return price;
    }


}
