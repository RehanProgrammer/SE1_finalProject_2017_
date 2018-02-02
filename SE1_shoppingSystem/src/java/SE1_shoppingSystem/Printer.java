
package SE1_shoppingSystem;

import java.io.*;


public class Printer {
    
    
    
    public boolean print(String str){
        
        String[] printStr = str.split(",");
        
        File file = new File("C:\\Users\\lucer_000\\Documents\\GitHub\\SE1_finalProject_2017_/shoppingSystemPrint.txt");
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

/*
    
    }finally {
            try {
                if (out != null) {
                    out.close();//if file not opened fin will = null; 
                }
                }catch(IOException e2) {
                System.out.println("IOException caught2: " + e2);
                return false;
            }//end try/catch
        }//end try/catch/finally

    */