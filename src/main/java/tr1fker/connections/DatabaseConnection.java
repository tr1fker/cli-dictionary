package tr1fker.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/dictionary";
    private static final String USER = "postgres";
    private static final String PASSWORD = "51575157";

    private static Connection connection;

    static{
        connection = null;
    }

    public static Connection getConnection(){
        if (connection != null) return connection;

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось найти Driver postgreSQL");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Не удалось подключится к БД");
            e.printStackTrace();
        }

        return connection;
    }
}
