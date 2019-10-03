public class PartyArtikel {
    private String name;
    private double prijs;
    State damagedState;
    State deletedState;
    State loanableState;
    State loanedState;

    State state = loanableState;
    public PartyArtikel(String n,double p)
    {
        damagedState = new DamagedState();
        deletedState = new DeletedState();
        loanableState = new LoanableState();
        loanedState = new LoanedState();
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

}
