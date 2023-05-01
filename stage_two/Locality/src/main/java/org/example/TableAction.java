package org.example;

import java.sql.*;
import java.util.Scanner;

public class TableAction {
    private static int getId(Connection connection, int key, String table, String idColumn) throws SQLException {
        Statement statement = connection.createStatement();
        try (ResultSet rs = statement.executeQuery("select " + idColumn + " from " + table)) {
            while (rs.next()) {
               if (rs.getInt(idColumn)==key) {
                   statement.close();
                   return key;
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        statement.close();
        return -1;
    }

    public static void setInfo(String value, String column, int key, String table, String idColumn, Statement statement) throws SQLException {
        if (column.equals("people") || column.equals("square")) statement.execute("UPDATE " + table +" SET " + column + " = " + Float.parseFloat(value) + " WHERE "+idColumn+" = "+key);
        else statement.execute("UPDATE " + table + " SET " + column+ " = '" + value + "' WHERE "+idColumn+" = "+key);
        System.out.println("Запись изменена.");
    }

    public static void deleteEntry(String id, String table, Statement statement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id, который хотите удалить: ");
        int key = in.nextInt();
        if (getId(connection, key, table, id)!=-1) {
            statement.execute("DELETE FROM " + table + " WHERE " + id +" = "+key);
            System.out.println("Запись удалена.");
        }
        else System.out.println("Неверно введён id.");
    }

    public static void insertLocality(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        String name;
        String type;
        String date;
        float square;
        float people;

        System.out.println("Введите название населенного пункта: ");
        name = in.nextLine();
        System.out.println("Введите  тип населенного пункта: ");
        type = in.nextLine();
        System.out.println("Введите дату основания(ГГГГ-ММ-ДД): ");
        date = in.nextLine();
        System.out.println("Введите площадь населенного пункта: ");
        square = in.nextFloat();
        System.out.println("Введите количество жителей населенного пункта: ");
        people = in.nextFloat();

        preparedStatement = connection.prepareStatement("INSERT INTO Locality(name_locality, square, type_locality, people, founding_date) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setFloat(2, square);
        preparedStatement.setString(3, type);
        preparedStatement.setFloat(4, people);
        preparedStatement.setString(5, date);
        preparedStatement.execute();
        System.out.println("Запись добавлена.");
    }
    public static void modifyLocality(Statement statement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id населенного пункта, который хотите изменить: ");
        int key = in.nextInt();
        if (getId(connection, key, "locality", "id_locality") == key) {
            System.out.println("Введите название столбца, значение которого хотите изменить: ");
            String column = in.next();
            switch (column) {
                case "Наименование" -> {
                    System.out.println("Введите новое название населенного пункта: ");
                    setInfo(in.next(), "name_locality", key,"locality", "id_locality", statement);
                }
                case "Площадь" -> {
                    System.out.println("Введите новое значение плошади: ");
                    setInfo(in.next(), "square", key, "locality","id_locality", statement);
                }
                case "Тип" -> {
                    System.out.println("Введите новый тип населенного пункта: ");
                    setInfo(in.next(), "type_locality", key, "locality","id_locality", statement);
                }
                case "Население" -> {
                    System.out.println("Введите новое количество населения: ");
                    setInfo(in.next(), "people", key, "locality","id_locality", statement);
                }
                case "Дата основания" -> {
                    System.out.println("Введите новую дату создания: ");
                    setInfo(in.next(), "date_founding", key, "locality","id_locality", statement);
                }
                default -> System.out.println("Неверно выбран столбец.");
            }
        }
        else System.out.println("Неверно введён id.");
    }

    public static void insertStreet(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        String name;
        String type;
        int id_locality;
        System.out.println("Введите id населенного пункта: ");
        id_locality = in.nextInt();
        System.out.println("Введите название: ");
        name = in.next();
        System.out.println("Введите  тип: ");
        type = in.next();

        preparedStatement = connection.prepareStatement("INSERT INTO Streets(name_street, type_street, id_loc) VALUES (?,?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, type);
        preparedStatement.setInt(3, id_locality);
        preparedStatement.execute();
        System.out.println("Запись добавлена.");
    }
    public static void modifyStreet(Statement statement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id, который хотите изменить: ");

        int key = in.nextInt();
        if (getId(connection, key, "streets", "id_street") == key) {
            System.out.println("Введите название столбца, значение которого хотите изменить: ");
            String column = in.next();
            switch (column) {
                case "Наименование" -> {
                    System.out.println("Введите новое значение: ");
                    setInfo(in.next(), "name_street", key,"streets", "id_street", statement);
                }
                case "Тип" -> {
                    System.out.println("Введите новое значение: ");
                    setInfo(in.next(), "type_street", key,"streets", "id_street", statement);
                }
                default -> System.out.println("Неверно выбран столбец.");
            }
        }
        else System.out.println("Неверно введён id.");
    }
}



