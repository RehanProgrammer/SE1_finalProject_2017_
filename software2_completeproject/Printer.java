package hw4.finals;
import java.io.*;


public class Printer {
    
    
    
    public boolean print(String str){
        
        String[] printStr = str.split(",");
        
        File file = new File("C:\\software_engineering\\hw4_final/shoppingSystemPrint.txt");
        PrintWriter out = null;
        try{
            
            
            out = new PrintWriter(new FileWriter(file,true));
            
            for(String x: printStr){
                out.println(x);
            }
            out.println();
                        
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e2){
            e2.printStackTrace();
        }finally{
            if(out!=null){
                out.close();
            }
        }
        
       return true;
    }
}//end class
