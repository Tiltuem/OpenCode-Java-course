import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {

        System.out.println("Введите число N: ");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] array = new int[N][N];
        int maxLine = N - 1, maxColumn = N - 1, temp = 0;
        int count = 1;

        while (temp != N - 1) {
            for (int i = temp; i <= maxColumn; i++) {
                if (i == 0) i++;
                array[temp][i - 1] = count;
                count++;
            }
            for (int i = temp; i <= maxLine; i++) {
                array[i][maxColumn] = count;
                count++;
            }
            for (int i = maxColumn - 1; i >= temp; i--) {
                array[maxLine][i] = count;
                count++;
            }
            for (int i = maxLine - 1; i >= temp + 2; i--) {
                array[i][temp] = count;
                count++;
            }
            maxColumn -= 2;
            maxLine -= 2;
            temp += 2;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println("");
        }
        sc.close;
    }
}