package domain;

public class Game extends Product {

    public Game(String id ,String title)
    {
        super(id,title);
    }

    public double getPrijs(int days)
    {
        return days*3;
    }
}
