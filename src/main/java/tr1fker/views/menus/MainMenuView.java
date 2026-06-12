package tr1fker.views.menus;

import tr1fker.interfaces.controllers.menus.IMenu;

public class MainMenuView implements IMenu {
    public void showMenu(){
        System.out.println("""
+--------+
|  Меню  |
+--------+
|1. Слова|
+--------+
|2. Выйти|
+--------+""");
    }
}
