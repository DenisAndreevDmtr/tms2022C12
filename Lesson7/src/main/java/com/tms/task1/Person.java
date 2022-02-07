package com.tms.task1;

//4) Создать класс Person, который будет содержать следующие поля имя, возраст, пол, адрес(страна, город)
public class Person {

    private String name;
    private int age;
    private String sex;
    private Address address;

    public Person(String name, int age, String sex, Address address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address adress) {
        this.address = adress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address=" + address.getCountry() + " " + address.getCity() +
                '}';
    }
}
