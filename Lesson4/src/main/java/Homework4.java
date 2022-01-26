import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        //      weekDay();
        // countAmebs();
        //numberRank(-5555555);
        //zodiacSign(-20, 2);
        //printArray();
        //System.out.println(operation(-7));
        //System.out.println("количество нечетных чисел "+calculateCountOfOddElementsInMatrix(new int[]{1, 9, 10, 3, 7}));
        //countDevs(34);
        //foobar(15);
        //printPrimeNumbers();
    }

    //1) Задача на оператор switch!
//        Рандомно генерируется число От 1 до 7.
//        Если число равно 1, выводим на консоль “Понедельник”, 2 –”Вторник” и так далее.
//        Если 6 или 7 – “Выходной”.
    private static void weekDay() {
        Random random = new Random();
        int r = random.nextInt(7) + 1;
        switch (r) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6, 7:
                System.out.println("Выходной");
                break;
            default:
                break;
        }
    }

    //2) Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//         сколько амеб будет через 3, 6, 9, 12,..., 24 часа
    private static void countAmebs() {
        int count = 1;
        System.out.println("на 0 часу будет " + count + " амеба");
        for (int i = 3; i <= 24; i = i + 3) {
            count = count * 2;
            System.out.println("на " + i + " часу будет " + count + " амебы");
        }
    }

    //3) В переменную записываем число.
//        Надо вывести на экран сколько в этом числе цифр и положительное оно или отрицательное.
//        Например, Введите число: 5
//        "5 - это положительное число, количество цифр = 1" (исходя из задания предполагаем, что вводится целое число)
   /* private static void numberRank(int number) {
        if (number > 0) {
            String str = Integer.toString(number);
            System.out.println("число положительное, количество цифр в числе " + str.length());

        } else if (number < 0) {
            String str = Integer.toString(number);
            int count = str.length() - 1;
            System.out.println("число отрицательное, количество цифр в числе " + count);

        } else {
            System.out.println("число 0");
        }
    }
*/
    private static void numberRank(int number) {
        if (number == 0) {
            System.out.println("число 0");
        } else {
            String s = isPositive(number) == true ? "число положительное, количество цифр в числе " + strLength(number) : "число отрицательное, количество цифр в числе " + (strLength(number) - 1);
            System.out.println(s);
        }
    }

    private static boolean isPositive(int number) {
        return number > 0 ? true : false;
    }

    private static int strLength(int number) {
        String str = Integer.toString(number);
        int count = str.length();
        return count;
    }

    //4) Дано 2 числа, день и месяц рождения. Написать программу, которая определяет знак зодиака человека.
    private static void zodiacSign(int day, int month) {
        if (day >= 21 && month == 1 && day > 0 || day <= 19 && month == 2 && day > 0) {
            System.out.println("Водолей");
        } else if (day > 19 && month == 2 && day > 0 || day <= 20 && month == 3 && day > 0) {
            System.out.println("Рыбы");
        } else if (day > 20 && month == 3 && day > 0 || day <= 20 && month == 4 && day > 0) {
            System.out.println("Овен");
        } else if (day > 20 && month == 4 && day > 0 || day <= 21 && month == 5 && day > 0) {
            System.out.println("Телец");
        } else if (day > 21 && month == 5 && day > 0 || day <= 21 && month == 6 && day > 0) {
            System.out.println("Близнецы");
        } else if (day > 21 && month == 6 && day > 0 || day <= 22 && month == 7 && day > 0) {
            System.out.println("Рак");
        } else if (day > 22 && month == 7 && day > 0 || day <= 21 && month == 8 && day > 0) {
            System.out.println("Лев");
        } else if (day > 21 && month == 8 && day > 0 || day <= 23 && month == 9 && day > 0) {
            System.out.println("Дева");
        } else if (day > 23 && month == 9 && day > 0 || day <= 23 && month == 10 && day > 0) {
            System.out.println("Весы");
        } else if (day > 23 && month == 10 && day > 0 || day <= 23 && month == 11 && day > 0) {
            System.out.println("Скорпион");
        } else if (day > 23 && month == 11 && day > 0 || day <= 22 && month == 12 && day > 0) {
            System.out.println("Стрелец");
        } else if (day > 22 && month == 12 && day > 0 || day <= 20 && month == 1 && day > 0) {
            System.out.println("Козерог");
        } else {
            System.out.println("введена некорректная информация");
        }

    }

    /**
     * Необходимо прочитать с консоли значение числа типа int,
     * сделать проверку что если пользователь ввел не положительное число,
     * то вывести ошибку и отправить пользователя вводить заново новое число!
     * далее создать одномерный массив типа int размера прочитанного с консоли
     * далее заполнить массив случайными значениями
     * далее вывести массив на консоль
     */
    private static void printArray() {

        Scanner sc = new Scanner(System.in);
        int l;
        do {
            System.out.println("введите положительное целое число");
            while (!sc.hasNextInt()) {
                System.out.println("введите положительное целое число");
                sc.next();
            }
            l = sc.nextInt();
        } while (l <= 0);

        Random random = new Random();
        int[] mas = new int[l];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = random.nextInt(16);
            System.out.print(mas[i] + " ");
        }

    }

    /**
     * Метод должен выполнять некоторую операцию с int "number" в зависимости от некоторых условий:
     * - if number положительное число, то необходимо number увеличить на 1
     * - if number отрицательное - уменьшить на 2
     * - if number равно 0 , то замените значение number на 10
     * вернуть number после выполнения операций
     */
    public static int operation(int number) {
        if (number > 0) {
            number = number + 1;
        } else if (number < 0) {
            number = number - 2;
        } else {
            number = 10;
        }

        return number;
    }

    /**
     * На вход приходит массив целых чисел типа int
     * Необходимо найти количество нечетных элементов в массиве и вернуть значение в метод main,
     * в котором это значение распечатается на консоль.
     */
    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % 2 != 0) {
                count = count + 1;
            }
        }
        return count;
    }

    /**
     * На вход приходит число.
     * Вывести в консоль фразу из разряда "_COUNT_ программистов",
     * заменить _COUNT_ на число которое пришло на вход в метод и заменить окончание в слове "программистов" на
     * уместное с точки зрения русского языка.
     * Пример: 1 программист, 42 программиста, 50 программистов
     *
     * @param count - количество программистов
     */
    public static void countDevs(int count) {
        if (count / 10 == 0) {
            countOneDevs(count);
        } else if (count % 10 == 1) {
            System.out.println(count + " програмист");
        } else if (count % 10 > 1 && count % 10 < 5) {
            System.out.println(count + " програмиста");
        } else if (count % 10 >= 5 && count % 10 < 10 || count % 10 == 0) {
            System.out.println(count + " програмистов");
        }

    }

    private static void countOneDevs(int count) {
        if (count == 1) {
            System.out.println(count + "програмист");
        } else if (count > 1 && count < 5) {
            System.out.println(count + " програмиста");
        } else if (count > 4 && count < 10 || count == 0) {
            System.out.println(count + " програмистов");
        }
    }

    /**
     * Метод должен выводить разные строки в консоли в зависимости от некоторых условий:
     * - если остаток от деления на 3 равен нулю - выведите "foo" (example of number - 6)
     * - если остаток от деления на 5 равен нулю - вывести "bar" (example of number - 10)
     * - если остаток от деления на 3 и 5 равен нулю 0 ,то вывести "foobar" (example of number - 15)
     */
    public static void foobar(int number) {
        if (number % 3 == 0 && number % 5 != 0) {
            System.out.println("foo");
        } else if (number % 5 == 0 && number % 3 != 0) {
            System.out.println("bar");
        } else if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("foobar");
        }
    }

    /**
     * Задача со звездочкой!
     * Метод должен печатать все простые числа <1000
     * что такое просто число (https://www.webmath.ru/poleznoe/formules_18_5.php)
     */
    public static void printPrimeNumbers() {
        int i = 0;
        int j = 0;
        int countPrime = 0;
        for (i = 2; i < 1000; i++) {
            int countDel = 0;
            for (j = 1; j <= i; j++) {
                if (i % j == 0)
                    countDel++;
            }
            if (countDel == 2) {
                countPrime = countPrime + 1;
                // System.out.println("простое число " + i);
            }
        }
        System.out.println(countPrime);
    }

}







