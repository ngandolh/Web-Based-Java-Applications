/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iso.edu.vn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ProductDAO {

    private DatabaseHelper db;

    public DatabaseHelper getDb() {
        return db;
    }

    public void setDb(DatabaseHelper db) {
        this.db = db;
    }

    public ProductDAO(DatabaseHelper db) {
        this.db = db;
    }

    public ProductDAO() {
        db = new DatabaseHelper();
    }

    public List<Product> getAll() {

        List<Product> ls = new ArrayList<>();
        try {
            String sql = "select pId, pname, pprice from Product";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setCode(rs.getString(1));
                pro.setName(rs.getString(2));
                pro.setPrice(rs.getFloat(3));
                ls.add(pro);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
        return ls;
    }

    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();
        ProductDAO dao = new ProductDAO();
//        list = dao.getAll();
//        for (Product product : list) {
//            System.out.println(product);
        Product sp = new Product();
        sp = dao.findByID("SP01");
        System.out.println(sp);
        

        }
   

    public Product findByID(String code) {
        PreparedStatement stmt = null;
        Product pro = null;
        
        try {
            String sql = "select pId, pname, pprice from Product where pId = ?";
            stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pro = new Product();
                pro.setCode(rs.getString(1));
                pro.setName(rs.getString(2));
                pro.setPrice(rs.getFloat(3));
                return pro;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {

            }
        }
        return pro;
    }
    
    public Product remove(List<Product> list, int elementToRemove) {
        for (Product product : list) {
            if (product.getCode().equals(elementToRemove)){
                list.remove(elementToRemove);
            }
        }
        return null;
    }
}
