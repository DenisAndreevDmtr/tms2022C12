package Task1;

public class Main {
    public static void main(String[] args) {
        Person pers1 = new Person("Ivan", 19, "male", new Adress("Belarus", "Minsk"));
        Person pers2 = new Person("Alex", 26, "male", new Adress("Belarus", "Minsk"));
        Person pers3 = new Person("Alex", 28, "male", new Adress("Belarus", "Vitebsk"));
        Person pers4 = new Person("Petr", 25, "male", new Adress("Belarus", "Minsk"));
        Person pers5 = new Person("Vladimir", 19, "male", new Adress("Belarus", "Grodno"));
        Person pers6 = new Person("Oksana", 21, "female", new Adress("Belarus", "Minsk"));
        Person pers7 = new Person("Alex", 17, "male", new Adress("Belarus", "Minsk"));

        Person[] persons = new Person[]{pers1, pers2, pers3, pers4, pers5, pers6, pers7};
        PersonRegistry listPersons = new PersonRegistry(persons);
        MilitaryOffice list1 = new MilitaryOffice(listPersons);
        System.out.println("Вывести имена всех людей годных к военной службе на текущий момент времени, которые есть в PersonRegistry:");
        list1.printRecruit();
        System.out.println("Вывести количество годных призывников в городе Минске:");
        list1.printRecruitFromMinsk();
        System.out.println("Вывести количество призывников от 25 до 27 лет:");
        list1.printRecruitFrom25to27();
        System.out.println("Вывести количество призывников у которых имя Александр:");
        list1.printRecruitByNameAlex();
    }
}
