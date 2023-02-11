/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;
import model.Product;
import java.util.ArrayList;

/**
 *
 * @author The Anh
 */
public class ProductData {
    public static ArrayList<Product> listProduct = new ArrayList<Product>();
    
    public static void initalData(){
        listProduct.add(new Product("P01","Pepsi",12,12500));
        listProduct.add(new Product("P02","Coca",4,16000));
        listProduct.add(new Product("P03","7up",28,12000));
        listProduct.add(new Product("P04","Fanta",43,22000));
        listProduct.add(new Product("P05","Sting",30,22500));

    }
   
}
