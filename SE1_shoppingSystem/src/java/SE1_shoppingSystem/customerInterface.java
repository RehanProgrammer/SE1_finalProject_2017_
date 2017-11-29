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
       
    
    public customerInterface() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		String scanner = request.getParameter("scanner");
		purchaseOrder_Manager pos = new purchaseOrder_Manager();
                PrintWriter out = response.getWriter();
                out.write("testing");
		if (pos.successfullOrder(scanner)) {
			response.sendRedirect("scanner.jsp");
		}
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
				
	}
		

}
