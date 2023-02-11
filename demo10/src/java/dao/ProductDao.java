/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class ProductDao {

    private DBContext db;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public ProductDao(DBContext db) {
        this.db = db;
    }

    public ProductDao() {
        db = new DBContext();
    }

//    getAll()
    public List<Product> read() throws SQLException {
        List<Product> listItem = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tblProduct";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _code = rs.getString("code");
                String _name = rs.getString("name");
                int _quantity = rs.getInt("quantity");
                double _price = rs.getDouble("price");
                Product item = new Product(_code, _name, _quantity, _price);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    public Product details(String id) {

        try {
            String sql = "SELECT * FROM tblProduct WHERE code=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _code = rs.getString("code");
                String _name = rs.getString("name");
                int _quantity = rs.getInt("quantity");
                double _price = rs.getDouble("price");
                Product item = new Product(_code, _name, _quantity, _price);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    delete from .... where code =..
    public void delete(String code) {
        String sql = "delete from tblProduct where code=?";
        try {
            PreparedStatement st = db.getConn().prepareStatement(sql);
            st.setString(1, code);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//Create new product
    public void create(Product newItem) {
        try {
            String sql = "insert into tblProduct(code,name,quantity,price) values(?,?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, newItem.getCode());
            stmt.setString(2, newItem.getName());
            stmt.setInt(3, newItem.getQuantity());
            stmt.setDouble(4, newItem.getPrice());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


//  Update
    public void update(Product edittedItem) {
        try {
            String sql = "Update tblProduct Set name=?, quantity=?, price=? Where code=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            
            stmt.setString(1, edittedItem.getName());
            stmt.setInt(2, edittedItem.getQuantity());
            stmt.setDouble(3, edittedItem.getPrice());
            stmt.setString(4, edittedItem.getCode());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
