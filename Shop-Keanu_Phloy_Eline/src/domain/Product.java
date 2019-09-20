package domain;

public class Product {

    private int id;
    private String type,title;

    public Product(String type,String title,int id)
    {
        if(type==null||type.trim().isEmpty()){throw new IllegalArgumentException();}
        else {this.type=type;}
        if(title==null||title.trim().isEmpty()){throw new IllegalArgumentException();}
        else{this.title=title;}
        if(id<=0){throw new IllegalArgumentException();}
        else{this.id=id;}
    }
    public double getPrice(int days) {
        double price = 0;
        if(type.equals("M")){
            price = 5;
            int daysLeft = days - 3;
            if (daysLeft > 0) {
                price += (daysLeft * 2);
            }
        } else if(type.equals("G")){
            price = days * 3;
        }
        return price;
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object o)
    {
        if(o instanceof Product)
        {
            return this.title.equals(((Product) o).title)&&this.type.equals(((Product) o).type)&&this.id==((Product) o).id;
        }
        return false;
    }

    public String toString()
    {
        return "id: "+id+"\ntitle: "+title+"\ntype: "+type;
    }

}
