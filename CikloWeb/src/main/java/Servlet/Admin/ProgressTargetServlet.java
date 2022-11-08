/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ProgressTargetServlet", urlPatterns = {"/ProgressTargetServlet"})
public class ProgressTargetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double week = Double.parseDouble(request.getParameter("week"));
        double month = Double.parseDouble(request.getParameter("month"));
        double year = Double.parseDouble(request.getParameter("year"));
        System.out.println(week + " - " + month + " - " + year);
        double sumYear = 0;
        double sumMonth = 0;
        double sumWeek = 0;

        HttpSession session = request.getSession();
        sumWeek = (Double) session.getAttribute("TotalWeek");
        sumMonth = (Double) session.getAttribute("TotalMonth");
        sumYear = (Double) session.getAttribute("TotalYear");
        System.out.println(sumWeek + " - " + sumMonth + " - " + sumYear);

        Map<String, Double> total = new HashMap<String, Double>();
        total.put("week", (sumWeek/week)*100);
        total.put("month", (sumMonth/month)*100);
        total.put("year", (sumYear/year)*100);

        response.setContentType("application/json");

        Gson gson = new Gson();
        String json = gson.toJson(total);

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(json.getBytes());
        outputStream.flush();
    }

}
