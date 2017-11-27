import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class order {
    static ArrayList<String> Order = new ArrayList<String>();
	static ArrayList<Double> Price = new ArrayList<Double>();
	private static double price = 0.0;
	private String order = null;
	public boolean makeOrder(String order, int quantity) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			PreparedStatement ps=myConn.prepareStatement(  
					"select * from inventory where itemName='" + order+"'" );
			ResultSet rs = ps.executeQuery();
			//String Order = rs.getString("itemName");
			if(rs.next()) {
				if (rs.getString("ItemId")!=null) {
					 price = rs.getDouble("price");
					 price = quantity * price;
					 //arraylist(order);
					 //arraylist1(price);
					 insertOrder(order, price);
					 
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
	public void insertOrder(String order, double price) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
			String sql = "Insert into storeOrders(itemName,itemPrice) VALUES (?,?)";
			PreparedStatement ps ;
			ps = myConn.prepareStatement(sql);
			ps.setString(1, order);
			ps.setDouble(2, price);
			ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void arraylist (String order) {
		Order.add(order);
		
	}
	public static void arraylist1 (double price ) {
		Price.add(price);
		
	}
	public static String[] print () {
		String prinT[] = null ;
		for (int i=0; i<Order.size();i++) {
			prinT[i] = Order.get(i) + " " + Price.get(i);
		}
		return prinT;
	}
	
}
