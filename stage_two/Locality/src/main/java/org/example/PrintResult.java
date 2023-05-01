package org.example;

import java.sql.*;

public class PrintResult {
    public static void printAllTables(Statement statement) {
        try (ResultSet rs = statement.executeQuery("SELECT name_locality, type_locality, square, people, founding_date, name_street, type_street  FROM locality, streets  WHERE id_locality=id_loc")) {
            tableTemplate(rs);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void tableTemplate(ResultSet rs) throws SQLException {
        if (rs.next()) {
            System.out.printf(
                    "| %1$20s | %2$12s | %3$7s | %4$10s | %5$15s | %6$20s | %7$12s |\n",
                    "Наименование пункта", "Тип пункта", "Площадь", "Население", "Дата основания", "Наименование улицы", "Тип улицы");
            do {
                System.out.printf("| %1$20s | %2$12s | %3$7s | %4$10s | %5$15s | %6$20s | %7$12s |\n",
                        rs.getString("name_locality"), rs.getString("type_locality"), rs.getString("square"), rs.getString("people"), rs.getString("founding_date"), rs.getString("name_street"), rs.getString("type_street"));
            } while (rs.next());
        }
        else System.out.println("Недостаточно информации.");
    }
    public static void printLocalityInformation(String name, PreparedStatement preparedStatement, Connection connection) {
        try {
            preparedStatement = connection.prepareStatement("SELECT name_locality, type_locality, square, people, founding_date, name_street, type_street  FROM locality, streets  WHERE name_locality = (?) AND id_locality=id_loc");
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            tableTemplate(rs);
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printTableLocality(Statement statement) {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM Locality")) {
            System.out.printf(
                    "%1$11s | %2$13s | %3$7s | %4$7s | %5$10s |%6$15s |\n",
                    "id_locality", "Наименование", "Тип", "Площадь", "Население", "Дата основания");
            while (rs.next()) {
                System.out.printf("%1$11s | %2$13s | %3$7s | %4$7s | %5$10s |%6$15s |\n",
                        rs.getString("id_locality"), rs.getString("name_locality"), rs.getString("type_locality"), rs.getString("square"), rs.getString("people"), rs.getString("founding_date"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printTableStreets(Statement statement) {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM streets")) {
            System.out.printf(
                    "%1$11s | %2$13s | %3$7s | %4$7s |\n",
                    "id_street", "Наименование", "Тип", "id_loc");
            while (rs.next()) {
                System.out.printf( "%1$11s | %2$13s | %3$7s | %4$7s |\n",
                        rs.getString("id_street"), rs.getString("name_street"), rs.getString("type_street"), rs.getString("id_loc"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

