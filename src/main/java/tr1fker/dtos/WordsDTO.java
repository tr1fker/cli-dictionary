package tr1fker.dtos;

import tr1fker.connections.DatabaseConnection;
import tr1fker.models.Word;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Word> readWords(){
        String sql = "SELECT * FROM words;";
        List<Word> words = null;
        try{
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            words = new ArrayList<>();
            while(rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");

                words.add(new Word(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return words;
    }
}
