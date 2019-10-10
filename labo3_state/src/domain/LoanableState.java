package domain;

import java.util.TreeSet;

public class LoanableState implements State {
    PartyMaterialRental partyMaterialRental;

    public LoanableState(PartyMaterialRental partyMaterialRental)
    {
        this.partyMaterialRental=partyMaterialRental;
    }
    @Override
    public void verwijderArtikel(PartyArtikel artikel)
    {
        partyMaterialRental.setState(partyMaterialRental.getDeletedState());
        partyMaterialRental.verwijderArtikel(artikel);
    }

    @Override
    public void leenArtikel(PartyArtikel artikel) {
        System.out.println("Uw betaald hiervoor "+artikel.getPrijs()/5+" euro");
        partyMaterialRental.setState(partyMaterialRental.getLoanedState());

    }

    @Override
    public void brengArtikelTerug(PartyArtikel artikel) {

        System.out.println("dit artikel was niet uitgeleend");
    }

    @Override
    public void herstelArtikel(PartyArtikel artikel) {
        System.out.println("dit artikel is niet toe aan herstel");


    }


}
