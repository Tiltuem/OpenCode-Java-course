package org.example;

import java.sql.*;
import java.util.Scanner;

public class Locality {
    public static int getIdLocality(Connection connection, int key) throws SQLException {
        Statement statement = connection.createStatement();
        try (ResultSet rs = statement.executeQuery("select id_locality from Locality")) {
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
        preparedStatement = connection.prepareStatement("UPDATE locality SET name_locality = (?) WHERE id_locality = (?)");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, key);
        preparedStatement.execute();
        System.out.println("Запись изменена.");
    }
    public static void setSquare(float square, int key, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE locality SET square = (?) WHERE id_locality = (?)");
        preparedStatement.setFloat(1, square);
        preparedStatement.setInt(2, key);
        preparedStatement.execute();
    }
    public static void setType(String type, int key, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE locality SET type_locality = (?) WHERE id_locality = (?)");
        preparedStatement.setString(1, type);
        preparedStatement.setInt(2, key);
        preparedStatement.execute();
    }
    public static void setPeople(float people, int key, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE locality SET people = (?) WHERE id_locality = (?)");
        preparedStatement.setFloat(1, people);
        preparedStatement.setInt(2, key);
        preparedStatement.execute();
    }
    public static void setFoundingDate(String foundingDate, int key, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE locality SET founding_date = (?) WHERE id_locality = (?)");
        preparedStatement.setString(1, foundingDate);
        preparedStatement.setInt(2, key);
        preparedStatement.execute();
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

        preparedStatement = connection.prepareStatement("INSERT INTO Locality(name_locality, square, type_locality, people, founding_date)VALUES (?,?,?,?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setFloat(2, square);
        preparedStatement.setString(3, type);
        preparedStatement.setFloat(4, people);
        preparedStatement.setString(5, date);
        preparedStatement.execute();
        System.out.println("Запись добавлена.");
    }
    public static void deleteLocality(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id пункта, который хотите удалить: ");
        int key = in.nextInt();

        if (getIdLocality(connection, key)!=-1) {
            preparedStatement = connection.prepareStatement("DELETE FROM Locality WHERE id_locality = (?);");
            preparedStatement.setInt(1, key);
            preparedStatement.execute();
            System.out.println("Запись удалена.");
        }
        else System.out.println("Неверно введён id.");
    }
    public static void modifyLocality(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id населенного пункта, который хотите изменить: ");
        int key = in.nextInt();
        if (getIdLocality(connection, key) == key) {
            System.out.println("Введите название столбца, значение которого хотите изменить: ");
            String column = in.next();
            switch (column) {
                case "Наименование" -> {
                    System.out.println("Введите новое название населенного пункта: ");
                    setName(in.next(), key, preparedStatement, connection);
                }
                case "Площадь" -> {
                    System.out.println("Введите новое значение плошади: ");
                    setSquare(in.nextFloat(), key, preparedStatement, connection);
                }
                case "Тип" -> {
                    System.out.println("Введите новое тип населенного пункта: ");
                    setType(in.next(), key, preparedStatement, connection);
                }
                case "Население" -> {
                    System.out.println("Введите новое количество населения: ");
                    setPeople(in.nextFloat(), key, preparedStatement, connection);
                }
                case "Дата основания" -> {
                    System.out.println("Введите новую дату создания: ");
                    setFoundingDate(in.next(), key,preparedStatement, connection);
                }
                default -> System.out.println("Неверно выбран столбец.");
            }
        }
        else System.out.println("Неверно введён id.");
    }
   }



