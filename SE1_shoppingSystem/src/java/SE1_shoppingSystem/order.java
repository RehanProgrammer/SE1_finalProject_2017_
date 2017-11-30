package SE1_shoppingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
					//price = quantity * price;
					//arraylist(order);
					//arraylist1(price);
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
	public static double total () {
		total +=price;
		return total;
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
}
