package sample;

import java.sql.*;

public class DatabaseConnection {


    private Connection databaseLink;

    public Connection getBDConnection() {
        String databaseName = "test";
        String databaseUser = "root";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, "thanh8281");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }

}
    

