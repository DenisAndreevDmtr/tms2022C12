package Task1;

//4) Создать класс Person, который будет содержать следующие поля имя, возраст, пол, адрес(страна, город)
public class Person {

    private String name;
    private int age;
    private String sex;
    private Adress adress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Person(String name, int age, String sex, Adress adress) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.adress = adress;


    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", adress=" + adress.getCountry() + " " + adress.getCity() +
                '}';
    }
}
