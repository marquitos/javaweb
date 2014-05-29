/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cliente.agregar;

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

/**
 *
 * @author marcos
 */
@WebServlet(name = "agregarCliente", urlPatterns = {"/agregarCliente"})
public class agregarCliente extends HttpServlet {
    String nombre, apellido, direccion, localidad, email, password;
    int telefono, bandera;

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
          
          this.nombre = request.getParameter("nombre");
          this.apellido = request.getParameter("apellido");
          this.direccion = request.getParameter("direccion");
          this.email = request.getParameter("correo");
          this.telefono = Integer.parseInt(request.getParameter("tel"));
          this.password = request.getParameter("pass");
          this.localidad = request.getParameter("localidad");
          
          try
          {
             Connection cnn = ConexionBD.conexion();
             Statement st = cnn.createStatement();
             bandera = st.executeUpdate("insert into clientes values(null,'"+nombre+"','"+apellido+"',"
                     + "'"+direccion+"','"+email+"','"+telefono+"', '"+password+"',"
                     + "'"+localidad+"')");
             if(bandera == 1)
             {
                 response.sendRedirect("listadoCliente.jsp");
             }else
             {
                 out.println("Error....el registro no inserto");
                 out.println("<a href='agregarCliente.jsp'>Volver</a>");
             }
          
          }catch(SQLException ex)
          {
              ex.getMessage();
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
