package Servlet.Driver;

import DAO.*;
import Model.*;
import System.AvgEarningDriver;
import System.SaveToJSON;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;

import jakarta.servlet.http.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverPage extends HttpServlet {

    SaveToJSON save = new SaveToJSON();
    AvgEarningDriver avg = new AvgEarningDriver();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            Driver driver = (Driver) session.getAttribute("User");

            BillDAO bDAO = new BillDAO();
            StationDAO sDAO = new StationDAO();
            CustomerDAO cDAO = new CustomerDAO();

            ArrayList<Station> sl = sDAO.getAllStation();
            ArrayList<Bill> bl = bDAO.getAllBillOfDriver(driver.getDriverID());
            ArrayList<Customer> cl = cDAO.getAllCustomer();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Kiem tra so bill cua driver trong 1 tuan
            ArrayList<Bill> fl = new ArrayList<>();
            for (int i = 0; i < bl.size(); i++) {
                if (isDateInCurrentWeek(sdf.parse(bl.get(i).getDate()))) {
                    fl.add(bl.get(i));
                }
            }
            session.setAttribute("bills", fl);

            // hien cac chuyen da nhan trong ngay
            ArrayList<Bill> currBill = new ArrayList<>();
            for (int i = 0; i < bl.size(); i++) {
                if (isDateNow(sdf.parse(bl.get(i).getDate()))) {
                    currBill.add(bl.get(i));
                }
            }
            session.setAttribute("currentBill", currBill);

            // So tien va chuyen da nhan trung binh 1 thang
            ArrayList<Bill> monthBill = new ArrayList<>();
            for (int i = 0; i < bl.size(); i++) {
                if (isCurrentMonth(sdf.parse(bl.get(i).getDate()))) {
                    monthBill.add(bl.get(i));
                }
            }
            session.setAttribute("monthBill", monthBill);

            session.setAttribute("customers", cl);
            session.setAttribute("stations", sl);
            session.setAttribute("bill", bl);
            response.sendRedirect("./Driver/DriverPage.jsp"); 
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DriverPage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DriverPage.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean isDateInCurrentWeek(Date date) {
        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        int targetYear = targetCalendar.get(Calendar.YEAR);
        return week == targetWeek && year == targetYear;
    }

    public boolean isDateNow(Date date) {
        LocalDate now = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = now.atStartOfDay(systemTimeZone);
        Date utilDate = Date.from(zonedDateTime.toInstant());

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(utilDate);
        cal2.setTime(date);
        return cal2.get(Calendar.DAY_OF_YEAR) == cal1.get(Calendar.DAY_OF_YEAR)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);

    }

    public boolean isCurrentMonth(Date date) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date);
        cal2.setTime(new Date());
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }
}
