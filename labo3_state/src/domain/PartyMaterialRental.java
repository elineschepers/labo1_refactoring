package domain;

import java.util.TreeSet;

public class PartyMaterialRental {

    private TreeSet<PartyArtikel> artikelen;


    public PartyMaterialRental()
    {
        artikelen=new TreeSet<>();
    }

    public void addArtikel(PartyArtikel artikel)
    {
        if(artikel!=null)
        {
            artikelen.add(artikel);
            artikel.setState(new LoanableState());
        }
    }
    public void loanOut(PartyArtikel artikel)
    {
        if(artikelen.contains(artikel))
        {
            artikel.setState(new LoanedState());
        }
        else
            {
                throw new IllegalArgumentException("Dit artikel bestaat niet in ons assortiment");
            }
    }

    public void returnArtikel(PartyArtikel artikel)
    {
        if(artikel.damagedState!=null){artikel.setState(new DamagedState());}
        else{artikel.setState(new LoanableState());}
    }
}
