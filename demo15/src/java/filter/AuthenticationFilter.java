/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author The Anh
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
    private ServletContext context;
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("Auth");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String uri = req.getRequestURI();
//        this.context.log("Requested Resource::" + uri);
        
        HttpSession session = req.getSession(false);
        
        String userName = null;
        try {
            userName = (String) session.getAttribute("username");
        } catch (Exception e) {
            userName = null;
            
        }
        if(userName == null && uri.contains("auth")){
            this.context.log("Unauthorized access request");
            res.sendRedirect("../LoginServlet");
        } else{
            chain.doFilter(request, response);
        }
                
    }

    @Override
    public void destroy() {

    }
    
    
    
}
