package com.company;

public class TaskTwo {
    public static void main(String[] args) {

        int int_number_1 = 10, int_number_2 = 2;
        float float_number_1 = 1.1f, float_number_2 = 2.2f;

        int result_plus = int_number_1 + int_number_2;
        int result_minus = int_number_1 - int_number_2;
        int result_prod = int_number_1 * int_number_2;
        int result_div = int_number_1 / int_number_2;

        System.out.println("Сложение: " + result_plus + "\nВычитание: " + result_minus + "\nУмножение: " + result_prod + "\nДеление: " + result_div);
        System.out.printf("Сложение: %f\nВычитание: %f\nУмножение: %f\nДеление: %f", float_number_1 + float_number_2, float_number_1 - float_number_2, float_number_1 * float_number_2, float_number_1 / float_number_2);
    }
}