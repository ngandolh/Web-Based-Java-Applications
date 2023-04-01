/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iso.edu.vn;

/**
 *
 * @author Asus
 */
public class CartBean {
    private Product pro;
    private int quantity;

    public CartBean() {
    }

    public CartBean(Product pro, int quantity) {
        this.pro = pro;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getPro() {
        return pro;
    }

    public void setPro(Product pro) {
        this.pro = pro;
    }
    
}
