package domain;

import java.util.TreeSet;

public class DeletedState implements State{
    PartyMaterialRental partyMaterialRental;

    public DeletedState(PartyMaterialRental partyMaterialRental)
    {
        this.partyMaterialRental = partyMaterialRental;
    }
    @Override
    public void verwijderArtikel(PartyArtikel artikel) {

        System.out.println("Dit artikel is al verwijderd");
    }

    @Override
    public void leenArtikel(PartyArtikel artikel) {

        System.out.println("niet mogelijk");
    }

    @Override
    public void brengArtikelTerug(PartyArtikel artikel) {

        System.out.println("onmogelijk");
    }

    @Override
    public void herstelArtikel(PartyArtikel artikel) {

        partyMaterialRental.setState(partyMaterialRental.getLoanableState());

    }


}
