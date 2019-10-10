package view;

import domain.PartyArtikel;
import javax.swing.*;
import java.util.ArrayList;

public class ContextState {

    private ArrayList<PartyArtikel> artikels;

    public ContextState() {
        artikels = new ArrayList<>();
    }

    public static void main(String[] args) {
        ContextState c = new ContextState();

        int choice = -1;
        while (choice != 0) {
            String keuze = JOptionPane.showInputDialog("1. leen artikel \n2. breng artikel terug\n3. maak artikel\n\n0. Quit");
            choice = Integer.parseInt(keuze);
            if (choice == 1) {
                loanArticle(c);
            } else if (choice == 2) {
                returnArticle(c);
            } else if (choice == 3) {
                createArticle(c);
            }
        }
    }

    public static void loanArticle(ContextState c) {

    }

    public static void returnArticle(ContextState c) {

    }

    public static void createArticle(ContextState c) {
        String naam = JOptionPane.showInputDialog("Naam?");
        double prijs = Double.parseDouble(JOptionPane.showInputDialog("Prijs?"));

        PartyArtikel artikel = new PartyArtikel(naam, prijs);

        c.artikels.add(artikel);
    }
}