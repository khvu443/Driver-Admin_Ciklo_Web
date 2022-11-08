/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package Filter;

import Model.*;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class AuthAdminFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String url = request.getRequestURI();

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("ID");

        System.out.println("id filter: " + id);

        if (url.contains("/Admin")) {
            if (id != null) {
                if (!id.contains("AD")) {
                    System.out.println("Don't Have permission");
                    response.sendRedirect("http://localhost:8080/CikloWeb/Error/404.jsp");
                }
                else
                {
                    fc.doFilter(req, res);
                }
            } else {
                System.out.println("Don't Have permission");
                response.sendRedirect("http://localhost:8080/CikloWeb/Error/404.jsp");
            }
        } else {

            fc.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }

}
