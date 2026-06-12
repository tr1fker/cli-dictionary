package tr1fker.views;

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
}
