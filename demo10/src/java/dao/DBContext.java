/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class DBContext {

    private Connection conn = null;

    public DBContext() {
        try {
            String usr = "sa";
            String pass = "123456";
//            2.Tạo connection string - protocol: loaiserver://diachiIP:port;tendb;teninstance
            String url = "jdbc:sqlserver://localhost:1433;databaseName=dbSE161483";
//            1. load drive
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            3.Lấy connection
            conn = DriverManager.getConnection(url, usr, pass);
//            4. Trả connection cho đối tượng goi
//            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Đóng - mở Connect Database
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
