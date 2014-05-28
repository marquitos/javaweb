/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.reportes.clientes;

import com.cliente.conexion.ConexionBD;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author marcos
 */
@WebServlet(name = "listadoClientes", urlPatterns = {"/listadoClientes"})
public class listadoClientes extends HttpServlet {

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
        //PrintWriter out = response.getWriter();
        
        try{
            Connection con = ConexionBD.conexion();                
          /*Establecemos la ruta del reporte*/ 
          File reportFile = new File(request.getSession(true).getServletContext().getRealPath("/reportes/listadoClientes.jasper")); 
          // getServletContext() nos devuelve a que session pertenece
          /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/ 
          Map parameters = new HashMap();                   
         // parameters.put("idCliente", idCliente); 
          /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/ 
          byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, con); 
          /*Indicamos que la respuesta va a ser en formato PDF*/ 
          response.setContentType("application/pdf"); 
          response.setContentLength(bytes.length);
          ServletOutputStream ouputStream = response.getOutputStream();
          ouputStream.write(bytes, 0, bytes.length);
          /*Limpiamos y cerramos flujos de salida*/ 
          ouputStream.flush(); 
          ouputStream.close(); 
        
        }catch(JRException jre)
        {
            jre.getMessage();
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
