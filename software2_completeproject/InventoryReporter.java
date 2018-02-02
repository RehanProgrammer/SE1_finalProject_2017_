package hw4.finals;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class InventoryReporter {
	public boolean printInventoryReport() throws IOException{

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			PreparedStatement ps=myConn.prepareStatement(  
					"select * from inventory");//check if the cart table is not null
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			printToFile("Item ID    Item Name    Item Quantity ");
			while (rs.next()) {
				
				printToFile(rs.getString(1) + " " + rs.getString(2)+" " +rs.getString(4));
				
				//printToFile(rs.getString(2));
				//printToFile(rs.getString(4));
				/*
				for(int i =1; i <=columnsNumber-2 ; i++){

					if(i==3)
						i++;

					printToFile(rs.getString(i));
					//Printwriter out = response.getWriter();
				}*/



			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;

	}
	public boolean printToFile(String str) throws IOException{
		File file = new File("C:\\software_engineering\\hw4_final/InventoryMessages.txt");
		PrintWriter out = null;
		try{


			out = new PrintWriter(new FileWriter(file,true));
			out.print(str);
			out.println();

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
	}
}
