/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Asus
 */
public class ProductDAO implements ICrud<String, Product> {

    List<Product> listItems;

    public ProductDAO() {
        listItems = new ArrayList<>();
    }

    public ProductDAO(List<Product> listItems) {
        this.listItems = listItems;
    }

    public List<Product> getListItems() {
        return listItems;
    }

    public void setListItems(List<Product> listItems) {
        this.listItems = listItems;
    }

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private DBContext db;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public ProductDAO(DBContext db) {
        this.db = db;
    }

    @Override
    public List<Product> read() {
        List<Product> listItem = new ArrayList<>();

        try {
            String sql = "select * from tblProduct";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _id = rs.getString("pId");
                String _name = rs.getString("pname");
                double _price = rs.getDouble("pprice");
                int _quantity = rs.getInt("pquantity");
                Product item = new Product(_id, _name, _price, _quantity);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public Product details(String id) {
        try {
            String sql = "SELECT * FROM tblProduct WHERE  pId=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _id = rs.getString("pId");
                String _name = rs.getString("pname");
                double _price = rs.getDouble("pprice");
                int _quantity = rs.getInt("pquantity");
                Product item = new Product(_id, _name, _price, _quantity);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(Product newItem) {
         try {
            String sql = "insert into tblProduct(pId, pname,pprice,pquantity) values(?,?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, newItem.getId());
            stmt.setString(2, newItem.getName());
            stmt.setDouble(3, newItem.getPrice());
            stmt.setInt(4, newItem.getQuantity());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Product edittedItem) {
      try {
            String sql = "Update tblProduct set pname=?, pprice=?, pquantity=? where pId=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, edittedItem.getName());
            stmt.setDouble(2, edittedItem.getPrice());
            stmt.setInt(3, edittedItem.getQuantity());
            stmt.setString(4, edittedItem.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
       String sql = "delete from tblProduct where pId=?";
        try {
            PreparedStatement st = db.getConn().prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
