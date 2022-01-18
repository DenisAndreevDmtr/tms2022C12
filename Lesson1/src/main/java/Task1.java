import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        System.out.println("введите строку чисел через пробел");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String mas1[] = str.split(" ");
        try {
            int counter = 0;
            for (int i = 0; i < mas1.length; i++) {
                int number = Integer.parseInt(mas1[i]);
                if (number > 0) {
                    counter = counter + 1;
                }
            }
            System.out.println("количество положительных чисел " + counter);
        }
        catch (NumberFormatException e){
            System.out.println("введены неверные данные");
        }
    }
}
