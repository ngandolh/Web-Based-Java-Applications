package dao;

import database.DBUtils;
import dto.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

    public static ArrayList<Product> getProducts() {
        ArrayList<Product> list = new ArrayList<>();
        Connection con = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select productId,title,quantity,price From Product";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int productId = rs.getInt("productId");
                        String title = rs.getString("title");
                        int quantity = rs.getInt("quantity");
                        int price = rs.getInt("price");
                        Product product = new Product(productId, title, quantity, price);
                        list.add(product);
                    }
                }
            }
        } catch (SQLException e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return list;
    }

    
}