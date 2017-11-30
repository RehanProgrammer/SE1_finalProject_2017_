package SE1_shoppingSystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.PrintWriter;


@SuppressWarnings("unused")
@WebServlet("/customerInterface")
public class customerInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       purchaseOrder_Manager pos = new purchaseOrder_Manager();
        
    public customerInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
                PrintWriter out = response.getWriter();
                
                if(request.getParameter("action1")!=null){
                    
		String scanner = request.getParameter("scanner");
                out.write("testing");
		if (pos.successfullOrder(scanner)) {
			response.sendRedirect("scanner1.jsp");
		}
    
                }//end action1
                
                
                else if(request.getParameter("CashPayment")!=null){
                    String cashGiven;
                    double cash = 0.0;
                    double cash1 = 0.0;
                     double total=0.0;
                    out.write("action2");
                    cashGiven = request.getParameter("cashGiven");
                    cash = Double.parseDouble(cashGiven);
                    
                    total = pos.getTotal();
                    pos.orderWithCash(cash,total);
                    
                }
                
                else if(request.getParameter("cardTypeDebit")!=null){
                    
                    
                    String cardNo = request.getParameter("cardNo");
                    String expDate = request.getParameter("expDate");
                    String cvv = request.getParameter("cvv");
                    String pin = request.getParameter("pin");
                    
                    if(pos.orderWithCard(cardNo, expDate, cvv, pin)){
                        out.write("Debit Card accepted.");
                    }
                    
                    
                }
                 else if(request.getParameter("cardTypeCredit")!=null){
                    
                    
                    String cardNo = request.getParameter("cardNo");
                    String expDate = request.getParameter("expDate");
                    String cvv = request.getParameter("cvv");
                    
                    
                    if(pos.orderWithCard(cardNo, expDate, cvv)){
                        out.write("Credit Card accepted.");
                    }
                    
                  
                }
                
                
			
                
	}
        
        
		

}
