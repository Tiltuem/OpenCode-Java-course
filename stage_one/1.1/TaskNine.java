import java.util.Scanner;

public class TaskNine {
    public static void main(String[] args) {
        System.out.println("Введите строку: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        StringBuffer buffer = new StringBuffer(str);
        String str2 = buffer.reverse().toString();

        if (str.equals(str2)) {
            System.out.println("Это полиндром");
        } else System.out.println("Это не полиндром");
    }
}
