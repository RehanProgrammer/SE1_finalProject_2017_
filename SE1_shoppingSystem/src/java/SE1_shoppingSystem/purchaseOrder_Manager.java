package SE1_shoppingSystem;

public class purchaseOrder_Manager {
	
        private int[] changeArray;
    
	public purchaseOrder_Manager() {
		
	}
	
	public boolean successfullOrder(String Scanner) {
		order o = new order();
		if((o.makeOrder(Scanner))){
			return true;
		}
                
                
                
		return false;
	}
        
       public void orderWithCash(double cashGiven, double total){

           CashPayment cashPay = new CashPayment(cashGiven,total);
          if(cashPay.submitPayment()){
              changeArray = cashPay.getChangeArray();
          } 

       }
       
       public boolean orderWithCard(String cardNo, String expDate, String cvv, String pin){
           double total = getTotal();
           DebitCardPayment payDebit = new DebitCardPayment(cardNo,expDate,cvv,pin,total);
           
           return payDebit.submitPayment();
       }
       
       public boolean orderWithCard(String cardNo, String expDate, String cvv){
           double total = getTotal();
           
           CreditCardPayment payCredit = new CreditCardPayment(cardNo,expDate,cvv,total);
           return payCredit.submitPayment();
           
         
       }
       public double getTotal(){
           return order.total();
       }
        
}
