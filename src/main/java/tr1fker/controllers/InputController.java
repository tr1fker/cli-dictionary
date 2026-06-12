package tr1fker.controllers;

import tr1fker.interfaces.controllers.menus.IMenu;
import tr1fker.views.CLIView;
import java.util.Scanner;

public class InputController {
    private static final Scanner scanner;

    static{
        scanner = new Scanner(System.in);
    }

    public int inputIntegerWithMenu(IMenu menu, CLIView cliView){
        while(true){
            menu.showMenu();
            cliView.printInputNumber();
            int number;
            try{
                String line = scanner.nextLine();
                number = Integer.parseInt(line);
                return number;
            }catch(Exception e){
                System.out.println("Некорректное значение!\nПопробуйте ещё раз!");
            }
        }
    }
}
