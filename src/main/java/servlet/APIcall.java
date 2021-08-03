/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import PKGJava.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author sawan
 */
public class APIcall extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Integer> arr = new ArrayList<>();
            User us= new User();
             String  json="";
            
            String str = request.getParameter("response");
            for(int i=0;i<str.length();i++)
            {
                char c =str.charAt(i);
                if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')
                {
                Integer n = Integer.parseInt(""+str.charAt(i));
                
                if(n%2==0)
                {
                   us.even.add(n);
                }
                else
                {
                    us.odd.add(n);
                }
                
                
            }
           
            else
            {
                    us.is_success=false;
                    }
            }
            if(us.is_success)
            {
             json = "<br>{<br>";
			json += "\"is_success\": " + (us.is_success) + ",<br>";
                
			json += "\"user_Id\": " +(us.user_Id) + ",<br>";
                      
			json += "\"Odd\": " + us.odd + "<br>";
                        json += "\"even\": " + us.even + "<br>";
			json += "<br>}<br>";
                        JSONParser parser = new JSONParser();
                      //  JSONObject json1 = (JSONObject) parser.parse(json);

	
            }
            else{
                json = "<br>{<br>";
			json += "\"is_success\": " + (us.is_success) + ",<br>";
                
			json += "\"user_Id\": " +(us.user_Id) + ",<br>";
                        json += "<br>}<br>";
            }
            out.println(json);
//            System.out.println("servlet.APIcall.processRequest()"+us.user_Id);
//            out.print(us.is_success);
//            out.print(us.user_Id);
//            out.print(us.odd);
//            out.print(us.even);
            
            
        }    }

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
            throws ServletException, IOException,NullPointerException {
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
            throws ServletException, IOException,NullPointerException {
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
