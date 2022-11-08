/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Driver;

import DAO.DriverDAO;
import Model.Driver;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "DriverChangeStation", urlPatterns = {"/DriverChangeStation"})
public class DriverChangeStation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Driver d = (Driver)session.getAttribute("User");
        String sid = request.getParameter("sID");
        System.out.println("ID Driver: " + d.getDriverID() + " - Station ID: " + sid);
        DriverDAO dao = new DriverDAO();
        dao.updateDriverStation(d.getDriverID(), sid);

    }

}
