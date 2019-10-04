package domain;


import javax.lang.model.type.ArrayType;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PartyMaterialRental {

    private TreeMap<State, Set<PartyArtikel>> artikelen;

    DamagedState damagedState;
    DeletedState deletedState;
    LoanableState loanableState;
    LoanedState loanedState;
    State state;

    public PartyMaterialRental()
    {
        artikelen=new TreeMap<>();
        state=loanableState;
    }

    public void verwijderArtikel(PartyArtikel artikel)
    {
        artikelen.get(artikel.state).remove(artikel);
    }
    public void addArtikel(PartyArtikel artikel)
    {
        artikel.setRental(this);
        if(artikel!=null)
        {
            if(artikelen.get(artikel.state)==null){

                artikelen.put(artikel.state,new HashSet<PartyArtikel>());
            }

            artikelen.get(artikel.state).add(artikel);

            artikel.setState(new LoanableState(this));
        }
    }

    public void setState(State state)
    {
        this.state=state;
    }

    public Set<PartyArtikel> toonLeenbareArtikelen()
    {
        return artikelen.get(loanableState);
    }

    public State getDamagedState(){return damagedState;}
    public State getDeletedState(){return deletedState;}
    public State getLoanableState(){return loanableState;}
    public State getLoanedState(){return loanedState;}

}
