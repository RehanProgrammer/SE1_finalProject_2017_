package SE1_shoppingSystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;


@SuppressWarnings("unused")
@WebServlet("/customerInterface")
public class customerInterface extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       purchaseOrder_Manager pos = new purchaseOrder_Manager();
        String scanner = null;
        
    public customerInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                String[] receipt;
                
                if(request.getParameter("start")!=null){
                    pos.deleteCart();
                    pos.setTotal(0.0);
                    response.sendRedirect("scanner.jsp");
                }
                if(request.getParameter("cancel")!=null){
                    pos.deleteCart();
                    response.sendRedirect("index.jsp");
                }
                
                
                if(request.getParameter("scanner")!=null){
                    
		String scanner = request.getParameter("scannercode");
                out.write("testing");

                    if (pos.successfullOrder(scanner)) {
                        out.write("testing");
                        response.sendRedirect("scanner1.jsp");
                    }
                
                }//end action1/////////////////////////////////////////////////////
                if (request.getParameter("Weight") != null) {
                    double weight = Double.parseDouble(request.getParameter("weight"));
                    pos.setWeight(weight);
                    if (pos.successfullOrder(scanner)) {
                        response.sendRedirect("scanner1.jsp");
                    }
                        //flag = true;
                }//end of weight if
                if(request.getParameter("CashPayment")!=null){
                    String cashGiven;
                    
                    double cash = 0.0;
                    double total;
                    out.write("Cash Payment");
                    cashGiven = request.getParameter("cashGiven");
                    cash = Double.parseDouble(cashGiven);
      
                        if(pos.orderWithCash(cash)){
                            total = pos.getTotal();
                            
                            if(pos.sendToPrinter(pos.getReceipt())){
                                out.write("sent to pritner successfully");
                                
                            }else{
                                out.write("not sent to printer");
                            }
                          
                            
                           if(pos.insertIntoTransaction(total)){
                               out.write("true");
                           }
                           else{
                               out.write("false");
                           }
                            
                            pos.deleteCart();
                            //last thing we do
                        }else{
                            out.print("<br/>Renter correct cash amount.");
                            RequestDispatcher rd = request.getRequestDispatcher("CashPayment.jsp");
                            rd.include(request,response);
                            receipt = null;
                        }

                }//end CashPayment
                
                if(request.getParameter("cardTypeDebit")!=null){
                    
                    
                    String cardNo = request.getParameter("cardNo");
                    String expDate = request.getParameter("expDate");
                    String cvv = request.getParameter("cvv");
                    String pin = request.getParameter("pin");
            
                    
                    if(cardNo.length()!=8){
                        out.print("Invalid Card Number. Must be 8 numbers long.\n");
                        RequestDispatcher rd = request.getRequestDispatcher("DebitCardPayment.jsp");
                        rd.include(request,response);
                        
                    }else if(expDate.length()!=4 || Integer.valueOf(expDate.substring(0,1)) >12
                            || Integer.parseInt(expDate.substring(0,1)) <1){
                        out.write("Invalid expDate");
                        RequestDispatcher rd = request.getRequestDispatcher("DebitCardPayment.jsp");
                        rd.include(request,response);
                        
                    }else if(cvv.length()!=3){
                        out.write("Invalid cvv");
                        RequestDispatcher rd = request.getRequestDispatcher("DebitCardPayment.jsp");
                        rd.include(request,response);
                    }else if(pin.length()!=4){
                        out.write("Invalid pin");
                        RequestDispatcher rd = request.getRequestDispatcher("DebitCardPayment.jsp");
                        rd.include(request,response);
                    }else{

                        if(pos.orderWithCard(cardNo, expDate, cvv, pin)){
                            
                            double total = pos.getTotal();
                            
                            if(pos.sendToPrinter(pos.getReceipt())){
                                out.write("sent to pritner successfully");
                                
                            }else{
                                out.write("not sent to printer");
                            }
                            
                            
                            
                           if(pos.insertIntoTransaction(total)){
                               out.write("true");
                           }
                           else{
                               out.write("false");
                           }
                            
                            pos.deleteCart();
                            
                            
                        }else{
                            out.write("Debit Card declined. Select new payment method.");
                            RequestDispatcher rd = request.getRequestDispatcher("payHere.jsp");
                            rd.include(request,response);
                            receipt = null;
                        }
                        //return amount+","+authNo+","+cardNo+","+expDate+","+cvv+","+pin;

                        }//end else
                        
                }//end elseif  cardTypeDebit
                
                 if(request.getParameter("cardTypeCredit")!=null){
                    
                    
                    String cardNo = request.getParameter("cardNo");
                    String expDate = request.getParameter("expDate");
                    String cvv = request.getParameter("cvv");
                    
                    if(cardNo.length()!=8){
                        out.print("Invalid Card Number. Must be 8 numbers long.\n");
                        RequestDispatcher rd = request.getRequestDispatcher("CreditCardPayment.jsp");
                        rd.include(request,response);
                        
                    }else if(expDate.length()!=4 || Integer.valueOf(expDate.substring(0,1)) >12
                            || Integer.parseInt(expDate.substring(0,1)) <1){
                        out.write("Invalid expDate");
                        RequestDispatcher rd = request.getRequestDispatcher("CreditCardPayment.jsp");
                        rd.include(request,response);
                        
                    }else if(cvv.length()!=3){
                        out.write("Invalid cvv");
                        RequestDispatcher rd = request.getRequestDispatcher("CreditCardPayment.jsp");
                        rd.include(request,response);
                    }else{

                        if(pos.orderWithCard(cardNo, expDate, cvv)){
                            
                            if(pos.sendToPrinter(pos.getReceipt())){
                                out.write("sent to pritner successfully");
                                
                            }else{
                                out.write("not sent to printer");
                            }
                            
                            double total = pos.getTotal();
                            
                           if(pos.insertIntoTransaction(total)){
                               out.write("true");
                           }
                           else{
                               out.write("false");
                           }
                            
                            pos.deleteCart();
                            
                        }else{
                            out.write("Credit Card declined. Select new payment method.");
                            RequestDispatcher rd = request.getRequestDispatcher("payHere.jsp");
                            rd.include(request,response);
                            receipt = null;
                        }

                        
                        }//end else
                  
                }//end elseif CardTypeCredit
                
                
			
                
	}
        
        
		

}
