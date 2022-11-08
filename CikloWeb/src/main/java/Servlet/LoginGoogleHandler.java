package Servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import DAO.CustomerDAO;
import Model.Customer;
import System.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(urlPatterns = {"/LoginGoogleHandler"})
public class LoginGoogleHandler extends HttpServlet {

    static CustomerDAO cusDao = new CustomerDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String code = request.getParameter("code");
        String accessToken = getToken(code);
        Customer user = getUserInfo(accessToken);
        System.out.println(user);
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("User", user);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            request.setAttribute("Error", "<i class=\"bi bi-exclamation-triangle-fill\"></i>THIS ACCOUNT IS EXIST");
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static Customer getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
//        Customer googlePojo = new Gson().fromJson(response, Customer.class);
//        return googlePojo;

        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> map = mapper.readValue(response, Map.class);
        JSONObject obj = new JSONObject(map);
        System.out.println(response);

        Customer cus = null;

        ArrayList<Customer> cl = cusDao.getAllCustomer();
        if (!checkDuplicateUserName(String.valueOf(obj.get("email")).split("@gmail.com")[0], cl)) {
            cusDao.addCustomer(autoIncrementIDCus(cl), String.valueOf(obj.get("email")).split("@gmail.com")[0], String.valueOf(obj.get("email")), String.valueOf(obj.get("email")).split("@gmail.com")[0], "1234", null);
            cus = new Customer(autoIncrementIDCus(cl), String.valueOf(obj.get("email")).split("@gmail.com")[0], String.valueOf(obj.get("email")), String.valueOf(obj.get("email")).split("@gmail.com")[0], "1234", null);
        }
        return cus;
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

    static String autoIncrementIDCus(ArrayList<Customer> cl) {
        String id = "KH";
        int noId = 1;

        for (int i = 0; i < cl.size(); i++) {
            String[] str = cl.get(i).getCusID().split("KH");
            for (int j = 1; j < str.length; j++) {
                int no = Integer.parseInt(str[j]);
                while (noId <= no) {
                    noId++;
                }
            }
        }
        return id + noId;
    }

    static boolean checkDuplicateUserName(String name, ArrayList<Customer> cl) {
        for (int i = 0; i < cl.size(); i++) {
            if (cl.get(i).getCusUserName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
