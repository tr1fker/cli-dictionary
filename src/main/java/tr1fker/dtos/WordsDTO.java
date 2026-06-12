package tr1fker.dtos;

import tr1fker.connections.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WordsDTO {
    private Connection connection;

    public WordsDTO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public int createWord(String name){
        String sql = "INSERT INTO words (name) VALUES (?);";

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, name);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
