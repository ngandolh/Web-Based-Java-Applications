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
import model.Magazine;

/**
 *
 * @author Asus
 */
public class MagazineDAO {

    private DBContext db;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public MagazineDAO() {
        db = new DBContext();
    }

    public MagazineDAO(DBContext db) {
        this.db = db;
    }

    public List<Magazine> read() throws SQLException {
        List<Magazine> listItem = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tblMagazine";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String publisher = rs.getString("publisher");
                double price = rs.getDouble("price");
                Magazine item = new Magazine(id, title, publisher, price);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MagazineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    public Magazine details(String idDetails) throws SQLException {

        try {
            String sql = "Select * from tblMagazine where id=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, idDetails);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String publisher = rs.getString("publisher");
                Double price = rs.getDouble("price");
                Magazine item = new Magazine(id, title, publisher, price);
                return item;
            }
        } catch (Exception ex) {
            Logger.getLogger(MagazineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void create(Magazine newItem) {
        try {
            String sql = "insert into tblMagazine(id,title,publisher,price) values(?,?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, newItem.getId());
            stmt.setString(2, newItem.getTitle());
            stmt.setString(3, newItem.getPublisher());
            stmt.setDouble(4, newItem.getPrice());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MagazineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Magazine newItem) {
        try {
            String sql = "Update tblMagazine set title=?, publisher=?, price=? where id=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, newItem.getTitle());
            stmt.setString(2, newItem.getPublisher());
            stmt.setDouble(3, newItem.getPrice());
            stmt.setString(4, newItem.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MagazineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String id) {
        String sql = "delete from tblMagazine where id=?";
        try {
            PreparedStatement st = db.getConn().prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
