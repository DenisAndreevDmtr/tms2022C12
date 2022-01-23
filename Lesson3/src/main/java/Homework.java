import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        //printAlfabet();
        //numberCheck();
        // minAbsCheck();
        secsTohours();
        //table();
        // System.out.println(average(new int[]{1, 2, 3, 4, 5}));
        //System.out.println(max(new int[]{1, 2, 10, 3}));
    }

    //Задачи:
    //1) Используя тип данных char и операцию инкремента вывести на консоль все буквы английского алфавита
    private static void printAlfabet() {
        char ch = 96;
        for (int i = 0; i < 26; i++) {
            System.out.print(++ch + " ");
        }
    }

    //2)Проверка четности числа
    //Создать программу, которая будет сообщать, является ли целое число, введённое пользователем,
    // чётным или нет. Ввод числа осуществлять с помощью класса Scanner.
    // Если пользователь введёт не целое число, то сообщать ему об ошибке.
    private static void numberCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("для выполнения задачи №2 введите одно целое число");
        if (sc.hasNextInt()) {
            int number = sc.nextInt();
            if (number % 2 == 0) {
                System.out.println("число является четным");
            } else {
                System.out.println("число является нечетным");
            }
        } else {
            System.out.println("введена некорректная информация");
        }
    }

    //3) Меньшее по модулю число
    //Создать программу, которая будет выводить на экран меньшее по модулю из трёх введённых
    // пользователем вещественных чисел с консоли.
    private static void minAbsCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("для выполнения задачи №3 введите первое из трех вещественных чисел");
        double number1 = sc.nextDouble();
        System.out.println("для выполнения задачи №3 введите второе из трех вещественных чисел");
        double number2 = sc.nextDouble();
        System.out.println("для выполнения задачи №3 введите третье из трех вещественных чисел");
        double number3 = sc.nextDouble();
        double minAbcNumber = min(min(number1, number2), number3);
        System.out.println("наименьшее число по модулю" + minAbcNumber);
    }

    private static double min(double a, double b) {
        if (Math.abs(a) < Math.abs(b)) {
            return a;
        } else {
            return b;
        }
    }

    //4) На некотором предприятии инженер Петров создал устройство, на табло которого показывается количество секунд,
    // оставшихся до конца рабочего дня. Когда рабочий день начинается ровно в 9 часов утра — табло отображает «28800» (т.е. остаётся 8 часов),
    // когда времени 14:30 — на табло «9000» (т.е. остаётся два с половиной часа), а когда наступает 17 часов — на табло отображается «0»
    // (т.е. рабочий день закончился).
    //Программист Иванов заметил, как страдают офисные сотрудницы — им неудобно оценивать остаток рабочего дня в секундах.
    // Иванов вызвался помочь сотрудницам и написать программу, которая вместо секунд будет выводить на табло понятные фразы с информацией о том,
    // сколько полных часов осталось до конца рабочего дня. Например: «осталось 7 часов», «осталось 4 часа», «остался 1 час», «осталось менее часа».
    //Итак, в переменную n должно записываться случайное (на время тестирования программы) целое число из [0;28800],
    // далее оно должно выводиться на экран (для Петрова) и на следующей строке (для сотрудниц) должна
    // выводиться фраза о количестве полных часов, содержащихся в n секундах.
    private static void secsTohours() {
        Random random = new Random();
        int secLeft = random.nextInt(28801);
        int hoursLeft = secLeft / 3600;
        switch (hoursLeft) {
            case 8:
                System.out.println(secLeft + " осталось 8 часов");
                break;
            case 7:
                System.out.println(secLeft + " осталось 7 часов");
                break;
            case 6:
                System.out.println(secLeft + " осталось 6 часов");
                break;
            case 5:
                System.out.println(secLeft + " осталось 5 часов");
                break;
            case 4:
                System.out.println(secLeft + " осталось 4 часа");
                break;
            case 3:
                System.out.println(secLeft + " осталось 3 часа");
                break;
            case 2:
                System.out.println(secLeft + " осталось 2 часа");
                break;
            case 1:
                System.out.println(secLeft + " остался 1 час");
                break;
            case 0:
                System.out.println(secLeft + " осталось 0 часов");
                break;
            default:
                break;
        }
    }

    //5) Необходимо написать программу, которая будет выводить на консоль таблицу приведения типов!
//              byte	short	char	int 	long	float	double	boolean
//    byte
//    short
//    char
//    int
//    long
//    float
//    double
//    boolean
//
//    На пересечении напишите следующие фразы:
//    ня (неявное) – если преобразование происходит автоматически,
//    я (явное) – если нужно использовать явное преобразование,
//    х – если преобразование невозможно,
//    т  - если преобразование тождественно.
//    Внимание! используйте System.out.printLn
    private static void table() {
        String[][] table = new String[9][9];
        table[0] = new String[]{"таблица преобразования", " byte", " short", " char", " int", " long", " float", " double", " boolean"};
        table[1] = new String[]{"byte", " т", " ня", " я", " ня", " ня", " ня", " ня", " х"};
        table[2] = new String[]{"short", " я", " т", " я", " ня", " ня", " ня", " ня", " х"};
        table[3] = new String[]{"char", " я", " я", " т", " ня", " ня", " ня", " ня", " х"};
        table[4] = new String[]{"int", " я", " я", " я", " т", " ня", " ня", " ня", " х"};
        table[5] = new String[]{"long", " я", " я", " я", " я", " т", " ня", " ня", " х"};
        table[6] = new String[]{"float", " я", " я", " я", " я", " я", " т", " ня", " х"};
        table[7] = new String[]{"double", " я", " я", " я", " я", " я", " я", " т", " х"};
        table[8] = new String[]{"boolean", " х", " х", " х", " х", " х", " х", " х", " т"};
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 6) Метод должен вернуть среднее значение из массива чисел
     * (необходимо сумму всех элеменов массива разделить на длину массива)
     * <p>
     * Example:
     * array = {1,2,3,4,5}
     * Метод должен return 3.0
     */
    public static double average(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        double average = sum / array.length;
        return average;
    }

    /**
     * 7) Метод должен вернуть максимальый элемент массива. Пример: array = {1,2,10,3} метод возвращает 10
     **/
    public static int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}