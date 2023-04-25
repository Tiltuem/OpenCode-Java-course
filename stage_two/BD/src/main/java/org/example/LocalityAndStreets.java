package org.example;

import java.sql.*;
import java.util.Scanner;

public class LocalityAndStreets {
    static boolean flag = true;
    static PreparedStatement preparedStatement = null;
    static Statement statement;
    static Connection connection;

    public static void main(String[] args) throws SQLException {
        ConnectionBD connectionBD = new ConnectionBD();
        connection = connectionBD.getConnection();
        statement = connection.createStatement();
        System.out.println("Вы успешно подключились к базе данных ");
        //CheckTables.tableExistsSQL(statement);

        CheckExistTable checkLocality = (stat) -> stat.execute(
                "CREATE table IF NOT EXISTS Locality(" +
                "id_locality SERIAL primary key," +
                "name_locality varchar(255)," +
                "square float," +
                "type_locality varchar(255)," +
                "people float," +
                "founding_date varchar(255))");
        CheckExistTable checkStreets= (stat) -> stat.execute(
                "CREATE table IF NOT EXISTS Streets(" +
                    "id_street SERIAL primary key," +
                    "name_street varchar(255)," +
                    "type_street varchar(255)," +
                    "id_loc INTEGER REFERENCES Locality(id_locality) ON DELETE CASCADE)");
        checkLocality.TableExistsSQL(statement);
        checkStreets.TableExistsSQL(statement);

        System.out.println("Текущя информация о населенных пунктах и улицах: ");
        PrintResult.printAllTables(statement);
        while (flag) menu();
    }

    public static void menu() throws SQLException {
        System.out.println("""
                Выберите действие:
                1) Создать, модифицировать, удалить информацию о населенном пункте и его улицах;
                2) Получить полную справочную информацию о конкретном населенном пункте;
                3) Получить справочную информацию о наличии улиц(-ы) в конкретном населенном пунктеж
                4) Получить справочную информацию о наличии населенных пунктов по критериям;
                5) Завершить работу.""");
        Scanner in = new Scanner(System.in);
        int action = in.nextInt();
        switch (action) {
            case 1 -> {
                System.out.println("""
                        Выберите действие:
                        1) создать;
                        2) модифицировать;
                        3) удалить""");
                action = in.nextInt();
                System.out.println("""      
                        1) населенный пункт;
                        2) улица""");
                switch (in.nextInt()) {
                    case 1 -> {
                        switch (action) {
                            case 1 -> Locality.insertLocality(preparedStatement, connection);
                            case 2 -> {
                                PrintResult.printTableLocality(statement);
                                Locality.modifyLocality(preparedStatement, connection);
                            }
                            case 3 -> {
                                PrintResult.printTableLocality(statement);
                                Locality.deleteLocality(preparedStatement, connection);
                            }
                            default -> System.out.println("Неревно введён номер действия.");
                        }
                    }
                    case 2 -> {
                        switch (action) {
                            case 1 -> Streets.insertStreet(preparedStatement, connection);
                            case 2 -> {
                                PrintResult.printTableStreets(statement);
                                Streets.modifyStreet(preparedStatement, connection);
                            }
                            case 3 -> {
                                PrintResult.printTableStreets(statement);
                                Streets.deleteStreet(preparedStatement, connection);
                            }
                            default -> System.out.println("Неревно введён номер действия.");
                        }
                    }
                    default -> System.out.println("Неревно введён номер действия.");
                }
            }
            case 2 -> {
                System.out.println("Введите название населенного пункта: ");
                PrintResult.printLocalityInformation(in.next(), preparedStatement, connection);
            }
            case 3 -> {
                System.out.println("""
                        Выберите критерий поиска:
                        1) название населенного пункта;
                        2) название улицы""");
                switch (in.nextInt()) {
                    case 1 -> {
                        System.out.println("Введите название населенного пункта: ");
                        SearchInfo.searchAllStreetsLocality(in.next(), preparedStatement, connection);
                    }
                    case 2 -> {
                        System.out.println("Введите название улицы: ");
                        SearchInfo.searchAllLocalityWithStreet(in.next(), preparedStatement, connection);
                    }
                    default -> System.out.println("Неверно введён номер действия.");
                }
            }
            case 4 -> {
                System.out.println("""
                        Выберите номер критерия поиска:
                        1) название населенного пункта;
                        2) количество жителей;
                        3) площадь;
                        4) дата основания;
                        5) название улицы;
                        6) тип улицы.""");
                action = in.nextInt();
                switch (action) {
                    case 1 -> {
                        System.out.println("Введите полное или частичное название пункта: ");
                        SearchInfo.searchByName(in.next(), "name_locality", "locality", statement);
                    }
                    case 2 -> {
                        System.out.println("Введите количество жителей(в тыс.): ");
                        SearchInfo.searchBySquareOrPeople(in.nextFloat(), "people", statement);
                    }
                    case 3 -> {
                        System.out.println("Введите площадь: ");
                        SearchInfo.searchBySquareOrPeople(in.nextFloat(), "square", statement);
                    }
                    case 4 -> {
                        System.out.println("Введите дату основания(ГГГГ-ММ-ДД): ");
                        SearchInfo.searchByDate(in.next(), preparedStatement, connection);
                    }
                    case 5 -> {
                        System.out.println("Введите полное или частичное название улицы: ");
                        SearchInfo.searchByName(in.next(), "name_street", "streets", statement);
                    }
                    case 6 -> {
                        System.out.println("Введите тип улицы: ");
                        SearchInfo.searchByTypeStreet(in.next(), preparedStatement, connection);
                    }
                    default -> System.out.println("Неревно введён номер действия.");
                }
            }
            case 5 -> flag = false;
            default -> System.out.println("Неверно введён номер действия.");
        }
    }
    /*public static void save(){
        try (FileWriter writer = new FileWriter("C:\\\\Users\\\\Kirill\\\\Desktop\\\\result.txt"); PrintWriter printWriter = new PrintWriter(writer);) {
            printWriter.printf("");
        }
        catch(Exception exception) {
            System.out.println("Error: " + exception);
        }
    }*/
}





