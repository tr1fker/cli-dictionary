package tr1fker.views;

import tr1fker.models.ELanguage;
import tr1fker.models.Word;

import java.util.List;

public class CLIView {

    public void printInputNumber(){
        System.out.print("Введите номер:");
    }

    public void printSuccessExit(){
        System.out.println("Успешный выход!");
    }

    public void printNewName() {
        System.out.print("Введите новое слово:");
    }

    public void printSuccessWordAdded(){
        System.out.println("Слово успешно добавлено!");
    }

    public void printErrorWordAdded(){
        System.out.println("Не удалось добавить слово!");
    }

    public void printAllWords(List<Word> words){
        int num = 1;
        for (Word word : words) {
            System.out.printf("%2d: %s\n", num++, word.getName());
        }
    }

    public void printTypeLang(ELanguage language){
        System.out.println("Тип языка:" + language);
    }

    public void printLangsWithoutFirst(ELanguage[] langs){
        for (int num = 1; num < langs.length; ++num){
            System.out.printf("%2d: %s\n", num, langs[num]);
        }
    }

    public void printLangSuccessSelected(){
        System.out.println("Язык успешно выбран!");
    }

    public void printNameForTranslation(){
        System.out.print("Введите слово для перевода:");
    }
}
