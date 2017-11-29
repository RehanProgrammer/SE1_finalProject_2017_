
package SE1_shoppingSystem;

abstract class CardPayment extends Payment{
    protected String cardNo,expDate,cvv;
    protected String authNo;
    BankInterface bank;
    
    public CardPayment(){}
    public CardPayment(String cardNo, String expDate, String cvv, double amount){
        super(amount);
        this.cardNo = cardNo;
        this.expDate = expDate;
        this.cvv = cvv;
    }
    
    @Override
    abstract boolean submitPayment();
    
    public String getAuthorizationNo(){
        return authNo;
    }
    
    
}
class DebitCardPayment extends CardPayment{
    
    private String pin;
    
    DebitCardPayment(String cardNo, String expDate, String cvv, double amount, String pin){
        super(cardNo,expDate,cvv,amount);
        this.pin = pin;
    }
    
    @Override
    public boolean submitPayment(){
        bank= new BankInterface();
        
        if(bank.getAuthorizationNo(cardNo, expDate,cvv,pin,amount)){
            authNo = bank.getAuthorizationNo();
            return true;
        }
        return false;
    }
    
}

class CreditCardPayment extends CardPayment{
    
    CreditCardPayment(String cardNo, String expDate, String cvv, double amount){
        super(cardNo,expDate,cvv,amount);
    }
    
    @Override
    public boolean submitPayment(){
        bank = new BankInterface();
        
        if(bank.getAuthorization(cardNo, expDate,cvv,amount)){
            authNo = bank.getAuthorizationNo();
            return true;
        }
        return false;
    }
}
