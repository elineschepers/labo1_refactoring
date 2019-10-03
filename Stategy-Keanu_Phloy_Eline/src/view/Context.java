package view;

import domain.Caesar;
import domain.Mirroring;

import javax.swing.*;

public class Context {

    public static void main(String[] args) {
        Caesar c = new Caesar();
        Mirroring m = new Mirroring();
        String keuze = JOptionPane.showInputDialog("1. Encode\n2. Decode\n\n0. Quit");
        String text = JOptionPane.showInputDialog("Tekst?").toLowerCase();

        String optie = "1. Caesar\n\n2. Mirroring\n\n0. Quit";

        if (keuze.equals("1")) {
            int choice = -1;
            while (choice != 0) {
                String choiceString = JOptionPane.showInputDialog(optie);
                if( choiceString != null) {
                    choice = Integer.parseInt(choiceString);
                }
                if (choice == 1) {
                    int number = Integer.parseInt(JOptionPane.showInputDialog("Nummer?"));
                    c.setNumber(number);
                    String result = c.encode(text);
                    JOptionPane.showMessageDialog(null, result);
                }
                if (choice == 2) {

                        String result = m.encode(text);
                        JOptionPane.showMessageDialog(null, result);
                    }

            }
            }
         else if (keuze.equals("2")) {
            int choice = -1;
            while (choice != 0) {
                String choiceString = JOptionPane.showInputDialog(optie);
                choice = Integer.parseInt(choiceString);
                if (choice == 1) {
                    int number = Integer.parseInt(JOptionPane.showInputDialog("Nummer?"));
                    c.setNumber(number);
                    String result = c.decode(text);
                    JOptionPane.showMessageDialog(null, result);
                }
                if (choice == 2) {

                    String result = m.decode(text);
                    JOptionPane.showMessageDialog(null, result);
                }
            }
        }
    }
}
