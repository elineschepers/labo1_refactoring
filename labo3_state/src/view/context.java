package view;

import domain.PartyArtikel;
import domain.PartyMaterialRental;

import javax.swing.*;

public class context {
    public static  void main(String[] args) {


        PartyMaterialRental rental=new PartyMaterialRental();

        String keuze = JOptionPane.showInputDialog("1. leen artikel \n2. breng artikel terug\n3. maak artikel\n\n0. Quit");
        String text = JOptionPane.showInputDialog("Tekst?").toLowerCase();


        //String choiceString = JOptionPane.showInputDialog(optie);

        if (keuze.equals("1")) {// encode

        }
    }
}