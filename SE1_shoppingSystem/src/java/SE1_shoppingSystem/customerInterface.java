package SE1_shoppingSystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hw4;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@WebServlet(urlPatterns = {"/customerInterface"})
public class customerInterface extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String order = session.getAttribute("order").toString();
		int quantity = Integer.parseInt((String) session.getAttribute("quantity").toString());
		purchaseOrder_Manager pos = new purchaseOrder_Manager();
		if(pos.successfullOrder(order, quantity)) {
			response.sendRedirect("moreOrder.jsp");
		}
		
				
	}
}
