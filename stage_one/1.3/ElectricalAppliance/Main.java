import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ElectricalAppliance> electricalAppliances = new ArrayList<ElectricalAppliance>();
        System.out.println("Введите максимально допустимую нагрузку(А): ");
        String maxLoad = sc.nextLine();
        char[] maxLoadToChar = maxLoad.toCharArray();
        maxLoad = "";
        for (int i = 0; i < maxLoadToChar.length - 1; i++) {
            maxLoad += maxLoadToChar[i];
        }
        int numberMaxLoad = Integer.parseInt(maxLoad);
        int overalVoltage = 0;
        boolean prov = true;

        for (int i = 0; i < 5; i++) {
            System.out.println("Выберите прибор: ");
            System.out.println("1) Электро-чайник;\n" +
                    "2) Микроволновка;\n" +
                    "3) Холодильник;\n" +
                    "4) Пылесос;\n" +
                    "5) Телевизор."
            );
            int action = sc.nextInt();
            System.out.println("Введите мощность выбранного прибора: ");
            int voltage = sc.nextInt();
            switch (action) {
                case 1 -> {
                    electricalAppliances.add(new ElectricKettle("Scarlett", "SC-EK27G85", voltage, 2.7));
                }
                case 2 -> {
                    electricalAppliances.add(new Microwave("DEXP", "MS-70", voltage, 20));
                }
                case 3 -> {
                    electricalAppliances.add(new Fridge("Candy", "CCRN 6180S", voltage, 227));
                }
                case 4 -> {
                    electricalAppliances.add(new VacuumCleaner("ECON", "ECO-1415VB", voltage, "мешок"));
                }
                case 5 -> {
                    electricalAppliances.add(new TV("DEXP", "H24H7000E", voltage, 27.1));
                }
                default -> {
                    System.out.println("Неверно введён номер прибора.");
                    i--;
                }
            }
        }
        while (prov) {
            System.out.println("Выберите прибор: ");
            System.out.println("1) Электро-чайник;\n" +
                    "2) Микроволновка;\n" +
                    "3) Холодильник;\n" +
                    "4) Пылесос;\n" +
                    "5) Телевизор;\n" +
                    "6) Завершить программу."
            );
            int temp = sc.nextInt();
            System.out.println("Выберите действие: ");
            System.out.println("1) Включить прибор;\n" +
                    "2) Выключить прибор.");
            int action = sc.nextInt();
            switch (temp) {
                case 1 -> electricalAppliances.get(0).powerSupply(action);
                case 2 -> electricalAppliances.get(1).powerSupply(action);
                case 3 -> electricalAppliances.get(2).powerSupply(action);
                case 4 -> electricalAppliances.get(3).powerSupply(action);
                case 5 -> electricalAppliances.get(4).powerSupply(action);
                default -> {
                    System.out.println("Программа завершена.");
                    prov = false;
                }
            }
            if (prov ==false) break;
            if (electricalAppliances.get(temp - 1).getOnOrOff()!=1&&action==1) overalVoltage += electricalAppliances.get(temp - 1).getPower();
            else if (electricalAppliances.get(temp - 1).getOnOrOff()==1&&action==2) overalVoltage -= electricalAppliances.get(temp - 1).getPower();

            if (numberMaxLoad < overalVoltage / 220.0) {
                int numberDevice = loadCheck( overalVoltage,  numberMaxLoad, electricalAppliances);
                if (numberDevice==0) {
                    System.out.println("Нет прибора, который можно выключить.");
                }
                else {System.out.println("Вы превысили максимально допустимую нагрузку на сеть: наиболее подходящий прибор для выключения - " +electricalAppliances.get(numberDevice).getFirm()+" "+electricalAppliances.get(numberDevice).getModel());
                    System.out.println("1) Включить прибор;\n" +
                            "2) Выключить прибор.");
                    int onOrOff= sc.nextInt();
                    switch (onOrOff) {
                        case 1:
                            System.out.println("Превышена нагрузка на сеть!");
                        case 2: {
                            electricalAppliances.get(numberDevice).powerSupply(onOrOff);
                            overalVoltage -= electricalAppliances.get(numberDevice).getPower();
                        }
                    }
                }
            }
        }
    }

    public static int loadCheck(int overalVoltage, int numberMaxLoad, ArrayList<ElectricalAppliance> electricalAppliances) {
        double minDifference = 1000;;
        int numberDevice=0;
        for (int i = 0; i < electricalAppliances.size(); i++) {
            if (((overalVoltage - electricalAppliances.get(i).getPower()) / 220 < numberMaxLoad)&&electricalAppliances.get(i).getOnOrOff()==1) {
                if (numberMaxLoad - (overalVoltage - electricalAppliances.get(i).getPower()) / 220.0 <= minDifference) {
                    minDifference=numberMaxLoad - (overalVoltage - electricalAppliances.get(i).getPower()) / 220.0;
                    numberDevice=i;
                }
            }
        }
        return numberDevice;
    }
}
