import java.util.Scanner;
import java.util.Stack;

public class TaskOne {
    public static void main(String[] args) {
        System.out.println("Введите выражение: ");
        Scanner in = new Scanner(System.in);
        String brackets = in.nextLine().replaceAll("[^(){}\\]\\[]+", "");
        char[] bracketsArray = brackets.toCharArray();

        Stack<Character> stackBrackets = new Stack<>();
        boolean check = true;

        if (bracketsArray.length % 2 != 0) check = false;
        else {
            for (int i = 0; i < bracketsArray.length; i++) {
                if (!check) break;
                if (bracketsArray[i] == ')' || bracketsArray[i] == '}' || bracketsArray[i] == ']') {
                    if (stackBrackets.empty()) {
                        check = false;
                        break;
                    }
                    switch (bracketsArray[i]) {
                        case ')' -> {
                            if (stackBrackets.pop() != '(') check = false;
                        }
                        case ']' -> {
                            if (stackBrackets.pop() != '[') check = false;
                        }
                        case '}' -> {
                            if (stackBrackets.pop() != '{') check = false;
                        }
                    }
                } else stackBrackets.push(bracketsArray[i]);
            }
        }
        
        if (check) System.out.println("Скобки расставлены верно.");
        else System.out.println("Ошибка в расстановке скобок");\
        sc.close;
    }
}