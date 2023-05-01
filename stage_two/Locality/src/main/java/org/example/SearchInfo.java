package org.example;

import java.sql.*;
import java.util.Scanner;

public class SearchInfo {
    public static void searchByName(String name, String column, String nameTable, Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT "+column+" FROM "+nameTable+" WHERE "+column+" LIKE '%"+name+"%'");
        if (rs.next()) {
            System.out.println("Результат поиска: ");
            do {
                System.out.println(rs.getString(column));
            } while (rs.next());
        }
        else System.out.println("Информация отсутствует.");
        rs.close();
    }
    public static void searchBySquareOrPeople(float value, String column, Statement statement) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите знак(>,<,=,!=,<=,>=): ");

        ResultSet rs = statement.executeQuery("SELECT name_locality, "+column+" FROM locality WHERE "+column+in.next()+value);
        if (rs.next()) {
            System.out.println("Результат поиска: ");
            do {
                System.out.printf("%s: %.2f;\n", rs.getString("name_locality"), rs.getFloat(column));
            } while (rs.next());
        }
        else System.out.println("Информация отсутствует.");
        rs.close();

    }
    public static void searchByDate(String value, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT name_locality, founding_date FROM locality WHERE founding_date = (?)");
        preparedStatement.setString(1, value);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            System.out.println("Результат поиска: ");
            do {
                System.out.printf("%s: дата основания - %s;\n", rs.getString("name_locality"), rs.getString("founding_date"));
            } while (rs.next());
        }
        else System.out.println("Информация отсутствует.");
        rs.close();
    }
    public static void searchByTypeStreet(String name, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT name_locality, type_street FROM locality, streets WHERE id_locality = id_loc AND type_street = (?)");
        preparedStatement.setString(1, name);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            System.out.println("Результат поиска: ");
            do {
                System.out.printf("%s: тип улицы - %s;\n", rs.getString("name_locality"), rs.getString("type_street"));
            } while (rs.next());
        }
        else System.out.println("Информация отсутствует.");
        rs.close();
    }
    public static void searchAllLocalityWithStreet(String name, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT name_locality, name_street FROM locality, streets WHERE id_locality = id_loc AND name_street LIKE (?)");
        preparedStatement.setString(1, "%"+name+"%");
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            System.out.println("Результат поиска: ");
            System.out.printf("Улица: %s\nНаселенный(ые) пункт(ы), в котором есть данная улица: ",name);
           do {
                System.out.print(rs.getString("name_locality")+"\n");
            }  while (rs.next());
        }
        else System.out.println("Информация отсутствует.");
        rs.close();
    }
    public static void searchAllStreetsLocality(String name, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT name_street FROM locality, streets WHERE id_locality = id_loc AND name_locality = (?)");
        preparedStatement.setString(1, name);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            System.out.println("Результат поиска: ");
            do {
                System.out.print(rs.getString("name_street")+"\n");
            }  while (rs.next());
        }
        else System.out.println("Информация отсутствует.");
        rs.close();
    }
}

