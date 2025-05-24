package br.com.unisc.configs;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Dotenv dotenv = Dotenv.load();
    private static String url = dotenv.get("DB_URL");
    private static String user = dotenv.get("DB_USER");
    private static String password = dotenv.get("DB_PASSWORD");
    private static String driver = dotenv.get("DB_DRIVER");


    private Connection connection;

    public DBConnection () {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password );
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public Connection getConnection(){
        return this.connection;
    }
}
