public class TaskFour {
    public static void main(String[] args) {
        int[] array = new int[30];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        for (int i = 0; i < array.length; i++) {
            if (i % 10 != 0) System.out.print(array[i] + " ");
            else System.out.print("\n" + array[i] + " ");
        }
    }
}
