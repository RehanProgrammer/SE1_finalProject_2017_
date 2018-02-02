package hw4.finals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DailyReport {
	private ArrayList<Integer>transID = new ArrayList<>();
	private  ArrayList<Integer> itemsID = new ArrayList<Integer>();
	private  ArrayList<String> itemsID1 = new ArrayList<String>();
	private  int[] itemCount = new int[9];
	private double revenue=0.0;
	
	public boolean storeTransID() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Date today = Calendar.getInstance().getTime(); 
			String reportDate = df.format(today);
			PreparedStatement ps=myConn.prepareStatement(  
					"select * from Transactions where DOP='"+ reportDate+"'");//check if the cart table is not null
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				transID.add(rs.getInt("TransactionID"));
				revenue+= rs.getDouble("totalPrice");
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public void storeItemIdsin_Orders() throws IOException {

		for(Integer x: transID) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConn = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
				String str = "Select itemId from orders where transactionID='" + x+"'";
				PreparedStatement ps1=myConn.prepareStatement(str);
				ResultSet rs1 = ps1.executeQuery();


				while (rs1.next()) {

					itemsID.add(rs1.getInt("itemId"));
				}

			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}//end for
		/*
		 try{
			 printToFile(itemsID);
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 */
		//countProductsSold();
	}


	/*public boolean printToFile(int[] list) throws IOException{
		File file = new File("C:\\software_engineering\\hw4_final/dailyReportMsg.txt");
		PrintWriter out = null;
		try{
			out = new PrintWriter(new FileWriter(file,true));
			for(int x: list) {
				System.out.println(x);
				out.print(x);
			}
			out.print("\n");

			//out.print(str);
			//out.println();

		}catch(FileNotFoundException e){
			e.printStackTrace();
			return false;
		}catch(IOException e2){
			e2.printStackTrace();
			return false;
		}finally{
			if(out!=null){
				out.close();
			}
		}
		return true;
	}*/

	public void countProductsSold() throws IOException {
		for(Integer x: itemsID) {
			System.out.println(x);
			itemCount[x.intValue()-1]++;
			System.out.print(itemCount[x.intValue()-1]);
		}
		/*try{
			printToFile(itemCount);
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		//returnItemNames();
	}
	public void returnItemNames() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			String str = "select * from inventory";
			PreparedStatement ps1=myConn.prepareStatement(str);
			ResultSet rs1 = ps1.executeQuery();


			while (rs1.next()) {

				itemsID1.add(rs1.getString("itemName"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void print2arrys() throws IOException {
		File file = new File("C:\\software_engineering\\hw4_final/dailyReportMsg.txt");
		PrintWriter out = null;
		try {
			//out = new PrintWriter(new FileWriter(file,true));
			out = new PrintWriter(file);
			for (int i=0; i<9; i++) {
				
				//System.out.println(itemsID1.get(i)+ "  " +itemsID.get(i));
				out.println(itemsID1.get(i)+ "  " +itemCount[i] +" ");
				
			}
			out.println("Revenue: "+revenue);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();

		}catch(IOException e2){
			e2.printStackTrace();

		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	public void callAll_methods() throws IOException {
		storeTransID();
		storeItemIdsin_Orders();
		countProductsSold();
		returnItemNames();
		print2arrys();

	}
	
}
