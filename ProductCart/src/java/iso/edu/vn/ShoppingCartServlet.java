/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iso.edu.vn;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class ShoppingCartServlet {
    Map<Integer, CartBean> maps = new HashMap<>();
    
    public void add(CartBean item){
        CartBean cartItem = maps.get(item.getPro().getCode());
        if(cartItem == null){
            maps.put(item.getPro().getCode(), item);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }
    }
    
    public  void remove(int id) {
        maps.remove(id);
    }
    
    public CartBean update(int proID, int qty){
        CartBean cartItem = maps.get(proID);
        cartItem.setQuantity(qty);
        return cartItem;
    }
    
    public void clear(){
        maps.clear();
    }
    
    
}
