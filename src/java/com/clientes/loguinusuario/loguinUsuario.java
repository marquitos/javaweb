/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clientes.loguinusuario;

import com.cliente.conexion.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcos
 */
@WebServlet(name = "loguinUsuario", urlPatterns = {"/loguinUsuario"})
public class loguinUsuario extends HttpServlet {
    private String nombre,user, pass, attnombre;

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
        PrintWriter out = response.getWriter();
        
        this.user = request.getParameter("user");
        this.pass = request.getParameter("pass");
        
        if(user != null && pass != null)
        {            
           HttpSession session = request.getSession(true);
                                         
               try{
                Connection cnn = ConexionBD.conexion();
                Statement st = cnn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE nombre = '"+this.user+"' and "
                        + "password = '"+this.pass+"'");
                if(rs.next()){
                    this.attnombre = rs.getString("nombre");
                    session.setAttribute("us", attnombre);
                    response.sendRedirect("listadoCliente.jsp");                    
                }else{
                    response.sendRedirect("errorLogueo.jsp");                    
                    
                }
               }catch(SQLException er)
               {
                   out.println("No se encontro resultados" + er.getMessage());
               }
           
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
