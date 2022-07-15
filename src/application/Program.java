package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner key = new Scanner(System.in);

        try {

            List<Product> list = new ArrayList<>();


            int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of products: "));

            //String[] menu = {"1) Add Card", "2) Change Card Data", "3) Delete Card", "4) Show All Registered Cards", "5) Exit"};

            for (int i = 1; i <= n; i++) {
                String text = JOptionPane.showInputDialog(null, "Product #" + i + " data: \n Common, used or imported (c/u/i)?");
                char response = text.charAt(0);

                String name = JOptionPane.showInputDialog(null, "Product #" + i + " data: \n Name: ");

                double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Product #" + i + " data: \n Price: "));

                if (response == 'c') {
                    Product product = new Product(name, price);

                    list.add(product);

                } else if (response == 'u') {
                    Date manufactureDate = sdf.parse(JOptionPane.showInputDialog("Manufacture date (dd/MM/yyyy): "));
                    Product product = new UsedProduct(name, price, manufactureDate);

                    list.add(product);

                } else if (response == 'i') {

                    double customsFee = Double.parseDouble(JOptionPane.showInputDialog("Customs fee: "));
                    Product product = new ImportedProduct(name, price, customsFee);

                    list.add(product);
                }
            }
            for (Product p : list) {
                JOptionPane.showMessageDialog(null, "PRICE TAGS: \n" + p.priceTag());
            }

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
