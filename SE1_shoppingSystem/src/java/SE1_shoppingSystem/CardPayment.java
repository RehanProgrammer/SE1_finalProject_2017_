
package SE1_shoppingSystem;

abstract class CardPayment extends Payment{
    protected String cardNo,expDate,cvv;
    protected String authNo;
    BankInterface bank= new BankInterface();
    
    public CardPayment(){}
    public CardPayment(String cardNo, String expDate, String cvv, double amount){
        super(amount);
        this.cardNo = cardNo;
        this.expDate = expDate;
        this.cvv = cvv;
    }
    
    @Override
    abstract boolean submitPayment();
    
    @Override
    abstract String getReceipt();
    
    public String getAuthorizationNo(){
        return authNo;
    }
    
    
}
class DebitCardPayment extends CardPayment{
    
    private String pin;
    
    DebitCardPayment(String cardNo, String expDate, String cvv, String pin, double amount){
        super(cardNo,expDate,cvv,amount);
        this.pin = pin;
    }
    
    @Override
    public boolean submitPayment(){
        
        
        if(bank.getAuthorization(cardNo, expDate,cvv,pin,amount)){
            authNo = bank.getAuthorizationNo();
            return true;
        }
        return false;
    }//end submitPayment
    
    @Override
    public String getReceipt(){
        return "Debit Card Accepted.,"+
                "Customer Receipt.,"+
                "---------------------,"+
                "Card charged: ****"+cardNo.substring(cardNo.length()-4)+","+
                "Amount charged: " +amount+","+
                "Bank Authorization: "+authNo+","+
                "Store Receipt.,"+
                "---------------------,"+
                "Card charged: ****"+cardNo.substring(cardNo.length()-4)+","+
                "Amount charged: " +amount+","+
                "Bank Authorization: "+authNo+","+
                "Customer Signature: ";
                
    }
    
    
}

class CreditCardPayment extends CardPayment{
    
    CreditCardPayment(String cardNo, String expDate, String cvv, double amount){
        super(cardNo,expDate,cvv,amount);
    }
    
    @Override
    public boolean submitPayment(){
        
        
        if(bank.getAuthorization(cardNo, expDate,cvv,amount)){
            authNo = bank.getAuthorizationNo();
            return true;
        }
        return false;
    }//end submitPayment
    
     
    @Override
    public String getReceipt(){
        return "Credit Card Accepted.,"+
                "Customer Receipt.,"+
                "---------------------,"+
                "Card charged: ****"+cardNo.substring(cardNo.length()-4)+","+
                "Amount charged: " +amount+","+
                "Bank Authorization: "+authNo+","+
                "Store Receipt.,"+
                "---------------------,"+
                "Card charged: ****"+cardNo.substring(cardNo.length()-4)+","+
                "Amount charged: " +amount+","+
                "Bank Authorization: "+authNo+","+
                "Customer Signature: ,"+
                "***************************************";
    }
    
}
