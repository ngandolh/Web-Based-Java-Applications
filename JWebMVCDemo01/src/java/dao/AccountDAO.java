/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Asus
 */
public class AccountDAO {

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

    public AccountDAO(DBContext db) {
        this.db = db;
    }

    public AccountDAO() {
        db = new DBContext();
    }


    public Account login(String user, String password) throws SQLException {
        List<Account> listItem = new ArrayList<>();
        String sql = "Select * from  AccountMVC01\n"
                + "where Username = ? and Password = ?";

        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Account item = new Account(rs.getString(1), rs.getString(2));
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        AccountDAO acc = new AccountDAO();
        System.out.println(acc.login("admin", "123"));
    }
}
