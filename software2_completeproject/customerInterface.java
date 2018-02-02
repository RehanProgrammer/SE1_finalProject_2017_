package hw4.finals;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@SuppressWarnings("unused")
@WebServlet("/customerInterface")
public class customerInterface extends HttpServlet {
	//Boolean flag = true;
	String scanner = null;
	purchaseOrder_Manager pos = new purchaseOrder_Manager();
	private static final long serialVersionUID = 1L;


	public customerInterface() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String receipt[];
		response.setContentType("text/html");

		int transactionId;
		if (request.getParameter("scanner2")!=null) {
			out.write("first if");
			// flag = false;
		}
		else if(request.getParameter("cancel")!=null){
            pos.deleteCart();
            response.sendRedirect("index.jsp");
        }
		else if(request.getParameter("cancel")!=null){
            pos.deleteCart();
            response.sendRedirect("index.jsp");
        }
		else if(request.getParameter("start")!=null){
            pos.deleteCart();
            response.sendRedirect("scanner.jsp");
        }

		else if (request.getParameter("Weight")!=null) {
			double weight = Double.parseDouble(request.getParameter("weight"));
			pos.setWeight(weight);
			if (pos.successfullOrder(scanner)) {
				response.sendRedirect("scanner1.jsp");
			}
			//flag = true;
		}//end of weight if

		else if (request.getParameter("Scanner")!=null) {
			scanner = request.getParameter("scanner");
			//String scanner = request.getParameter("scanner");
			int scanner1 = Integer.parseInt(scanner);
			if (scanner1>0 && scanner1<4) {
				response.sendRedirect("weightPage.jsp");
			}//end of checking scanner

			else {
				//double x = order.getTotal();
				//redirect them to a weight.jsp if sanner number = a fruit
				if (pos.successfullOrder(scanner)) {
					//flag = true;
					//double x1 = order.getTotal();
					
					response.sendRedirect("scanner1.jsp");
				}
			}//end of else 
		}//end of Scanner if
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		else if (request.getParameter("Scanner1")!=null) {
			scanner = request.getParameter("scanner");
			int scanner1 = Integer.parseInt(scanner);
			if (scanner1>0 && scanner1<4) {
				response.sendRedirect("weightPage.jsp");
			}//end of checking scanner
			else {
				if (pos.successfullOrder(scanner)) {
					double x1 = order.getTotal();
					response.sendRedirect("scanner1.jsp");
				}
			}//end of else 
		}//end of Scanner if

		else if(request.getParameter("CashPayment")!=null){
			String cashGiven;

			double cash = 0.0;
			double total=0.0;
			out.write("Cash Payment");
			cashGiven = request.getParameter("cashGiven");
			cash = Double.parseDouble(cashGiven);
			if(pos.orderWithCash(cash)){
				total = pos.getTotal();
				pos.sendToPrinter(pos.getReceipt());
				//double total1 = pos.getTotal();
				pos.insertInotTransaction(total);
				pos.deleteCart();
				double total2 =0.0;
				pos.setTotal(total2);
				response.setHeader("Refresh", "5;url=index.jsp");
				
			}else{
				out.print("<br/>Renter correct cash amount.");
				RequestDispatcher rd = request.getRequestDispatcher("CashPayment.jsp");
				rd.include(request,response);
				receipt = null;
			}

		}//end CashPayment

		else if(request.getParameter("cardTypeDebit")!=null){


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
					
					

					pos.sendToPrinter(pos.getReceipt());
                    double total = pos.getTotal();
					pos.insertInotTransaction(total);
					pos.deleteCart();
					double total2 =0.0;
					pos.setTotal(total2);
					response.setHeader("Refresh", "5;url=index.jsp");
				}
				else{
					out.write("Debit Card declined. Select new payment method.");
					RequestDispatcher rd = request.getRequestDispatcher("payHere.jsp");
					rd.include(request,response);
					receipt = null;
				}
				//return amount+","+authNo+","+cardNo+","+expDate+","+cvv+","+pin;

			}//end else

		}//end elseif  cardTypeDebit

		else if(request.getParameter("cardTypeCredit")!=null){


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
					pos.sendToPrinter(pos.getReceipt());
					double total2 =0.0;
					pos.setTotal(total2);
					response.setHeader("Refresh", "5;url=index.jsp");

				}else{
					out.write("Credit Card declined. Select new payment method.");
					RequestDispatcher rd = request.getRequestDispatcher("payHere.jsp");
					rd.include(request,response);
					receipt = null;
				}


			}//end else

		}//end elseif CardTypeCredit
	}


}//end of class



/*String order = session.getAttribute("order").toString();
int quantity = Integer.parseInt((String) session.getAttribute("quantity").toString());
 purchaseOrder_Manager pos = new purchaseOrder_Manager();
 if(pos.successfullOrder(order, quantity)) {
	session.invalidate();
	response.sendRedirect("moreOrder.jsp");
}
else {
	String message = order + " is Not available in database";
	request.setAttribute("message", message);
	request.getRequestDispatcher("/index.jsp").forward(request, response);
}*/
/*int scanner1 = Integer.parseInt(scanner);
if (scanner1>0 && scanner1<4) {
	response.sendRedirect("weightPage.jsp");
	double weight = Double.parseDouble(request.getParameter("weight"));

}*/
