import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = sc.nextLine();
        StringBuilder text2 = new StringBuilder();
        System.out.println("Введите элемент:");
        int number = sc.nextInt()-1;
        System.out.println("Введите символ:");
        String b = sc.next();
        char symbolChar = b.charAt(b.length()-1);
        for (String sentence : text.split("\\s")) {
            if (sentence.length()>=number) {
                char[] textToArray = sentence.toCharArray();
                textToArray[number]=symbolChar;
                sentence = String.valueOf(textToArray);
            }
            text2.append(sentence).append(" ");
        }
        System.out.println(text2);
    }
}
