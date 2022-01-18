public class HomeWork {
    public static void main(String[] args) {
        //вывод на консоль
        printLiterals();
        //Некоторые тесты для проверки задач.
        System.out.println(sum(100, 200));
        System.out.println(sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(max(56, 349));
        System.out.println(average(new int[]{0, -2, 3, -1, 5}));
        System.out.println(max(new int[]{1, 2, 3, 4, 5, 100, 99}));
        System.out.println(calculateHypotenuse(3,4));
        System.out.println(calculateHypotenuse(3, 4));
    }
    private static void printLiterals() {
//        вывести на консоль литералы следующих видов:
//        логический
        System.out.println(true);

//        строковый
        System.out.println("привет");

//        символьный
        System.out.println('а');

//        целочисленный 2-й
        System.out.println(0b1101);

//        целочисленный 8-й
        System.out.println(010);

//        целочисленный 10-й
        System.out.println(10);

//        целочисленный 16-й
        System.out.println(0x6F);

//        литерал типа float
        System.out.println(2.1);

//        литерал типа double.
        System.out.println(2.2);
    }

    /**
     * 1. Метод должен вернуть сумму двух чисел a и b
     * 2. Дополнительно: сделать проверку если сумма a и b больше чем максимальное значение int то вернуть -1
     **/
    public static int sum(int a, int b) {
        long sum=(long) a+(long) b;
        if(sum > Integer.MAX_VALUE){
            sum=-1;
        }
        return (int)sum;
    }
    /**
     *
     * Метод должен вернуть максимальное значение из двух чисел
     *
     * <p>
     * Example1:
     * a = 4,
     * b = 5
     * <p>
     * Метод должен вернуть 5
     * Example2:
     * a = 10,
     * b = 10
     * <p>
     * Метод должен вернуть 10
     */
    public static int max(int a, int b) {
        int max=a;
        if(b>=a){
            max=b;
        }
        return max;
    }

    /**
     * Метод должен вернуть среднее значение из массива чисел
     * (необходимо сумму всех элеменов массива разделить на длину массива)
     * <p>
     * Example:
     * array = {1,2,3,4,5}
     * Метод должен return 3.0
     */
    public static double average(int[] array) {
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum=sum+array[i];
        }
        double average=sum/array.length;
        return average;
    }

    /**
     * Метод должен вернуть максимальый элемент массива. Пример: array = {1,2,10,3} метод возвращает 10
     **/
    public static int max(int[] array) {
        int max=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }

    /**
     * Используя теорему Пифагора, вычислите значение гипотенузы. Квадрат гипотенузы = сумме квадратов катетов
     *
     * <p>
     * Example1:
     * 3
     * 4
     * return 5
     * <p>
     * Example2:
     * 12
     * 16
     * return 20
     */
    public static double calculateHypotenuse(int a, int b) {
        double hypotenuse=Math.pow(a,2.0)+Math.pow(b,2.0);
        return hypotenuse;
    }
}