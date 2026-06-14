package tr1fker.controllers;

import tr1fker.exceptions.LimitException;
import tr1fker.interfaces.controllers.menus.IMenu;
import tr1fker.models.ELanguage;
import tr1fker.views.CLIView;
import java.util.Scanner;

public class InputController {
    private static final Scanner scanner;

    static{
        scanner = new Scanner(System.in);
    }

    public int inputIntegerWithMenu(IMenu menu, CLIView cliView, ELanguage language){
        while(true){
            menu.showMenu();
            cliView.printTypeLang(language);
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

    public int inputIntegerWithMenu(ELanguage[] langs, CLIView cliView, int limit){
        while(true){
            cliView.printLangsWithoutFirst(langs);
            cliView.printInputNumber();
            int number;
            try {
                String line = scanner.nextLine();
                number = Integer.parseInt(line);
                if (number > limit || number <= 0) {
                    throw new LimitException();
                }
                return number;
            }catch(LimitException e){
                System.out.println("Некорректная опция!");
            }catch(Exception e){
                System.out.println("Некорректное значение!\nПопробуйте ещё раз!");
            }
        }
    }

    public String inputNewName(CLIView cliView){
        while (true){
            cliView.printNewName();
            String line = scanner.nextLine();
            return line;
        }
    }

    public String inputEnNameForRu(CLIView cliView){
        while (true){
            cliView.printNameForTranslation();
            String line = scanner.nextLine();
            return line;
        }
    }
}
