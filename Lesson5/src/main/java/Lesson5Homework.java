import java.util.Random;
import java.util.Scanner;

public class Lesson5Homework {
    public static void main(String[] args) {
        //    sum(3, -2);
        //masA();
        //masB();
        //masC();
        // masD();
        //reverseMas();
        //maxIndex();
        //replaseElements();
        //replaseMaxZero(new int[]{4, 5, 0, 23, 77, 0, 8, 9, 101, 2});
        //dublicatesElements(new int[]{0,3,46,3,2,1,2});
        // masTrapon();
        //calculateSumOfDiagonalElements();
        //printMatrix();
        // additionlTask();
    }

    //        1) Напишите реализацию метода summ(int a, int b), вычисляющий a*b, не пользуясь операцией
//        умножения, где a и b целые числа, вызовите метод summ  в методе main и распечатайте на консоль.
    private static void sum(int a, int b) {
        int sum = 0;
        if (a > 0 && b > 0) {
            sum = summas(a, b);
        } else if (a < 0 && b > 0 || a > 0 && b < 0) {
            sum = -summas(Math.abs(a), Math.abs(b));
        } else if (a < 0 && b < 0) {
            sum = summas(Math.abs(a), Math.abs(b));
        }
        System.out.println("a*b=" + sum);
    }

    private static int summas(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }

//    2) Дан двухмерный массив размерностью 4 на 4, необходимо нарисовать четыре треугольника вида

    //        a)                  b)
//              *        *
//            * *        * *
//          * * *        * * *
//        * * * *        * * * *
//
//        c)                  d)
//        * * * *        * * * *
//          * * *        * * *
//            * *        * *
//              *        *
//        a)
    private static void masA() {
        String[][] mas = new String[4][4];
        int a = 4;
        for (int i = 0; i < 4; i++) {
            a = a - 1;
            for (int j = a; j < mas[i].length; j++) {
                mas[i][j] = "*";
            }
        }
        printMas(mas);
    }

    //        b)
    private static void masB() {
        String[][] mas = new String[4][4];
        int a = 0;
        for (int i = 0; i < 4; i++) {
            a = a + 1;
            for (int j = 0; j < a; j++) {
                mas[i][j] = "*";
            }
        }
        printMas(mas);
    }

    //        c)
    private static void masC() {
        String[][] mas = new String[4][4];
        int a = -1;
        for (int i = 0; i < 4; i++) {
            a = a + 1;
            for (int j = a; j < mas[i].length; j++) {
                mas[i][j] = "*";
            }
        }
        printMas(mas);
    }

    //        d)
    private static void masD() {
        String[][] mas = new String[4][4];
        int a = 5;
        for (int i = 0; i < mas.length; i++) {
            a = a - 1;
            for (int j = 0; j < a; j++) {
                mas[i][j] = "*";
            }
        }
        printMas(mas);
    }

    private static void printMas(String[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == null) {
                    mas[i][j] = " ";
                }
                System.out.print(mas[i][j]);
            }
            System.out.println();
        }

    }

    //     3) Создайте массив из всех нечётных чисел от 1 до 100, выведите его на экран в строку,
//        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1).

    private static void reverseMas() {
        int[] mas = new int[50];
        int a = 1;
        for (int i = 1; i < mas.length; i += 2) {
            mas[i] = a;
            a = a + 2;
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        for (int i = mas.length - 1; i >= 0; i--) {
            System.out.print(mas[i] + " ");
        }
    }

//    4) Создайте массив из int[] mass = new int[12]; Рандомно заполните его значениями от 0 до 15.
//        Определите какой элемент является в этом массиве максимальным и сообщите индекс его последнего вхождения в массив.
//        Пример: {3,4,5,62,7,8,4,-5,7,62,5,1} Максимальный элемент 62, индекс его последнего вхождения в массив = 10

    private static void maxIndex() {
        Random random = new Random();
        int[] mas = new int[12];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = random.nextInt(16);
            System.out.print(mas[i] + " ");
        }
        int max = 0;
        int imax = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] >= max) {
                max = mas[i];
                imax = i;
            }
        }
        System.out.println("Максимальный элемент " + max + ", идекс его последнего вхождения в массив = " + imax);
    }

    //     5) Создайте массив размера 20, заполните его случайными целыми чиселами из отрезка от 0 до 20.
//        Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
//        Снова выведете массив на экран на отдельной строке.
    private static void replaseElements() {
        int[] mas = new int[20];
        for (int i = 0; i < mas.length; i++) {
            Random random = new Random();
            mas[i] = random.nextInt(21);
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < mas.length; i++) {
            if (i % 2 != 0) {
                mas[i] = 0;
            }
            System.out.print(mas[i] + " ");
        }
    }

    //6) Найти максимальный элемент в массиве {4,5,0,23,77,0,8,9,101,2} и поменять его местами с нулевым элементом
    private static void replaseMaxZero(int[] mas) {
        int max = Integer.MIN_VALUE;
        int imax = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > max) {
                max = mas[i];
                imax = i;
            }
        }
        mas[imax] = mas[0];
        mas[0] = max;
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
    }

    //        7) Проверить, различны ли все элементы массива, если не различны то вывести элемент повторяющийся
//        Пример: {0,3,46,3,2,1,2}
//        Массив имеет повторяющиеся элементы 3, 2
//        Пример: {0,34,46,31,20,1,28}
//        Массив не имеет повторяющихся элементов

    private static void dublicatesElements(int[] mas) {

        if (isDublicates(mas)) {
            System.out.print("Массив имеет повторяющиеся элементы ");
            for (int i = 0; i < mas.length; i++) {
                int example = mas[i];
                for (int j = i + 1; j < mas.length; j++) {
                    if (example == mas[j]) {
                        System.out.print(mas[j] + " ");
                    }
                }
            }
        } else {
            System.out.println("Массив не имеет повторяющихся элементов");
        }
    }

    private static boolean isDublicates(int[] mas) {
        boolean check = false;
        for (int i = 0; i < mas.length; i++) {
            int example = mas[i];
            for (int j = i + 1; j < mas.length; j++) {
                if (example == mas[j]) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

//    8) Создаём квадратную матрицу, размер вводим с клавиатуры.
//        Заполняем случайными числами в диапазоне от 0 до 50. И выводим на консоль(в виде матрицы).
//        Далее необходимо транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)
//        Пример:
//          1 2 3 4      1 6 3 1
//          6 7 8 9      2 7 3 5
//          3 3 4 5      3 8 4 6
//          1 5 6 7      4 9 5 7

    private static void masTrapon() {
        System.out.println("Введите размерность массива в виде целого числа более 2");
        Scanner sc = new Scanner(System.in);
        int s = 0;
        Random random = new Random();
        if (sc.hasNextInt()) {
            s = sc.nextInt();
        } else {
            System.out.println("введена некорректная размерность массива");
        }
        if (s < 2) {
            System.out.println("введена некорректная размерность массива");
        } else {
            System.out.println("исходная матрица");
            int mas[][] = new int[s][s];
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = random.nextInt(51);
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("транспонированная матрица");
            int mas2[][] = new int[s][s];
            for (int i = 0; i < mas2.length; i++) {
                for (int j = 0; j < mas2[i].length; j++) {
                    mas2[i][j] = mas[j][i];
                    System.out.print(mas2[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * заполнить рандомно 2-х мерный массив и посчитать сумму элементов на диагонали
     */
    public static void calculateSumOfDiagonalElements() {
        System.out.println("Введите размерность массива в виде целого числа более 2");
        Scanner sc = new Scanner(System.in);
        int s = 0;
        Random random = new Random();
        if (sc.hasNextInt()) {
            s = sc.nextInt();
        } else {
            System.out.println("введена некорректная размерность массива");
        }
        if (s < 2) {
            System.out.println("введена некорректная размерность массива");
        } else {
            int mas[][] = new int[s][s];
            System.out.println("исходный массив");
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = random.nextInt(6);
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
            int sum = 0;
            for (int i = 0; i < mas.length; i++) {
                sum = sum + mas[i][i];
            }
            System.out.println("сумма элементов диагонали равняется " + sum);
        }
    }

    /**
     * Шаги по реализации:
     * - Прочитать два int из консоли
     * - Создайте двумерный массив int (используйте целые числа, которые вы читаете по высоте и ширине консоли)
     * - Заполнить массив случайными значениями (до 100)
     * - Вывести в консоль матрицу заданного размера, но:
     * - Если остаток от деления элемента массива на 3 равен нулю - выведите знак "+" вместо значения элемента массива.
     * - Если остаток от деления элемента массива на 7 равен нулю - выведите знак "-" вместо значения элемента массива.
     * - В противном случае выведите "*"
     * <p>
     * Example:
     * - Значения с консоли - 2 и 3
     * - Массив будет выглядеть так (значения будут разными, потому что он случайный)
     * 6 11 123
     * 1 14 21
     * - Для этого значения вывод в консоли должен быть:
     * <p>
     * + * *
     * * - +
     * <p>
     * Обратите внимание, что 21% 3 == 0 и 21% 7 = 0, но выводить надо не +-, а +
     */
    public static void printMatrix() {
        System.out.println("Введите размерность двумерного массива в виде целого чисел более 2. Вводится число строк массива. Этап 1 из 2");
        Scanner sc = new Scanner(System.in);
        int s = 0;
        int c = 0;
        Random random = new Random();
        if (sc.hasNextInt()) {
            s = sc.nextInt();
        } else {
            System.out.println("введена некорректная размерность массива");
        }
        System.out.println("Введите размерность двумерного массива в виде целого чисел более 2. Вводится число столбцов массива. Этап 2 из 2");
        if (sc.hasNextInt()) {
            c = sc.nextInt();
        } else {
            System.out.println("введена некорректная размерность массива");
        }
        if (s < 2 || c < 2) {
            System.out.println("введена некорректная размерность массива");
        } else {
            int mas[][] = new int[s][c];
            System.out.println("исходный массив");
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = random.nextInt(101);
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("изменение массива");
            String mas2[][] = new String[s][c];
            for (int i = 0; i < mas2.length; i++) {
                for (int j = 0; j < mas2[i].length; j++) {
                    if (mas[i][j] % 3 == 0) {
                        mas2[i][j] = "+";
                    } else if (mas[i][j] % 7 == 0) {
                        mas2[i][j] = "-";
                    } else if (mas[i][j] % 7 == 0 && mas[i][j] % 3 == 0) {
                        mas2[i][j] = "+";
                    } else {
                        mas2[i][j] = "*";
                    }
                    System.out.print(mas2[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    //  Создать матрицу размера 10 на 10 и заполнить ее случайными целочислеными значениями (тип int) из диапазона от 0 до 10000.
    //   Найти максимум среди сумм трех соседних элементов в строке. Для найденной тройки с максимальной суммой
    //   выведите значение суммы и индексы(i,j) первого элемента тройки.
    //   Пример:
//            *Для простоты пример показан на одномерном массиве размера 10
//            [1, 456, 1025, 65, 954, 2789, 4, 8742, 1040, 3254] Тройка с максимальной суммой:  [2789, 4, 8742]
//    Вывод в консоль:
//            11535 (0,5)
//            *Пояснение. Первое число - сумма тройки  [2789, 4, 8742]. Числа в скобках это 0 строка и 5 столбец -
//            индекс первого элемента тройки, то есть индекс числа 2789.

    public static void additionlTask() {
        System.out.println("вывод базовой матрица");
        int[][] mas = new int[10][10];
        Random random = new Random();
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = random.nextInt(10001);
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.print("для " + i + " строки максимальная сумма пар ");
            maxThreeElements(mas[i]);
            System.out.println();
        }
    }

    private static void maxThreeElements(int[] mas) {
        int sum = 0;
        int isum = 0;
        for (int i = 0; i < mas.length - 2; i++) {
            if (mas[i] + mas[i + 1] + mas[i + 2] > sum) {
                sum = mas[i] + mas[i + 1] + mas[i + 2];
                isum = i;
            }
        }
        System.out.print(sum + " номер первого элемента " + isum);
    }


}


