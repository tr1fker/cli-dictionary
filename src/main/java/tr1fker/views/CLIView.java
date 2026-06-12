package tr1fker.views;

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
}
