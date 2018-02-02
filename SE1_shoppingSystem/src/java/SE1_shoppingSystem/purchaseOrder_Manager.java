package SE1_shoppingSystem;

public class purchaseOrder_Manager {
	
        private int[] changeArray;
        private String receipt;
        
        order o = new order();
        Printer print = new Printer();
        private static Double weight=0.0;
        
	public purchaseOrder_Manager() {}
	
	public boolean successfullOrder(String Scanner) {
		if((o.makeOrder(Scanner))){
			return true;
		}
		return false;
	}
        public boolean insertIntoTransaction(double totalPrice){
            return  o.insertIntoTransaction(totalPrice);
            
        }
        
        public void deleteCart(){
            o.deleteCart();
        }
        
       public boolean orderWithCash(double cashGiven){
           double total = getTotal();
           
           CashPayment cashPay = new CashPayment(cashGiven,total);
          if(cashPay.submitPayment()){
              changeArray = cashPay.getChangeArray();
              receipt = cashPay.getReceipt();
              return true;
          } 
          return false;
       }
       
       //debit
       public boolean orderWithCard(String cardNo, String expDate, String cvv, String pin){
           double total = getTotal();
           
           DebitCardPayment payDebit = new DebitCardPayment(cardNo,expDate,cvv,pin,total);
           if(payDebit.submitPayment()){
               receipt = payDebit.getReceipt();
                return true;
           }
           return false;
       }
       
       public boolean orderWithCard(String cardNo, String expDate, String cvv){
           double total = getTotal();
           CreditCardPayment payCredit = new CreditCardPayment(cardNo,expDate,cvv,total);
           if(payCredit.submitPayment()){
               receipt = payCredit.getReceipt();
                return true;
           }
           return false;
           
           
       }

       public void setTotal(double total){
           o.setTotal(total);
           
       }
        public void setWeight(Double weight) {
            this.weight = weight;
        }

       public boolean sendToPrinter(String str){
           return print.print(str);
       }
       public double getTotal(){
           return order.getTotal();
       }
       public String getReceipt(){
           return receipt;
       }
}
