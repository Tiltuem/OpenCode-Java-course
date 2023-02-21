public class TaskFive {
    public static void main(String[] args) {
        String str = "Hello world!";
        char[] symbol = str.toCharArray();

        for (int i = 0; i < symbol.length; i++) {
            System.out.println(symbol[i] + "-" + (int) symbol[i]);
        }
    }
}
