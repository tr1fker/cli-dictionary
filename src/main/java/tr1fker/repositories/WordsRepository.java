package tr1fker.repositories;

import tr1fker.connections.DatabaseConnection;
import tr1fker.controllers.InputController;
import tr1fker.models.ELanguage;
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


    public void createWord(ELanguage lang){
        String newName = this.inputController.inputNewName(cliView);
        String sql;
        String forName = null;
        Word word = null;
        if (lang == ELanguage.ru){
            forName = this.inputController.inputEnNameForRu(cliView);
            word = this.getWord(forName);
            System.out.println(word);
            sql = "INSERT INTO ru_words (name, id_en_word) VALUES (?, ?);";
        }else{
            sql = "INSERT INTO " + (lang.toString()) + "_words (name) VALUES (?);";
        }


        try{
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, newName);
            if (lang == ELanguage.ru){
                ps.setLong(2, (int)(word.getId()));
            }
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

    public Word getWord(String name){
        String sql = "SELECT * FROM en_words WHERE name = '" + name + "';";
        try{
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()){
                long id = rs.getLong("id");
                String nameWord = rs.getString("name");

                return new Word(id, nameWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showAllWords(ELanguage lang){
        String sql = "SELECT * FROM " + lang + "_words;";
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
