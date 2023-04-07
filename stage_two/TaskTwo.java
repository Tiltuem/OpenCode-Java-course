import java.util.Scanner;
import java.util.Stack;

public class TaskTwo {

    public static Stack<Integer> firstTower = new Stack<>();
    public static Stack<Integer> secondTower = new Stack<>();
    public static Stack<Integer> thirdTower = new Stack<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во дисков: ");
        int count = in.nextInt();

        for (int i = 1; i <= count; i++) {
            firstTower.push(i);
        }

        int move = 1;
            while (thirdTower.size()!=count) {
                if (move%2==1&&count%2==1) {
                   if(!firstTower.empty()&&firstTower.peek()==count) thirdTower.push(firstTower.pop());
                   else if(!secondTower.empty()&&secondTower.peek()==count) firstTower.push(secondTower.pop());
                   else secondTower.push(thirdTower.pop());
                }
                else if(move%2==1&&count%2==0) {
                    if(!firstTower.empty()&&firstTower.peek()==count) secondTower.push(firstTower.pop());
                    else if(!secondTower.empty()&&secondTower.peek()==count) thirdTower.push(secondTower.pop());
                    else firstTower.push(thirdTower.pop());
                }
                else {
                    if(!firstTower.empty()&&firstTower.peek()==count) {
                        if(!secondTower.empty()&&!thirdTower.empty()) {
                            if (secondTower.peek() < thirdTower.peek()) secondTower.push(thirdTower.pop());
                            else thirdTower.push(secondTower.pop());
                        }
                        else if (!secondTower.empty()) thirdTower.push(secondTower.pop());
                        else secondTower.push(thirdTower.pop());
                    }
                    else if(!secondTower.empty()&&secondTower.peek()==count) {
                        if(!firstTower.empty()&&!thirdTower.empty()) {
                            if (firstTower.peek() < thirdTower.peek()) firstTower.push(thirdTower.pop());
                            else thirdTower.push(firstTower.pop());
                        }
                        else if (!firstTower.empty()) thirdTower.push(firstTower.pop());
                        else firstTower.push(thirdTower.pop());

                    }
                    else {
                        if(!firstTower.empty()&&!secondTower.empty()) {
                            if (firstTower.peek() < secondTower.peek()) firstTower.push(secondTower.pop());
                            else secondTower.push(firstTower.pop());
                        }
                        else if (!secondTower.empty()) firstTower.push(secondTower.pop());
                        else secondTower.push(firstTower.pop());
                    }

                }
                move++;
                print();
            }
        }

    public static void print() {
        System.out.println(firstTower+" "+secondTower+" "+thirdTower);
    }
}


