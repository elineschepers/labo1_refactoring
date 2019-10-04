package domain;

import java.util.TreeSet;

public class LoanedState implements State {
    PartyMaterialRental partyMaterialRental;
    public LoanedState(PartyMaterialRental partyMaterialRental)
    {
        this.partyMaterialRental=partyMaterialRental;
    }
    @Override
    public void verwijderArtikel(PartyArtikel artikel) {

        System.out.println("onmogelijk,artikel is nog uitgeleend");
    }

    @Override
    public void leenArtikel(PartyArtikel artikel) {

        System.out.println("artikel is reeds uitgeleend");
    }

    @Override
    public void brengArtikelTerug(PartyArtikel artikel) {

        if(partyMaterialRental.getDamagedState()!=null) {
            partyMaterialRental.setState(partyMaterialRental.getLoanableState());
        }else
        {
            System.out.println("u krijgt een boete van "+artikel.getPrijs()/3+" euro.");
            partyMaterialRental.setState(partyMaterialRental.getDeletedState());

        }

    }

    @Override
    public void herstelArtikel(PartyArtikel artikel) {

        System.out.println("Dit artikel is niet mogelijk voor herstel aangezien deze is uitgeleend");
    }


}
