/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4.finals;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Lauren
 */
@WebServlet(name = "InventoryServlet", urlPatterns = {"/InventoryServlet"})
public class InventoryServlet extends HttpServlet {
private EmployeeInterface employeeInterface = new EmployeeInterface();
     Item item = new Item();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        PrintWriter out = response.getWriter();
       
        if (request.getParameter("scanRestock") != null){
            int id, quantity;    
            id = Integer.parseInt(request.getParameter("itemId"));
            quantity = Integer.parseInt(request.getParameter("restockQuantity"));   
            
            boolean test = employeeInterface.restockItem(id, quantity);
          
            if (test == true){
                out.write("The quantity has been updated.");
                response.setHeader("Refresh", "5;url=index.jsp");
                
            } else{
                out.write("false");
                response.sendRedirect("createNewItem.jsp");
            }
                
            }
        if (request.getParameter("scanViewUpdateInventory") != null){
                item = employeeInterface.viewItemInfo(request.getParameter("itemId"));
                
                /*
                out.write("Item name: " + item.itemName + "\n");
                out.write("Item price: " + item.itemPrice + "\n");
                out.write("Item quantity: " + item.itemQuantity + "\n");
                out.write("Item description: " + item.itemDescritption + "\n");
                out.write("Item discount: " + item.itemDiscount + "\n");
                */
                request.setAttribute("flagg", "1");
                request.setAttribute("id", item.itemId);
                request.setAttribute("name", item.itemName);
                request.setAttribute("price", item.itemPrice);
                request.setAttribute("quantity", item.itemQuantity);
                request.setAttribute("description", item.itemDescription);
                request.setAttribute("discount", item.itemDiscount);
              
                request.getRequestDispatcher("/viewUpdateInventory.jsp").forward(request, response);
        }
        if (request.getParameter("updateButton") != null){
            Double newPrice, newDiscount;
            int newQuantity, newId;
            
            newPrice =  Double.parseDouble(request.getParameter("updatedPrice"));
            newQuantity = Integer.parseInt(request.getParameter("updatedQuantity"));
            newDiscount = Double.parseDouble(request.getParameter("updatedDiscount"));
            newId = Integer.parseInt(request.getParameter("updatedId"));
            
            item.itemId = newId;
            item.itemName = request.getParameter("updatedName");
            
            item.itemPrice = newPrice;
            item.itemQuantity = newQuantity;
            item.itemDescription = request.getParameter("updatedDescription");
            item.itemDiscount = newDiscount;
            
            employeeInterface.updateItem(item);
            out.write("The item information has been updated.");
            response.setHeader("Refresh", "5;url=index.jsp");
        
        }
        if (request.getParameter("addButton") != null){
            Double newPrice, newDiscount;
            int newQuantity, newId;
            
            newPrice =  Double.parseDouble(request.getParameter("newPrice"));
            newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
            newDiscount = Double.parseDouble(request.getParameter("newDiscount"));
            newId = Integer.parseInt(request.getParameter("newId"));
            
            item.itemId = newId;
            item.itemName = request.getParameter("newName");
            
            item.itemPrice = newPrice;
            item.itemQuantity = newQuantity;
            item.itemDescription = request.getParameter("newDescription");
            item.itemDiscount = newDiscount;
            
            boolean test = employeeInterface.createNewItem(item);
          
            if (test == true){
                out.write("The item has succesfully been added to the inventory. ");
                response.setHeader("Refresh", "5;url=index.jsp");
            } else{
                out.write("An error occured. Please go to the main menu and try again. ");
                response.setHeader("Refresh", "5;url=index.jsp");
               
            }
            
        }
        if(request.getParameter("inventoryMsg")!=null) {
        	//out.println("were in");
        	InventoryReporter msg = new InventoryReporter();
        	if(msg.printInventoryReport()) {
        		response.setHeader("Refresh", "5;url=index.jsp");
        	}
        }
        if (request.getParameter("dailyReport")!=null) {
        	DailyReport dr = new DailyReport();
        	dr.callAll_methods();
        	response.setHeader("Refresh", "5;url=index.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}