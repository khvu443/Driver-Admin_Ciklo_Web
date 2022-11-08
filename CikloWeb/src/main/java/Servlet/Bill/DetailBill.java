/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Bill;

import DAO.*;
import Model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.*;

@WebServlet(name = "BillDetail", urlPatterns = {"/BillDetail"})
public class DetailBill extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();

            String bid = request.getParameter("DetailID");

            BillDAO billDao = new BillDAO();
            BillDetailDAO dbDAO = new BillDetailDAO();

            CustomerDAO cusDao = new CustomerDAO();
            DriverDAO driverDao = new DriverDAO();

            Bill bill = billDao.getBillBy(bid);
            ArrayList<BillDetail> bd = dbDAO.getDetailOf(bid);

            session.setAttribute("bill", bill);
            session.setAttribute("detail", bd);
            session.setAttribute("cus", cusDao.getAllCustomer());
            session.setAttribute("driver", driverDao.getAllDriver());
            
            response.sendRedirect("Driver/DetailBill/DriverBillDetail.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
