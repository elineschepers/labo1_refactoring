package domain;

public interface Observer {
    void update(int spelersnummer,
                int aantalBeurtenGespeeld,
                int vorigeResultaat,
                int huidigeResultaat,
                int totaalResultaat);
}
