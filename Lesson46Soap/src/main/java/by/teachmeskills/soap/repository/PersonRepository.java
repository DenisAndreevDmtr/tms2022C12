package by.teachmeskills.soap.repository;

import by.teachmeskills.soap.model.Person;
import by.teachmeskills.soap.model.Sex;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonRepository {
    private static final List<Person> persons = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Person director = new Person();
        director.setId(1);
        director.setName("Ivan");
        director.setSurname("Ivanov");
        director.setAge(40);
        director.setSex(Sex.MALE);
        persons.add(director);

        Person manager = new Person();
        director.setId(2);
        director.setName("Petr");
        director.setSurname("Petrov");
        director.setAge(30);
        director.setSex(Sex.MALE);
        persons.add(manager);

        Person accountant = new Person();
        director.setId(3);
        director.setName("Klava");
        director.setSurname("Sidorova");
        director.setAge(45);
        director.setSex(Sex.FEMALE);
        persons.add(accountant);
    }

    public Person findPerson(int id) {
        Person resultFinding = null;
        for (Person person : persons) {
            if (id == (person.getId())) {
                resultFinding = person;
            }
        }
        return resultFinding;
    }
}
