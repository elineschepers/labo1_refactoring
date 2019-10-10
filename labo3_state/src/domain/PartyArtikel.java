package domain;

public class PartyArtikel {
    private String name;
    private double prijs;
    State damagedState;
    State deletedState;
    State loanableState;
    State loanedState;
    PartyMaterialRental partyMaterialRental;
    State state = loanableState;
    public PartyArtikel(String n,double p)
    {
        damagedState = new DamagedState(getRental());
        deletedState = new DeletedState(getRental());
        loanableState = new LoanableState(getRental());
        loanedState = new LoanedState(getRental());
        this.name=n;
        this.prijs=p;
        this.state=loanableState;

    }
    public State getState()
    {
        return state;
    }
    public double getPrijs()
    {
        return prijs;
    }

    public void setRental(PartyMaterialRental rental)
    {
        this.partyMaterialRental=rental;
    }
    public PartyMaterialRental getRental(){return partyMaterialRental;}
    public void setState(State state)
    {
     this.state=state;
    }
    public State getDamagedState() {
        return damagedState;
    }

    public State getDeletedState() {
        return deletedState;
    }

    public State getLoanableState() {
        return loanableState;
    }

    public State getLoanedState() {
        return loanedState;
    }

    @Override
    public String toString()
    {
        return "\nartikel: "+name+"\nprijs: "+prijs;
    }
}
