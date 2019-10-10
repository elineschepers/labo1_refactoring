package domain;

import java.util.TreeSet;

public interface State {

    void verwijderArtikel(PartyArtikel artikel);
    void leenArtikel(PartyArtikel artikel);
    void brengArtikelTerug(PartyArtikel artikel);
    void herstelArtikel(PartyArtikel artikel);



}
