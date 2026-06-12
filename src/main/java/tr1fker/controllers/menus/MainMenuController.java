package tr1fker.controllers.menus;

import tr1fker.controllers.InputController;
import tr1fker.views.CLIView;
import tr1fker.views.menus.MainMenuView;

public class MainMenuController extends AbstractMainMenuController {
    private CLIView cliView;
    private MainMenuView mainMenuView;
    private InputController inputController;

    public MainMenuController(){
        this.cliView = new CLIView();
        this.mainMenuView = new MainMenuView();
        this.inputController = new InputController();

        this.isRunning = false;
    }

    protected void runMenu(){
        int option = this.inputController.inputIntegerWithMenu(this.mainMenuView, this.cliView);

        switch(option){
            case 1:
                new WordMenuController(this.cliView, this.inputController).run();
                break;
            case 2:
                this.stop();
                this.cliView.printSuccessExit();
                break;
        }
    }
}
