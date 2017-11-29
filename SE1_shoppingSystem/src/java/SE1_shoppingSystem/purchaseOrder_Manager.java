package SE1_shoppingSystem;

public class purchaseOrder_Manager {
	
	public purchaseOrder_Manager() {
		
	}
	
	public boolean successfullOrder(String Scanner) {
		order o = new order();
		if((o.makeOrder(Scanner))){
			return true;
		}
		return false;
	}
}
