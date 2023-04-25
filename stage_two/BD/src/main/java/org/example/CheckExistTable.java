package org.example;

import java.sql.SQLException;
import java.sql.Statement;

@FunctionalInterface
public interface CheckExistTable {
    void TableExistsSQL(Statement statement) throws SQLException;
}
