
package dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class CartObj implements Serializable {
    private int productId;
    private Map<String, Integer> items;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
    
    public void addItemToCart(String title) {
        if(this.items == null) this.items = new HashMap<String,Integer>();
        int quantity = 1;
        if(this.items.containsKey(title)) quantity = this.items.get(title) + 1;
        this.items.put(title, quantity);
    }
 
    public void removeItemFromCart(String title) {
        if(this.items == null) return;
        if(this.items.containsKey(title)) {
            this.items.remove(title);
            if(this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
    
  
  
}
