import java.util.Scanner;

public class TaskComputer {

    public static void main(String[] args) {
        boolean temp = false;
        boolean prov = true;
        CPU cpu = new CPU("AMD", "A6-9500E");
        RAM ram = new RAM("AMD", "Radeon R5 Entertainment Series", "DDR4", 8);
        HDD hdd = new HDD("Toshiba", "P300 ", 3.5, 500);
        Computer pc = new Computer(cpu,ram,hdd);
        Scanner sc = new Scanner(System.in);
        while (prov) {
            System.out.println("Выберите действие: ");
            System.out.println("1) Включить/выключить компьютер;\n"+
                               "2) Проверить на вирусы;\n"+
                               "3) Вывести размер винчестера и оперативной памяти;\n"+
                               "4) Вывести результат проверки на вирусы;\n"+
                               "5) Завершить программу."
                    );
            int action = sc.nextInt();
            switch (action) {
                case 1 -> {
                    System.out.println("1) Включить компьютер\n" +
                            "2) Выключить компьютер");
                    int num = sc.nextInt();
                    if (num == 1) {
                        temp = true;
                        pc.power(temp);
                        System.out.println("Компьютер включён.");
                    } else if (num == 2) {
                        System.out.println("Компьютер выключен.");
                        pc.power(temp);
                    } else System.out.println("Неверно введён номер действия.");
                }
                case 2 -> {
                    pc.virusCheck();
                    System.out.println("Компьютер прошел проверку.");
                }
                case 3 -> pc.getSize();
                case 4 -> pc.printVirusCheck();
                case 5 -> prov = false;
                default -> System.out.println("Неверно введён номер действия.");
            }
            System.out.print("\033[H\033[J");
        }
        System.out.println("Программа завершена.");
        sc.close;
    }
}