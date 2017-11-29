
package SE1_shoppingSystem;


public abstract class Payment {
 
    protected double amount;
    
    
    Payment(){}
    Payment(double amount){
        this.amount = amount;    
    }
    
    abstract boolean submitPayment();
    
    void setAmount(double amount){
        this.amount = amount;
    }
    double getAmount(){
        return amount;
    }
    
    
}

class CashPayment extends Payment{
    
    private enum coinDenominations{
        DOLLAR(1.00), QUARTER(.25), DIME(.10), NICKLE(.05), PENNY(.01);
        
        private double value;
        
        coinDenominations(double value){
            this.value = value;
        }
        public double getValue(){
            return value;
        }
    }//end enumeration
    
    private double cashGiven;
    private int[] changeCoins = new int[5]; //number of each coin in change will be stored in change array
    private double change; //change this to = cashgiven - amount
    
    CashPayment(){}
    CashPayment(double cashGiven,double amount){
        super.amount = amount;
        this.cashGiven = cashGiven;
    }
    
    @Override
    public boolean submitPayment(){
        final double[] coinValues = new double[] {coinDenominations.DOLLAR.getValue(),coinDenominations.QUARTER.getValue(),
            coinDenominations.DIME.getValue(),coinDenominations.NICKLE.getValue(),coinDenominations.PENNY.getValue()};
        System.out.println("****");
        change = cashGiven - amount;
        int i;
        if(cashGiven>=amount){
            //coinDenominations.DIME.getValue();
            for(i = 0; i<changeCoins.length; i++){ //maybe change to coinValues.length
                changeCoins[i] = 0;
                while(change >= coinValues[i]){
                    changeCoins[i]++;
                    change-=coinValues[i];
                    System.out.print("**");
                }
            }//end for loop
             
        }else{
            return false;
        }
        //****return boolean or return change array??
        
        return true;
    }//end function submitPayment
    
    public double getCashGiven(){
        return cashGiven;
    }
    public double getChange(){
        return change;
    }
   public int[] getChangeCoins(){
       return changeCoins;
   }

    public void setCashGiven(double cashGiven){
        this.cashGiven = cashGiven;
    }
    
}//end CashPayment class

