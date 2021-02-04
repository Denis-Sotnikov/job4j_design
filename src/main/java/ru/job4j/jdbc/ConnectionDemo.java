package ru.job4j.jdbc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    private final Properties prs = new Properties();

    public String getValue(String key) {
        return prs.getProperty(key);
    }

    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException,
            SQLException, IOException {
//        Path w  = Files.createFile(Paths.get(""));
//        Path q;
//        q = Paths.get("");
//        q = Files.createFile(Paths.get(""));
//        File file = new File("");
//        file.listFiles();
        Class.forName("org.postgresql.Driver");
        ConnectionDemo demo = new ConnectionDemo();
        try (FileInputStream io = new FileInputStream(new File("./app.properties"))) {
            demo.load(io);
            System.out.println(demo.getValue("jdbc.url"));
            try (Connection connection = DriverManager.getConnection(
                    demo.getValue("url"), demo.getValue("login"), demo.getValue("password"))) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
            ObjectInputStream stream;
        }
    }
}