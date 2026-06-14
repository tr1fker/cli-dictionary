package tr1fker.controllers.menus;

import tr1fker.models.ELanguage;

public abstract class AbstractMainMenuController {

    protected boolean isRunning;
    protected ELanguage language;

    public AbstractMainMenuController(){
        this.isRunning = false;
        this.language = ELanguage.no;
    }

    public void run(){
        this.isRunning = true;
        while(this.isRunning){
            this.runMenu();
        }
    }

    abstract protected void runMenu();

    public void stop(){
        this.isRunning = false;
    }
}
