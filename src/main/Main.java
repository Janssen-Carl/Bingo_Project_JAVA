package main;

//import menu.MenuManager;
//import utils.ScreenUtils;

import models.Card;
import models.Computer;
import models.Player;


public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();
        Card card = new Card(3);
        Card card1 = new Card(3);
        
        player.setCards(card.getCards());
        computer.setCards(card1.getCards());
        
       
        
        
        
//        ScreenUtils.clearScreen();
//
//        MenuManager menu = new MenuManager();
//        menu.displayMenu();
    
    }
}
