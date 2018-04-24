package model.database.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
    private final static Logger LOGGER = Logger.getLogger(DatabaseConnection.class);

    private final static String RESOURCE_NAME = "database";
    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null){
            setUpConnection();
        }
        return connection;
    }

    private static void setUpConnection(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            LOGGER.error("Can't connect to database", e);
        }
    }
}
