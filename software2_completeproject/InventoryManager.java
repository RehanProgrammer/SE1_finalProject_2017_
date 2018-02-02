/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4.finals;
import java.sql.*;
/**
 *
 * @author Lauren
 */
public class InventoryManager {
    
    Item item = new Item();
    Connection con;
    
    boolean restockItem(int scannedId, int scannedQuantity){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/finalprojectdatabase","root","12345");
            Statement mystmt = con.createStatement();
            
            
            String selectQuery = "SELECT * FROM inventory WHERE inventory.ItemId ='" + scannedId + "'";
            ResultSet rs = mystmt.executeQuery(selectQuery);
            
            rs.next();
            
            if (rs.getInt("ItemId") != scannedId){
                
                return false;
            }
            
            
            
            String query = "UPDATE inventory SET quantity = ? WHERE ItemId ='" + scannedId +"'";
            PreparedStatement ps=con.prepareStatement(query);
            
            ps.setInt(1, scannedQuantity + rs.getInt("quantity"));
      
            
            ps.executeUpdate();
            
           return true; 
            
         }
        
        
        catch(Exception e){
        e.printStackTrace();
        return false;
        
        }
        
    }
    
    public void updateInventoryItem(Item updatedItem){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalprojectdatabase","root","12345");
            Statement mystmt = con.createStatement();
            
            
             
            
            String query = "UPDATE inventory SET itemName = ?, price = ?, quantity = ?, description = ?, discounts = ? WHERE ItemId ='" + updatedItem.itemId +"'";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, updatedItem.itemName);
            ps.setDouble(2, updatedItem.itemPrice);
            ps.setInt(3, updatedItem.itemQuantity);
            ps.setString(4, updatedItem.itemDescription);
            ps.setDouble(5, updatedItem.itemDiscount);
          
            
            ps.executeUpdate();
           
            return;
            
      }
        
        catch(Exception e){
        e.printStackTrace();
            return;
        }
       
        
    }
    
    public boolean createNewInventoryItem(Item newItem){
            try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/finalprojectdatabase","root","12345");
            Statement mystmt = con.createStatement();
            
            //write SQL query to update code in database
            String query = "INSERT INTO inventory(ItemId, itemName, price, quantity, description, discounts) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, newItem.itemId);
            ps.setString(2, newItem.itemName);
            ps.setDouble(3, newItem.itemPrice);
            ps.setInt(4, newItem.itemQuantity);
            ps.setString(5, newItem.itemDescription);
            ps.setDouble(6, newItem.itemDiscount);

            ps.executeUpdate();
           return true; 
            
         }
        
        
        catch(Exception e){
        e.printStackTrace();
       
            return false;
        }
        
    }
    
    public Item viewInventoryItem(String scannedId){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/finalprojectdatabase","root","12345");
            Statement mystmt = con.createStatement();
            
            
            String selectQuery = "SELECT * FROM inventory WHERE inventory.ItemId ='" + scannedId + "'";
            
            ResultSet rs = mystmt.executeQuery(selectQuery);
            
            
            while(rs.next()){
                item.itemId = rs.getInt("ItemId");
                item.itemName = rs.getString("itemName");
                item.itemPrice = rs.getDouble("price");
                item.itemQuantity = rs.getInt("quantity");
                item.itemDescription = rs.getString("description");
                item.itemDiscount = rs.getDouble("discounts");
                
             
           }
           return item; 
            
         }
        
        
        catch(Exception e){
        e.printStackTrace();
       
            return item;
        }
  
    }
    
 
}
