package tr1fker.repositories;

import tr1fker.connections.DatabaseConnection;
import tr1fker.controllers.InputController;
import tr1fker.models.Word;
import tr1fker.views.CLIView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordsRepository {
    private Connection connection;
    private CLIView cliView;
    private InputController inputController;

    public WordsRepository(CLIView cliView, InputController inputController) {
        this.connection = DatabaseConnection.getConnection();
        this.cliView = cliView;
        this.inputController = inputController;
    }


    public void createWord(){
        String newName = this.inputController.inputNewName(cliView);
        String sql = "INSERT INTO words (name) VALUES (?);";

        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, newName);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0){
                cliView.printSuccessWordAdded();
            }else{
                cliView.printErrorWordAdded();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllWords(){
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
        cliView.printAllWords(words);
    }
}
