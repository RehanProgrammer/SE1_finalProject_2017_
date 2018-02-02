package SE1_shoppingSystem;

import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.ArrayList;


public class order {
	//static ArrayList<String> Order = new ArrayList<String>();
	//static ArrayList<Double> Price = new ArrayList<Double>();
	private static double price = 0.0;
	private String order = null;
	private static double total = 0;
	public boolean makeOrder(String scannerCode) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","DdaavviidMYSQL1d");
			PreparedStatement ps=myConn.prepareStatement(  
					"select * from inventory where ItemId='" + scannerCode+"'" );
			ResultSet rs = ps.executeQuery();
			//String Order = rs.getString("itemName");
			if(rs.next()) {
				if (rs.getString("ItemId")!=null) {
					price = rs.getDouble("price");
					order = rs.getString("itemName");
					total();
                                        
					insertOrder(order, price,scannerCode);
					updateQuantity(scannerCode);
					return true;
				}
				else {
					return false;
				}

			}
		}
		catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return false;
	}

	public String getOrder() {
		return order;
	}
	public static double getprice() {
		return price;
	}
	public void insertOrder(String order, double price, String scannerCode) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","DdaavviidMYSQL1d");
			String sql = "Insert into Cart(itemName,itemPrice,itemId) VALUES (?,?,?)";
			PreparedStatement ps ;
			ps = myConn.prepareStatement(sql);
			ps.setString(1, order);
			ps.setDouble(2, price);
			ps.setString(3, scannerCode);
			ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void total() {
		total +=price;
               // DecimalFormat df = new DecimalFormat(".##");
                //df.format(total);
	}
        public static double getTotal(){
            DecimalFormat df = new DecimalFormat(".##");
            df.format(total);
            return total;
        }
        public void setTotal(double total){
            this.total = total;
        }
	public void updateQuantity(String scannerCode) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","DdaavviidMYSQL1d");
			String update = "update inventory set quantity = quantity-1 where ItemId =?";
			PreparedStatement ps;
			 ps = myConn.prepareStatement(update);
			 ps.setString(1, scannerCode);
			 ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
        public void deleteCart(){
            try{
                 Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection
                                ("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","DdaavviidMYSQL1d");
                String delete = "DELETE FROM Cart";
                PreparedStatement ps=myConn.prepareStatement(delete);
                ps.executeUpdate();
                
            }catch(Exception e) {
			e.printStackTrace();
		}
	
        
        }
        
      public boolean insertIntoTransaction(double totalPrice){

                Random rand = new Random();
                int transID = rand.nextInt(1000) +1;
                String transactionID = Integer.toString(transID);
                
            try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","DdaavviidMYSQL1d");
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Date today = Calendar.getInstance().getTime(); 
			String reportDate = df.format(today);
			String sql = "Insert into transactions(transactionID,totalPrice,DOP) VALUES (?,?,?)";
			PreparedStatement ps ;
			ps = myConn.prepareStatement(sql);
                        ps.setString(1, transactionID);
			ps.setDouble(2, totalPrice);
			ps.setString(3, reportDate);
			ps.executeUpdate();
                       
		}
		catch (Exception e) {
			e.printStackTrace();
                        return false;
		}
            
              
            
           try {
                        String itemID;
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","DdaavviidMYSQL1d");
			PreparedStatement ps=myConn.prepareStatement( "select * from Cart");
			ResultSet rs = ps.executeQuery();
                        ResultSetMetaData rsmd = rs.getMetaData();
			//String Order = rs.getString("itemName");
                        
			while(rs.next()) {
                                itemID = rs.getString("itemId");
				if (itemID!=null) {
                                        insertIntoOrders(transactionID,itemID);	
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
                        return false;
			
		}//end try catch

            
            return true;
        }//end insetIntoTransaction functin
        
        public void insertIntoOrders(String transactionID, String scannerCode) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","DdaavviidMYSQL1d");
			String sql = "Insert into orders(transactionID,itemID) VALUES (?,?)";
			PreparedStatement ps ;
			ps = myConn.prepareStatement(sql);
			ps.setString(1, transactionID);
			ps.setString(2, scannerCode);
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
            
        
        
}
