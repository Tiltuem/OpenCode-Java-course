import java.util.Arrays;
import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int number = sc.nextInt();

        if (number == 1) System.out.println(0);
        else if (number == 2) System.out.println(1);
        else {
            int[] numbers = new int[number];
            numbers[0] = 0;
            numbers[1] = 1;
            for (int i = 2; i < numbers.length; i++) {
                numbers[i] = numbers[i - 2] + numbers[i - 1];
            }
            System.out.println(Arrays.toString(numbers));
        }
        sc.close;
    }
}
