package tr1fker.controllers.menus;

import tr1fker.controllers.InputController;
import tr1fker.views.CLIView;
import tr1fker.views.menus.WordsMenuView;

public class WordMenuController extends AbstractMainMenuController {
    private CLIView cliView;
    private WordsMenuView wordsMenuView;
    private InputController inputController;

    public WordMenuController(CLIView cliView, InputController inputController){
        this.cliView = cliView;
        this.wordsMenuView = new WordsMenuView();
        this.inputController = inputController;

        this.isRunning = false;
    }

    protected void runMenu(){
        int option = this.inputController.inputIntegerWithMenu(this.wordsMenuView, this.cliView);

        switch(option){
            case 1:

                break;
            case 2:
                this.stop();
                break;
        }
    }
}
