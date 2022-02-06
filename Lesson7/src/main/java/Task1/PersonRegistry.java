package Task1;

//3) PersonRegistry содержит список людей (Person), которые могут быть призваны в армию
public class PersonRegistry {
    private Person[] persons;

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    public PersonRegistry(Person[] persons) {
        this.persons = persons;


    }
}
