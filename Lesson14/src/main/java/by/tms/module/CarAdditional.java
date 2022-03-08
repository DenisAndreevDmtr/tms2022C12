package by.tms.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarAdditional {

    private static final File FILE = new File("C://Users//User//IdeaProjects//tms2022C12//Lesson14//src//main//resources//scratch.json");
    @JsonProperty("brand_name")
    private String brand;
    @JsonProperty("max_speed")
    private int maxSpeed;
    private int price;

    @Override
    public String toString() {
        return "Это автомобиль " +
                "марки " + brand + ". " +
                "Максимальная скорость составляет " + maxSpeed + " км/ч. " +
                "Цена " + price + " $.";
    }

    public static void readAndWriteFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CarAdditional car = mapper.readValue(FILE, CarAdditional.class);
            System.out.println(car.toString());


        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}


