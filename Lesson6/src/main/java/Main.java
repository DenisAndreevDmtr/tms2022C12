public class Main {
    public static void main(String[] args) {
        User user1 = new User("Denis", "Andreev", 27, "Male");
        //      *  В Main классе в методе main создайте экземпляр класса User и вызовите все созданные методы, передав им необходимые параметры.
        System.out.println(user1.typeNameSurname());
        System.out.println(user1);
        System.out.println(user1.increaseAge(2));
        //     * 2) Создать в классе User несколько конструкторов. Создать объект этого класса, использовав один из них.
        User user2 = new User("Ivan", "Petrov", 25);
        System.out.println(user2);
        //*  Отметьте один из методов как @Deprecated. Попробуйте на экземпляре класса вызвать этот метод.
        System.out.println(user1.increaseAge(2));
    }

}
