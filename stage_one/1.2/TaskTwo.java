import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = sc.nextLine().replaceAll("[^a-zA-Zа-яёА-ЯЁ ]", "");
        
        System.out.println(text);
        sc.close;
    }
}