import java.util.Scanner;

import static java.lang.Math.abs;

public class matrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размерность матрицы: ");
        int num = in.nextInt();
        int[][] matrix = new int[num][num];
        int num2=matrix.length/2;
        /* Буква Х
        for(int j = 0; j < matrix.length; j++){
            for(int l = 0; l < matrix.length; l++){
                if (j==l) matrix[j][l] = 1;
                else if (j+l==matrix.length-1) matrix[j][l] = 1;
                else matrix[j][l] = 0;
            }
        }

        /* Плюс
        for(int j = 0; j < matrix.length; j++){
            for(int l = 0; l < matrix.length; l++){
                if (l==num2) matrix[j][l] = 1;
                else if (j==num2) matrix[j][l] = 1;
                else matrix[j][l] = 0;
            }
        }

        Квадрат
        for(int j = 0; j < matrix.length; j++){
            for(int l = 0; l < matrix.length; l++){
                if (j==0||j==matrix.length-1||l==0||l==matrix.length-1) matrix[j][l] = 1;
                else matrix[j][l] = 0;
            }
        }

        Ромб
        for(int j = 0; j < matrix.length; j++){
            for(int l = 0; l < matrix.length; l++){
                if (j+l==num2||abs(j-l)==num2||j+l==num2*3) matrix[j][l] = 1;
                else matrix[j][l] = 0;
            }
        }
        */
        for(int j = 0; j < matrix.length; j++){
            for(int l = 0; l < matrix.length; l++){
                System.out.print(matrix[j][l]);
            }
            System.out.print("\n");
        }
    }
}