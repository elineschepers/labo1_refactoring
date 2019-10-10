package domain;

import java.util.TreeSet;

public class DamagedState implements State {

    PartyMaterialRental partyMaterialRental;

    public DamagedState(PartyMaterialRental rental)
    {
        partyMaterialRental=rental;
    }
    @Override
    public void verwijderArtikel(PartyArtikel artikel) {
        System.out.println("artikel is verwijderd");
        partyMaterialRental.setState(partyMaterialRental.getDeletedState());
        partyMaterialRental.verwijderArtikel(artikel);
    }

    @Override
    public void leenArtikel(PartyArtikel artikel) {

        throw new IllegalArgumentException("artikel kan niet worden uitgeleend aangezien deze beschadigd is, maak hem eerst.");
    }

    @Override
    public void brengArtikelTerug(PartyArtikel artikel) {

        System.out.println("bedankt voor het teruggeven van het artikel.");
    }

    @Override
    public void herstelArtikel(PartyArtikel artikel) {

        partyMaterialRental.setState(partyMaterialRental.getLoanableState());
    }

}
