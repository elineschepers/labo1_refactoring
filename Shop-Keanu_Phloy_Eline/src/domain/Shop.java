package domain;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Shop {

    private HashMap<Integer, ArrayList<String>> products;
    private ArrayList<String> productTitles;
    private ArrayList<String> productTypes;
    private ArrayList<Integer> productIds;
    private ArrayList<Integer> productLends;

        public Shop() {
            products = new HashMap<Integer, ArrayList<String>>();
            productTitles = new ArrayList<String>();
            productTypes = new ArrayList<String>();
            productIds = new ArrayList<Integer>();
            productLends = new ArrayList<Integer>();
        }

        public double getPrice(int productidx, int days) {
            double price = 0;
            if (productTypes.get(productidx).equals("M")){
                price = 5;
                int daysLeft = days - 3;
                if (daysLeft > 0) {
                    price += (daysLeft * 2);
                }
            } else if(productTypes.get(productidx).equals("G")){
                price = days * 3;
            } else if(productTypes.get(productidx).equals("C")){
                price = days * 1.5;
            }
            return price;
        }

        public static void main(String[] args) {
            Shop shop = new Shop();

            readFile(shop);

            String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Show all produts\n5. Lend product\n6. Check Availability\n\n0. Quit";
            int choice = -1;
            while (choice != 0) {
                String choiceString = JOptionPane.showInputDialog(menu);
                choice = Integer.parseInt(choiceString);
                if (choice == 1) {
                    addProduct(shop);
                } else if (choice == 2) {
                    showProduct(shop);
                } else if (choice == 3){
                    showPrice(shop);
                } else if (choice == 4) {
                    showAllProducts(shop);
                } else if (choice == 5) {
                    lendProduct(shop);
                } else if (choice == 6) {
                    checkAvailability(shop);
                }
            }

            writeFile(shop.products);
        }

        public static void addProduct(Shop shop) {
            ArrayList<String> products = new ArrayList<>();

            String title = JOptionPane.showInputDialog("Enter the title:");
            shop.productTitles.add(title);

            if (shop.productIds.size() == 0) {
                int id = 1;
                shop.productIds.add(id);
            } else {
                int id = shop.productIds.size() + 1;
                shop.productIds.add(id);
            }

            String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/C for CD):");
            shop.productTypes.add(type);

            products.add(title);
            products.add(type);

            shop.products.put(shop.productIds.size(), products);
        }

        public static void showProduct(Shop shop){
            String id = JOptionPane.showInputDialog("Enter the id:");
            int idx = -1;
            boolean found = false;

            for (int i = 0; i < shop.productIds.size() && !found; i++) {
                if(shop.productIds.get(i).equals(id)) {
                    idx = i;
                    found = true;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, shop.productTitles.get(idx));
            }
        }

        public static void showPrice(Shop shop){
            String id = JOptionPane.showInputDialog("Enter the id:");
            int idx = -1;
            boolean found = false;

            for (int i = 0; i < shop.productIds.size() && !found; i++){
                if (shop.productIds.get(i).equals(id)){
                    idx = i;
                    found = true;
                }
            }
            if (found){
                String daysString = JOptionPane.showInputDialog("Enter the number of days:");
                int days = Integer.parseInt(daysString);
                JOptionPane.showMessageDialog(null, shop.getPrice(idx,days));
            }
        }

        public static void showAllProducts(Shop shop) {
            if (shop.productIds != null) {
                String lijst = "";
                for (int i = 0; i < shop.productTypes.size(); i++) {
                    if (shop.productTypes.get(i).equals("M")) {
                        lijst += "Category: ";
                        lijst += shop.productTypes.get(i);
                        lijst += "\n";

                        lijst += "ID: ";
                        lijst += shop.productIds.get(i);
                        lijst += "\n";

                        lijst += "Title: ";
                        lijst += shop.productTitles.get(i);
                        lijst += "\n";
                        lijst += "\n";
                    }
                }
                for (int i = 0; i < shop.productTypes.size(); i++) {
                    if (shop.productTypes.get(i).equals("G")) {
                        lijst += "Category: ";
                        lijst += shop.productTypes.get(i);
                        lijst += "\n";

                        lijst += "ID: ";
                        lijst += shop.productIds.get(i);
                        lijst += "\n";

                        lijst += "Title: ";
                        lijst += shop.productTitles.get(i);
                        lijst += "\n";
                        lijst += "\n";
                    }
                }
                for (int i = 0; i < shop.productTypes.size(); i++) {
                    if (shop.productTypes.get(i).equals("C")) {
                        lijst += "Category: ";
                        lijst += shop.productTypes.get(i);
                        lijst += "\n";

                        lijst += "ID: ";
                        lijst += shop.productIds.get(i);
                        lijst += "\n";

                        lijst += "Title: ";
                        lijst += shop.productTitles.get(i);
                        lijst += "\n";
                        lijst += "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, lijst);
            } else {
                JOptionPane.showMessageDialog(null, "Geen id's in de lijst.");
            }
        }

        public static void lendProduct(Shop shop) {
            String id = JOptionPane.showInputDialog(null, "Enter the id of the product you wish to lend.");

            shop.productLends.add(Integer.parseInt(id));
        }

        public static void checkAvailability(Shop shop) {
            String id = JOptionPane.showInputDialog(null, "Enter the id of the product you wish to check.");

            for (int i: shop.productLends) {
                if (i == Integer.parseInt(id)) {
                    JOptionPane.showMessageDialog(null, "This product isn't available right now.");
                } else {
                    JOptionPane.showMessageDialog(null, "This product is available right now.");
                }
            }
        }

        public static void writeFile(HashMap<Integer, ArrayList<String>> products) {
            String file = "shop.txt";

            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Integer key: products.keySet()) {
                    bufferedWriter.write(key.toString());
                    bufferedWriter.newLine();
                    for (String value: products.get(key)) {
                        bufferedWriter.write(value);
                        bufferedWriter.newLine();
                    }
                }

                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void readFile(Shop shop) {
            String file = "shop.txt";
            String line = null;

            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    if (line.equals("M") || line.equals("G") || line.equals("C")) {
                        shop.productTypes.add(line);
                    } else if (line.matches("-?\\d+(\\.\\d+)?")) {
                        shop.productIds.add(Integer.parseInt(line));
                    } else {
                        shop.productTitles.add(line);
                    }
                }

                System.out.println("ID's: " + shop.productIds);
                System.out.println("Types: " + shop.productTypes);
                System.out.println("Titles: " + shop.productTitles);

                bufferedReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("File doesn't exist!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}