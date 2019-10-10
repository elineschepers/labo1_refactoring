package domain;

public class Game extends Product {


    public Game(String id ,String title)
    {
        super(id,title);
//test
    }

    public double getPrijs(int days)
    {
        return days*3;
    }
}
