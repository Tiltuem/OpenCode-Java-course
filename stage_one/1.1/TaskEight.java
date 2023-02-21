import java.util.ArrayList;
import java.util.Scanner;

class Numbers {

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        number = number;
    }
}
class Signs {

    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        sign = sign;
    }
}
public class TaskEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String math = in.nextLine();

        String[] numbers = math.split("\\+|-|\\*|/");
        String[] signsArr = math.split("\\d");

        ArrayList<Integer> numbersInt = new ArrayList<>();
        ArrayList<String> signs = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersInt.add(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < signsArr.length; i++) {
            if (!signsArr[i].equals("") || i==0) signs.add(signsArr[i]);

        }

        for (int j = signs.size()-1; j >0; j--) {
            if (signs.get(j).equals("*")) {
                numbersInt.set(j-1, numbersInt.get(j-1)*numbersInt.get(j));
                numbersInt.remove(j);
                signs.remove(j);
            } else if (signs.get(j).equals("/")) {
                numbersInt.set(j-1, numbersInt.get(j-1)/numbersInt.get(j));
                numbersInt.remove(j);
                signs.remove(j);
            }
        }
        for (int j = signs.size()-1; j >0; j--) {
            if (signs.get(j).equals("-")) {
                numbersInt.set(j-1, numbersInt.get(j-1)-numbersInt.get(j));
                numbersInt.remove(j);
                signs.remove(j);
            }
        }
        for (int j = signs.size()-1; j >0; j--) {
            if (signs.get(j).equals("+")) {
                numbersInt.set(j - 1, numbersInt.get(j) + numbersInt.get(j - 1));
                numbersInt.remove(j);
                signs.remove(j);
            }
        }
        System.out.println(numbersInt.get(0));
    }
}
