package org.example;

import java.sql.*;
import java.util.Scanner;

public class Streets {
    public static int getIdStreet(Connection connection, int key) throws SQLException {
        Statement statement = connection.createStatement();
        try (ResultSet rs = statement.executeQuery("select id_streets from streets")) {
            while (rs.next()) {
                if (rs.getInt("id_locality")==key) {
                    return key;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void setName(String name, int key, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE streets SET name_street = (?) WHERE id_street = (?)");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, key);
        preparedStatement.execute();
        System.out.println("Запись изменена.");
    }
    public static void setType(String type, int key, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE streets SET type_street = (?) WHERE id_street = (?)");
        preparedStatement.setString(1, type);
        preparedStatement.setInt(2, key);
        preparedStatement.execute();
    }

    public static void insertStreet(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        String name;
        String type;

        System.out.println("Введите название населенного пункта: ");
        name = in.nextLine();
        System.out.println("Введите  тип населенного пункта: ");
        type = in.nextLine();


        preparedStatement = connection.prepareStatement("INSERT INTO Streets(name_streets, type)VALUES (?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, type);
        preparedStatement.execute();
        System.out.println("Запись добавлена.");
    }
    public static void deleteStreet(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id пункта, который хотите удалить: ");
        int key = in.nextInt();

        if (getIdStreet(connection, key)!=-1) {
            preparedStatement = connection.prepareStatement("DELETE FROM Streets WHERE id_street = (?);");
            preparedStatement.setInt(1, key);
            preparedStatement.execute();
            System.out.println("Запись удалена.");
        }
        else System.out.println("Неверно введён id.");
    }
    public static void modifyStreet(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id населенного пункта, который хотите изменить: ");
        int key = in.nextInt();
        if (getIdStreet(connection, key) == key) {
            System.out.println("Введите название столбца, значение которого хотите изменить: ");
            String column = in.next();
            switch (column) {
                case "Наименование" -> {
                    System.out.println("Введите новое название населенного пункта: ");
                    setName(in.next(), key, preparedStatement, connection);
                }
                case "Тип" -> {
                    System.out.println("Введите новое тип населенного пункта: ");
                    setType(in.next(), key, preparedStatement, connection);
                }
                default -> System.out.println("Неверно выбран столбец.");
            }
        }
        else System.out.println("Неверно введён id.");
    }
}
