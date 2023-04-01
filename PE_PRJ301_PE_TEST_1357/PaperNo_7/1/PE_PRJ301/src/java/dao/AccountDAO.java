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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.Account;
import pe.utils.DBUtils;

/**
 *
 * @author Asus
 */
public class AccountDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private DBUtils db;

    public DBUtils getDb() {
        return db;
    }

    public void setDb(DBUtils db) {
        this.db = db;
    }

    public AccountDAO(DBUtils db) {
        this.db = db;
    }

    public AccountDAO() {
        db = new DBUtils();
    }
    
    public Account details(String id) {

        try {
            String sql = "SELECT * FROM tblUsers WHERE  userID=? and password=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _un = rs.getString("userID");
                String _pass = rs.getString("password");
                String _role = rs.getString("roleID");
                Account item = new Account(id, _role, _pass);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Account login(String username, String password)
    {
        String sql = "select * from tblUsers where userID = ? and password = ?";
	try 
        {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
	    ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();               
            while (rs.next())
            {
                return (Account)new Account(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getBoolean(5));
            }
        } 
	catch (Exception e) {
            e.printStackTrace();
        }
	return null;
    }
    public static void main(String[] args) {
        AccountDAO acc = new AccountDAO();
        acc.login("admin", "1");
        Account account = acc.login("admin", "1");
        System.out.println(acc);
        System.out.println(account.getRoleID());
    }
}
