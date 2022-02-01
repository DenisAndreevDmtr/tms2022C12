public class User {
    // * 1) Создать класс User для хранения о обработки данных о пользователе.

    private String name;
    private String surname;
    private int age;
    private String sex;

    //2) Создать в классе User несколько конструкторов.
    public User(String name, String surname, int age, String sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public User() {
        this.sex = "Male";
    }

    //* В этом конструкторе сделать вызов другого конструктора этого же класса.
    public User(String name, String surname, int age) {
        this();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //*  - Возврата имени и фамилии полностью
    public String typeNameSurname() {
        return name + " " + surname;
    }
//       * Создать поля для хранения имени и фамилии, возраста и пола. Создать методы для:

    //    *  - Вывода общей информации о пользователе
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    //       * Создать поля для хранения имени и фамилии, возраста и пола. Создать методы для:
//* Отметьте один из методов как @Deprecated. Попробуйте на экземпляре класса вызвать этот метод.
    //  *  - Увеличения возраста
    @Deprecated
    public String increaseAge(int ageIncrease) {
        if (ageIncrease >= 1) {
            age = age + ageIncrease;
        } else {
            System.out.println("введена некорректная информация");
        }
        return "возраст пользователя " + age;
    }
}
