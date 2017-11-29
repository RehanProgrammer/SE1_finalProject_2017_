package SE1_shoppingSystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 123re
 */

public class purchaseOrder_Manager {
    public purchaseOrder_Manager() {
		
	}
	
	public boolean successfullOrder(String order, int quantity) {
		order o = new order();
		if((o.makeOrder(order, quantity))){
			return true;
		}
		return false;
	}
}
