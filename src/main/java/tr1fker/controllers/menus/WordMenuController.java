package tr1fker.controllers.menus;

import tr1fker.controllers.InputController;
import tr1fker.models.ELanguage;
import tr1fker.repositories.WordsRepository;
import tr1fker.views.CLIView;
import tr1fker.views.menus.WordsMenuView;

public class WordMenuController extends AbstractMainMenuController {
    private CLIView cliView;
    private WordsMenuView wordsMenuView;
    private InputController inputController;
    private WordsRepository wordsRepository;

    public WordMenuController(CLIView cliView, InputController inputController, ELanguage language){
        this.cliView = cliView;
        this.wordsMenuView = new WordsMenuView();
        this.inputController = inputController;
        this.wordsRepository = new WordsRepository(cliView, inputController);
        this.language = language;

        this.isRunning = false;
    }

    protected void runMenu(){
        int option = this.inputController.inputIntegerWithMenu(this.wordsMenuView, this.cliView, this.language);

        switch(option){
            case 1:
                this.wordsRepository.createWord(this.language);
                break;
            case 2:
                this.wordsRepository.showAllWords(this.language);
                break;
            case 3:
                this.stop();
                break;
        }
    }
}
