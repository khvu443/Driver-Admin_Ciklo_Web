/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.DriverDAO;
import Model.Driver;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

@MultipartConfig
@WebServlet(name = "AdminAddNewDriver", urlPatterns = {"/AdminAddNewDriver"})
public class AdminAddNewDriver extends HttpServlet {

    DriverDAO dao = new DriverDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("id", autoIncrementId_Driver(dao.getAllDriver()));
        request.getRequestDispatcher("Admin/AddDriver.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        String cccd = request.getParameter("cccd");

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

        Part part = request.getPart("file");
        String photoPath = request.getServletContext().getRealPath("/Admin/img");

        String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Path.of(photoPath))) {
            Files.createDirectories(Path.of(photoPath));
        }
        part.write(photoPath + "/" + filename);
        
       if(!checkDuplicateUserName(user, dao.getAllDriver()))
       {
           Driver d = new Driver(
                   autoIncrementId_Driver(dao.getAllDriver()),
                   name, user, pass, mail,phone, "img/"+filename, cccd, gender, true,
                   "ST1", true
           );
           
           System.out.println(d.toString());
           
           dao.addDriver(d);
           request.getRequestDispatcher("AdminDriverAccount").forward(request, response);
       }
       else
       {
           request.setAttribute("error", "Duplicate Name");
           request.getRequestDispatcher("Admin/AddDriver.jsp").forward(request, response);
       }

    }

    String autoIncrementId_Driver(ArrayList<Driver> cl) {
        String id = "D";
        int noId = 1;

        for (int i = 0; i < cl.size(); i++) {
            String[] str = cl.get(i).getDriverID().split("D");
            for (int j = 1; j < str.length; j++) {
                int no = Integer.parseInt(str[j]);
                while (noId <= no) {
                    noId++;
                }
            }
        }
        return id + noId;
    }

    boolean checkDuplicateUserName(String name, ArrayList<Driver> cl) {
        for (int i = 0; i < cl.size(); i++) {
            if (cl.get(i).getDriverUserName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
