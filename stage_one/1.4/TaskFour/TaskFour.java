import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String text = sc.nextLine();
        System.out.println("Введите количество копий N");
        int N = sc.nextInt();
        System.out.println("Ввкдите ограничение на общую длину L");
        int L = sc.nextInt();
        System.out.println("Введите максимально количество слов М");
        int M = sc.nextInt();

        ComyAndComma operation = (thisText, thisN, thisL, thisM) -> {
            String[] textToWord = thisText.split(" ");
            StringBuilder newText = new StringBuilder();
            StringBuilder copyText = new StringBuilder();
            for (int i = 0; i < textToWord.length && i < thisM; i++) {
                newText.append(textToWord[i] + ", ");
            }
            int i = 0;
            while (copyText.length() <= thisL && i < thisN) {
                copyText.append(newText);
                i++;
            }
            if (copyText.length() > thisL) copyText.delete(thisL, copyText.length());
            else copyText.delete(copyText.length() - 2, copyText.length() - 1);
            return copyText.toString();
        };

        String newText = operation.ComyAndComma(text, N, L, M);
        System.out.println(newText);
        sc.close;
    }
}