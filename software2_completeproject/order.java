package hw4.finals;


import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.*;
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
import java.util.Random;




//import com.mysql.jdbc.ResultSetMetaData;
//import java.util.ArrayList;

public class order {
	private FileInputStream fin = null;
	//static ArrayList<String> Order = new ArrayList<String>();
	//static ArrayList<Double> Price = new ArrayList<Double>();
	private static double price = 0.0;
	private String order = null;
	private static double total = 0;
	Random rand = new Random();
	private int transactionId = rand.nextInt(1000)+1;

	public boolean makeOrder(String scannerCode) {
		try {
			int scanner1 = Integer.parseInt(scannerCode);
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			PreparedStatement ps=myConn.prepareStatement(  
					"select * from inventory where ItemId='" + scannerCode+"'" );
			ResultSet rs = ps.executeQuery();
			//String Order = rs.getString("itemName");
			if(rs.next()) {
				if (rs.getString("ItemId")!=null) {
					if (scanner1>0 && scanner1<4) {
						price = rs.getDouble("price");
						double weight = purchaseOrder_Manager.getWeight();
						price = price * weight;
						order = rs.getString("itemName");
					}
					else {
						price = rs.getDouble("price");
						order = rs.getString("itemName");
					}
					total();
					//price = quantity * price;
					//arraylist(order);
					//arraylist1(price);
					insertIntoCart(order, price,scannerCode);
					//insertIntoTransaction(price);
					//insertIntoOrders(price);
					updateQuantity(scannerCode);
					checkQuantity(scannerCode);
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
	public void insertIntoCart(String order, double price, String scannerCode) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			String sql = "Insert into cart(itemName,itemPrice,itemId) VALUES (?,?,?)";
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
	public void total () {
		total +=price;
		DecimalFormat df = new DecimalFormat(".##");
		df.format(total);
	}
	public void seTotal(double total) {
		this.total= total;
	}
	public static double getTotal() {
		return total;
	}
	public void updateQuantity(String scannerCode) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
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

	public boolean insertIntoTransaction(double totalPrice){

		Random rand = new Random();
		int transID = rand.nextInt(1000) +1;
		//int transactionID = Integer.toString(transID);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Date today = Calendar.getInstance().getTime(); 
			String reportDate = df.format(today);
			String sql = "Insert into Transactions(TransactionID,totalPrice,DOP) VALUES (?,?,?)";
			PreparedStatement ps ;
			ps = myConn.prepareStatement(sql);
			ps.setInt(1, transID);
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
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			PreparedStatement ps=myConn.prepareStatement( "select * from Cart");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			//String Order = rs.getString("itemName");

			while(rs.next()) {
				itemID = rs.getString("itemId");
				if (itemID!=null) {
					insertIntoOrders(transID,itemID);	
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;

		}//end try catch


		return true;
	}//end insetIntoTransaction functin

	public void insertIntoOrders(int transactionID, String scannerCode) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");

			String sql = "Insert into orders(transactionID,itemId) VALUES (?,?)";
			PreparedStatement ps ;
			ps = myConn.prepareStatement(sql);
			ps.setInt(1, transactionID);
			ps.setString(2, scannerCode);
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteCart() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			String delete = "DELETE FROM cart";
			PreparedStatement ps=myConn.prepareStatement(delete);
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void checkQuantity(String scannerId) throws IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			String quary = "select quantity from inventory where ItemId ='"+scannerId + "'";
			PreparedStatement ps ;
			ps = myConn.prepareStatement(quary);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int quantity = rs.getInt("quantity");
			if (quantity<5) {
				String content = "The id "+scannerId+" is below the limit\n";
				String inFileName = "C:\\software_engineering\\hw4_final/input.txt";	
				  File file = new File(inFileName);
				  PrintWriter print = null;
				  try {
					  print = new PrintWriter(file);
					  print.print(content+"\n");
				  }
				  catch(FileNotFoundException e) {
					  e.printStackTrace();
				  }
				  finally{
					  if(print!=null) {
						  print.close();
					  }
				  }
				

				

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
