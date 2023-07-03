import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = sc.nextLine();
        String[] words = text.split(" ");

        int maxLength = words[0].length();
        int minLength = words[0].length();
        for (String word : words) {
            word = word.replaceAll("[^A-Za-zА-Яа-я]", "");
            if (minLength >= word.length()) minLength = word.length();
            else if (maxLength <= word.length()) maxLength = word.length();
        }

        StringBuilder wordMinLength = new StringBuilder();
        StringBuilder wordMaxLength = new StringBuilder();
        for (String word : words) {
            word = word.replaceAll("[^A-Za-zА-Яа-я]", "");
            if (minLength == word.length()) wordMinLength.append(word + ", ");
            else if (maxLength == word.length()) wordMaxLength.append(word).append(", ");
        }
        System.out.printf("Слова с максимальной длиной: %s;\nСлова с минимальной длиной: %s. ", wordMaxLength.substring(0, wordMaxLength.length() - 2), wordMinLength.substring(0, wordMinLength.length() - 2));
        sc.close;
    }
}