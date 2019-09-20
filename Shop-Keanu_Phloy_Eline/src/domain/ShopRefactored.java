package domain;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

public class ShopRefactored {

    private String name;
    private Map<Integer,Product> products;

    public ShopRefactored(String name) {
        products=new TreeMap<>();
        if(name.trim().isEmpty()||name==null){throw new IllegalArgumentException();}
        else{this.name=name;}
    }





    public  void addProduct(Product product) {

        products.put(product.getId(),product);
    }

    public String showProduct(Product product){

        return product.toString();
    }

    public double showPrice(Product product,int days) {

        if(products.containsKey(product.getId())) {
            return products.get(product).getPrice(days);
        }
        return 0;
    }
}

