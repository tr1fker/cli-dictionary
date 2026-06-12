package tr1fker.repositories;

import tr1fker.controllers.InputController;
import tr1fker.dtos.WordsDTO;
import tr1fker.models.Word;
import tr1fker.views.CLIView;

import java.util.List;

public class WordsRepository {
    private WordsDTO wordsDTO;
    private CLIView cliView;
    private InputController inputController;

    public WordsRepository(CLIView cliView, InputController inputController) {
        wordsDTO = new WordsDTO();
        this.cliView = cliView;
        this.inputController = inputController;
    }


    public void createWord(){
        String newName = this.inputController.inputNewName(cliView);
        int rowsAffected = this.wordsDTO.createWord(newName);
        if (rowsAffected > 0){
            cliView.printSuccessWordAdded();
        }else{
            cliView.printErrorWordAdded();
        }
    }

    public void showAllWords(){
        List<Word> words = this.wordsDTO.readWords();
        cliView.printAllWords(words);
    }
}
