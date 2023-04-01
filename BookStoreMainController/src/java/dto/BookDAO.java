/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;

/**
 *
 * @author Admin
 */
public class BookDAO {
    private DBContext db;

    public BookDAO() {
         db =  new  DBContext();
    }

    public BookDAO(DBContext db) {
        this.db = db;
    }
    
    public List<Book> read(){
        List<Book> listItem = new ArrayList<>();
        
        try {    
            String sql = "SELECT * FROM tblBooks";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String _id  = rs.getString("id");
                String _name = rs.getString("name");
                int _page = rs.getInt("page");
                String _author = rs.getString("author");
                float _price = rs.getFloat("price");
                boolean _status = rs.getBoolean("status");
                Book item = new Book(_id, _name, _page, _author, _price, _status);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return listItem;
    }
    
}
