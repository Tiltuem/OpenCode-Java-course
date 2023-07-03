import java.util.ArrayList;
import java.util.Scanner;


public class TaskEight {

    public static ArrayList<Integer> numbersInt = new ArrayList<>();
    public static ArrayList<String> signs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String math = in.nextLine();

        String[] numbers = math.split("\\+|-|\\*|/");
        String[] signsArr = math.split("\\d");

        for (int i = 0; i < numbers.length; i++) {
            numbersInt.add(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < signsArr.length; i++) {
            if (!signsArr[i].equals("") || i == 0) signs.add(signsArr[i]);
        }

        for (int j = signs.size() - 1; j > 0; j--) {
            if (signs.get(j).equals("*")) {
                operation("*", j);
            } else if (signs.get(j).equals("/")) {
                operation("/", j);
            }
        }
        for (int j = signs.size() - 1; j > 0; j--) {
            if (signs.get(j).equals("-")) {
                operation("-", j);
            }
        }
        for (int j = signs.size() - 1; j > 0; j--) {
            if (signs.get(j).equals("+")) {
                operation("+", j);
            }
        }
        System.out.println(numbersInt.get(0));
    }

    public static int operation(String sign, int j) {
        switch (sign) {
            case "+" -> numbersInt.set(j - 1, numbersInt.get(j) + numbersInt.get(j - 1));
            case "-" -> numbersInt.set(j - 1, numbersInt.get(j) - numbersInt.get(j - 1));
            case "/" -> numbersInt.set(j - 1, numbersInt.get(j) / numbersInt.get(j - 1));
            case "*" -> numbersInt.set(j - 1, numbersInt.get(j) * numbersInt.get(j - 1));
        }
        numbersInt.remove(j);
        signs.remove(j);
    }
}
