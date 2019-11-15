package domain;

import java.util.ArrayList;

public class Player implements Observable {
    private int spelersnummer;
    private int aantalBeurtenGespeeld;
    private int vorigeBeurt;
    private int huidigeBeurt;
    private int totaalResultaat;
    private ArrayList<Observer> observers;
    private String naam;

    public Player(String naam, int spelersnummer) {
        setSpelersnummer(spelersnummer);
        setAantalBeurtenGespeeld(aantalBeurtenGespeeld);
        setVorigeBeurt(vorigeBeurt);
        setHuidigeBeurt(huidigeBeurt);
        setTotaalResultaat(totaalResultaat);
        observers = new ArrayList<Observer>();
    }

    public Player() {

    }

    //Getters
    public int getSpelersnummer() { return spelersnummer; }

    public int getAantalBeurtenGespeeld() { return aantalBeurtenGespeeld; }

    public int getVorigeBeurt() { return vorigeBeurt; }

    public int getHuidigeBeurt() { return huidigeBeurt; }

    public int getTotaalResultaat() { return totaalResultaat; }

    public ArrayList<Observer> getObservers() { return observers; }

    //Setters
    public void setSpelersnummer(int spelersnummer) {
        if (spelersnummer > 3 || spelersnummer < 0) {
            throw new IllegalArgumentException("Spelersnr fout!");
        }
        this.spelersnummer = spelersnummer;
    }

    public void setAantalBeurtenGespeeld(int aantalBeurtenGespeeld) {
        if (aantalBeurtenGespeeld > 3) {
            throw new IllegalArgumentException("Te veel rondes!");
        }
        this.aantalBeurtenGespeeld = aantalBeurtenGespeeld;
    }

    public void setVorigeBeurt(int vorigeBeurt) { this.vorigeBeurt = vorigeBeurt; }

    public void setHuidigeBeurt(int huidigeBeurt) { this.huidigeBeurt = huidigeBeurt; }

    public void setTotaalResultaat(int totaalResultaat) { this.totaalResultaat = totaalResultaat; }

    //Observer methodes
    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(spelersnummer,
                            aantalBeurtenGespeeld,
                            vorigeBeurt,
                            huidigeBeurt,
                            totaalResultaat);
        }
    }

    //Andere methodes
    public void heeftGespeeld() {
        notifyObservers();
    }

}
