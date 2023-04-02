import java.util.Scanner;
import java.util.function.Predicate;

public class TaskFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int number = sc.nextInt();

        Predicate<Integer> isFeb = (num) -> {
            if (num == 0||num == 1) return true;
            int i=1, aCurrent = 1, aPrevious=1, a=0;
            while (a < num) {
                a=aCurrent+aPrevious;
                aPrevious=aCurrent;
                aCurrent=a;
            }
            return a==num;
        };

        if(isFeb.test(number)) System.out.println("Является");
        else System.out.println("Не является");
    }
}