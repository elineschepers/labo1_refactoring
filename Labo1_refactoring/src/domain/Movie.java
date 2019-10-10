package domain;

public class Movie extends Product {


    public Movie(String title, String id) {
        super(title, id);
    }

    public double getPrijs(int days)
    {
        double price = 5;
        int daysLeft = days - 3;
        if (daysLeft > 0) {
            price += (daysLeft * 2);
        }
        return price;
    }
    //tryyyyy
}
