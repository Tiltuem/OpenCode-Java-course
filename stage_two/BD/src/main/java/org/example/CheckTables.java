package org.example;
import java.sql.*;


public class CheckTables {
    public static void tableExistsSQL(Statement statement) throws SQLException {
        statement.execute("CREATE table IF NOT EXISTS Locality(" +
                "id_locality SERIAL primary key," +
                "name_locality varchar(255)," +
                "square float," +
                "type_locality varchar(255)," +
                "people float," +
                "founding_date varchar(255))");
        statement.execute("CREATE table IF NOT EXISTS Streets(" +
                "id_street SERIAL primary key," +
                "name_street varchar(255)," +
                "type_street varchar(255)," +
                "id_loc INTEGER REFERENCES Locality(id_locality) ON DELETE CASCADE)");


    }
}
