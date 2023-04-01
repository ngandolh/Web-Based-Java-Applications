/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDAO {
    private DBContext db;

    public AccountDAO() {
        db =  new  DBContext();
    }

    public AccountDAO(DBContext db) {
        this.db = db;
    }
    public Account details(String username){
        try {               
            String sql = "SELECT * FROM tblAccounts WHERE username=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String _un  = rs.getString("username");
                String _pass = rs.getString("password");
                String _role = rs.getString("role");
                Account acc = new Account(_un, _pass, _role);
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return null;
    }  

    public Account login(String userID, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
