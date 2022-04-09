package by.tms.additionaltask.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {
    private long id;
    private String name;
    private String surname;
    private int course;
    private int idCity;

    public Student(String name, String surname, int course, int idCity) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.idCity = idCity;
    }
}
