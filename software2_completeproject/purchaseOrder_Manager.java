package hw4.finals;

//import java.io.IOException;

public class purchaseOrder_Manager {
	private int[] changeArray;
	private String receipt;
	private static  double weight = 0.0;
	order o = new order();
	Printer print = new  Printer();
	public purchaseOrder_Manager() {
		
	}
	
	public boolean successfullOrder(String Scanner) {
		
		if((o.makeOrder(Scanner))){
			//o.insertIntoOrders(Scanner);
			return true;
		}
		return false;
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
    public String getReceipt(){
        return receipt;
    }
    
    
    public double getTotal(){
    	//order o = new 
        return order.getTotal();
    }
    
    public void setWeight(Double weight) {
    	this.weight = weight;
    	}
    public static double getWeight() {
    	return weight;
    }
    public boolean insertInotTransaction(double totalPrice) {
    	//order o = new order();
    	o.insertIntoTransaction(totalPrice);
    	return true;
    }
    
    public void deleteCart() {
    	o.deleteCart();
    }
    public void setTotal(double total) {
    	o.seTotal(total);
    }
    public boolean sendToPrinter(String str){
        return print.print(str);
    }
}
