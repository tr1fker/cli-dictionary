package tr1fker.views.menus;

import tr1fker.interfaces.controllers.menus.IMenu;

public class WordsMenuView implements IMenu {
    public void showMenu(){
        System.out.println("""
+----------------------+
|     Раздел:Слова     |
+----------------------+
|1. Добавить слово     |
|2. Просмотр всех слов |
+----------------------+
|3. Вернуться          |
+----------------------+""");
    }
}
