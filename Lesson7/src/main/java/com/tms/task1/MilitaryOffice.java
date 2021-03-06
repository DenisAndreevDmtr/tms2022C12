package com.tms.task1;

//1) Создаем класс военкомат MilitaryOffice
public class MilitaryOffice {
    private static final int MIN_AGE = 18;
    private static final int NEW_MIN_AGE = 25;
    private static final int MAX_AGE = 27;

    //  2) Создать в классе MilitaryOffice конструктор, который принимает PersonRegistry
    private PersonRegistry personRegistry;

    public MilitaryOffice(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
    }

    public void printRecruit() {
        int count = 0;
        for (int i = 0; i < personRegistry.getPersons().length; i++) {
            if (checkAgeAndSex(personRegistry.getPersons()[i], MIN_AGE, MAX_AGE)) {
                System.out.println(personRegistry.getPersons()[i].toString());
                count = count + 1;
            }
        }
        System.out.println("Количество призывников " + count);
    }

    public void printRecruitFromCity(String city) {
        int count = 0;
        for (int i = 0; i < personRegistry.getPersons().length; i++) {
            if (personRegistry.getPersons()[i].getAddress().getCity().equals(city) && checkAgeAndSex(personRegistry.getPersons()[i], MIN_AGE, MAX_AGE)) {
                System.out.println(personRegistry.getPersons()[i].toString());
                count = count + 1;
            }
        }
        System.out.println("Количество призывников в городе " + city + " " + count);
    }

    public void printRecruitFrom25to27() {
        int count = 0;
        for (int i = 0; i < personRegistry.getPersons().length; i++) {
            if (checkAgeAndSex(personRegistry.getPersons()[i], NEW_MIN_AGE, MAX_AGE)) {
                System.out.println(personRegistry.getPersons()[i].toString());
                count = count + 1;
            }
        }
        System.out.println("Количество призывников от 25 до 27 " + count);
    }

    public void printRecruitByName(String name) {
        int count = 0;
        for (int i = 0; i < personRegistry.getPersons().length; i++) {
            if (checkAgeAndSex(personRegistry.getPersons()[i], NEW_MIN_AGE, MAX_AGE) &&
                    personRegistry.getPersons()[i].getName().equals(name)) {
                System.out.println(personRegistry.getPersons()[i].toString());
                count = count + 1;
            }
        }
        System.out.println("Количество призывников по имени " + name + " " + count);
    }

    private boolean checkAgeAndSex(Person person, int minAge, int maxAge) {
        return person.getSex().equals("male") &&
                person.getAge() >= minAge &&
                person.getAge() <= maxAge;
    }
}

