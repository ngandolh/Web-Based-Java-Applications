
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
import model.Student;

public class StudentDao {

    Connection conn = null;
    PreparedStatement ps=null;
    ResultSet rs = null;
    
    private DBContext db;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public StudentDao(DBContext db) {
        this.db = db;
    }

    public StudentDao() {
        db = new DBContext();
    }

    public List<Student> read() throws SQLException {
        List<Student> listItem = new ArrayList<>();
         String sql = "select * from Student2";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
        try { 
            ResultSet rs = stmt.executeQuery(); 
            while (rs.next()) {
                int _id=rs.getInt("Id");
                String _name = rs.getString("Name");
                Boolean _gender = rs.getBoolean("Gender");
                Date _date = rs.getDate("DOB");
                Student item = new Student(_id, _name, _gender, _date);
                listItem.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    public Student details(String id) {

        try {
            String sql = "SELECT * FROM Student2 WHERE id=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();  // chứa dữ liệu lấy ra từ querry 
            while (rs.next()) {
                int _id = rs.getInt("Id");
                String _name = rs.getString("Name");
                Boolean _gender = rs.getBoolean("Gender");
                Date _date = rs.getDate("DOB");
                Student item = new Student(_id, _name, _gender,_date);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void create(Student newItem) throws SQLException {
       String sql = "insert into Student2 values (?,?,?)";
                   
                   
        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getName());
            stmt.setBoolean(2, newItem.isGender());
            stmt.setDate(3, newItem.getDate());
            stmt.executeUpdate(); // dùng khi muốn thêm, sửa, xóa
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String id) {
        String sql = "delete from Student2 where id=?";      
        try {
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate(); // thêm sua xoa thi dung lenh nay 
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(Student edittedItem) throws SQLException {
    try {
        String sql = "update Student2 set Name=?, Gender=?, DOB=? where Id=?";
        PreparedStatement stmt = db.getConn().prepareStatement(sql);
        stmt.setString(1, edittedItem.getName());
        stmt.setBoolean(2, edittedItem.isGender());
        stmt.setDate(3, edittedItem.getDate());
        stmt.setInt(4, edittedItem.getId());
        
        stmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

