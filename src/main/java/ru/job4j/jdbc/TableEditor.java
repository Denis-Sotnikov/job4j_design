package ru.job4j.jdbc;

import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.Comparator;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
                connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("login"),
                    properties.getProperty("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTable(String tableName) throws SQLException {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists %s();",
                        tableName
                );
                statement.execute(sql);
            }
    }

    public void dropTable(String tableName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "drop table if exists %s;",
                    tableName
            );
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "ALTER TABLE %s ADD COLUMN if not exists %s %s;",
                    tableName, columnName, type
            );
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "ALTER TABLE %s DROP COLUMN if exists %s;",
                    tableName, columnName
            );
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "ALTER TABLE %s RENAME COLUMN %s TO %s;",
                    tableName, columnName, newColumnName
            );
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Integer w = 5;
        Integer was = 10;
        System.out.println(w.compareTo(was));
//        File file = new File("app.properties");
//        Properties properties = new Properties();
//        properties.load(new FileReader(file));
//        TableEditor tableEditor = new TableEditor(properties);
        //tableEditor.createTable("just_do_it");

        //tableEditor.dropTable("just_do_it");
        //tableEditor.addColumn("just_do_it", "For_first", "varchar(255)");
        //tableEditor.dropColumn("just_do_it", "For_first");
        //tableEditor.renameColumn("just_do_it", "For_first", "for_second");

//        try (Connection connection = getConnection()) {
//            try (Statement statement = connection.createStatement()) {
//                String sql = String.format(
//                        "create table if not exists demo_table(%s, %s);",
//                        "id serial primary key",
//                        "name varchar(255)"
//                );
//                statement.execute(sql);
                //System.out.println(tableEditor.getScheme("just_do_it"));
            }
        //}
    }
