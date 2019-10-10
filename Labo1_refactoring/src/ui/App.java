package ui;

import domain.Game;
import domain.Product;
import domain.Shop;
import domain.ShopRefactored;

import javax.swing.*;

public class App {


    public static void main(String[] args) {

        ShopRefactored s1 = new ShopRefactored("winkel");
        Product p1 = new Game("CD","a1");
        Shop shop = new Shop();

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                s1.addProduct(p1);
            } else if (choice == 2) {
                s1.showProduct(p1);
            } else if (choice == 3){
                s1.showPrice(p1,4);
            }
        }
    }
}
