/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cliente.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;

/**
 *
 * @author marcos
 */
@Stateless
public class ConexionBD {
    private static String user = "root";
    private static String pass = "msa32307545";
    private static String bd = "reporte_cliente";
    private static String uri = "jdbc:mysql://localhost/" + bd;
    
    public static Connection conexion()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(uri,user,pass);            
        }catch(Exception ex)
        {
            System.out.println("No se logro la conexion");
        }
    
        return con;
    }
    
    public static ResultSet query_all()
    {
        ResultSet rs = null;
       try{ 
        Connection cnn = ConexionBD.conexion();
        Statement st = cnn.createStatement();
        rs = st.executeQuery("SELECT * FROM clientes");
       }catch(SQLException ex)
       {
           System.out.println("Error en la BD..." + ex.getMessage());
       }
       return rs;
    }
            
        
}
