import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = in.nextInt();
        System.out.println("Введите делитель: ");
        int denominator = in.nextInt();

        Operation operation = (num, den) -> {
            return num % den == 0;
        };

        if(operation.test(number, denominator)) System.out.println("Кратно");
        else System.out.println("Не кратно");
    }
}