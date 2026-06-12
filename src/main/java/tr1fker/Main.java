package tr1fker;

import tr1fker.connections.DatabaseConnection;
import tr1fker.controllers.menus.MainMenuController;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection postgreSQLConnection = DatabaseConnection.getConnection();

        if (postgreSQLConnection == null) {
            System.out.println("Проблема подключения к PostgreSQL!");
            return;
        }

        System.out.println("Успешное подключение к БД!");

        MainMenuController mainController = new MainMenuController();
        mainController.run();
        System.out.println("Программа успешно завершена!");
    }
}