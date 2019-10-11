package view;

import domain.PartyArtikel;
import javax.swing.*;
import java.util.ArrayList;

public class ContextState {

    private ArrayList<PartyArtikel> artikels;
    private ArrayList<PartyArtikel> uitgeleend;
    private ArrayList<PartyArtikel> aanwezig;

    public ContextState() {
        artikels = new ArrayList<>();
        uitgeleend = new ArrayList<>();
        aanwezig = artikels;
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
        String leenbaarNaam = JOptionPane.showInputDialog("Welk van volgende artikels wenst U te lenen?" + c.aanwezig);

        for (PartyArtikel a: c.artikels) {
            if (a.getName().equals(leenbaarNaam) && !c.uitgeleend.contains(a)) {
                c.uitgeleend.add(a);
            }
        }

        if (c.aanwezig.size() != 0) {
            for (PartyArtikel l : c.uitgeleend) {
                if (c.aanwezig.contains(l)) {
                    c.aanwezig.remove(l);
                }
            }
        }
    }

    public static void returnArticle(ContextState c) {
        String terugbrengingNaam = JOptionPane.showInputDialog("Welk van volgende artikels brengt U terug?" + c.uitgeleend);

        for (PartyArtikel a: c.artikels) {
            if (a.getName().equals(terugbrengingNaam) && c.uitgeleend.contains(a)) {
                c.aanwezig.add(a);
            }
        }

        if (c.uitgeleend.size() != 0) {
            for (PartyArtikel l : c.aanwezig) {
                if (c.uitgeleend.contains(l)) {
                    c.uitgeleend.remove(l);
                }
            }
        }
    }

    public static void createArticle(ContextState c) {
        String naam = JOptionPane.showInputDialog("Naam?");
        double prijs = Double.parseDouble(JOptionPane.showInputDialog("Prijs?"));

        PartyArtikel artikel = new PartyArtikel(naam, prijs);

        c.artikels.add(artikel);
    }
}