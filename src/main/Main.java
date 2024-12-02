package main;

import menu.MenuManager;
import utils.ScreenUtils;

public class Main {
    public static void main(String[] args) {
        
        ScreenUtils.clearScreen();
        
        MenuManager menu = new MenuManager();
        menu.displayMenu();
    }
}
