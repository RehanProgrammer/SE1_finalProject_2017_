
package SE1_shoppingSystem;
import java.util.Random;

public class BankInterface {
    String authorizationNo;
    Random rand = new Random();
   
    public boolean getAuthorization(String cardNo, String expDate, String cvv, double amount){
        int authNo = rand.nextInt(100000000) +1;
        authorizationNo = Integer.toString(authNo);
        
        return true;
    }
    
    public String getAuthorizationNo(){
        return authorizationNo;
    }
    
}
