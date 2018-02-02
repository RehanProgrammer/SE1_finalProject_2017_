/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4.finals;

/**
 *
 * @author Lauren
 */
public class EmployeeInterface {
    
    InventoryManager manager = new InventoryManager();
    
    public boolean restockItem(int id, int quantity){
      
        return manager.restockItem(id, quantity);
      
    }
    public Item viewItemInfo(String itemId){
        return manager.viewInventoryItem(itemId);
        
    }
    
    public void updateItem(Item item){
        manager.updateInventoryItem(item);

    }
    public boolean createNewItem(Item item){
        return manager.createNewInventoryItem(item);
    }
}
