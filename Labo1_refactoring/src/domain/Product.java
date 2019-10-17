package domain;

public class Product {

    private String id;
    private String title;

    public Product(String title,String id)
    {

        if(title==null||title.trim().isEmpty()){throw new IllegalArgumentException();}
        else{this.title=title;}
        if(id.trim().isEmpty()){throw new IllegalArgumentException();}
        else{this.id=id;}
    }
    public double getPrice(int days) {
        double price = 0;
        if(this instanceof Movie){

            return this.getPrice(days);
        } else if(this instanceof Game){
            return this.getPrice(days);
        }
        return 0;
    }

    public String getId() {
        return id;
    }

    public boolean equals(Object o)
    {
        if(o instanceof Product)
        {
            return this.title.equals(((Product) o).title)&&this.id==((Product) o).id;
        }
        return false;
    }

    public String toString()
    {
        return "id: "+id+"\ntitle: "+title;
    }

}
