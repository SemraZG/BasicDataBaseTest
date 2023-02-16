package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    private static Connection connection;
    private static Statement statement;
    //connection
    public static Connection createToConnection(String hostName, String databaseName, String username, String password){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://"+hostName+":5432/"+databaseName, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Connection is success!");
        return connection;
    }
    //statement
    public static Statement createStatement() {

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Statement created!");
        return statement;

    }
    //connection ve statement kapatma
    public static void closeConnectionAndStatement () {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (connection.isClosed() && statement.isClosed()) {
                System.out.println("Connection and statement closed!");
            } else {
                System.out.println("Connection and statement not closed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
