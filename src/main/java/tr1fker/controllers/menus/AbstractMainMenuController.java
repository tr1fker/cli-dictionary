package tr1fker.controllers.menus;

public abstract class AbstractMainMenuController {

    protected boolean isRunning;

    public AbstractMainMenuController(){
        this.isRunning = false;
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
