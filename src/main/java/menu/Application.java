package menu;

import menu.Controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.run();
    }
}
