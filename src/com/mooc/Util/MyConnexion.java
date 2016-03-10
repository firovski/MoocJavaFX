/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mooc.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Firas
 */
public class MyConnexion {
    private  Connection connection;
    private String url="jdbc:mysql://localhost:3306/finalquiz";
    private String user="root";
    private String pwd="";

    
    
    public Connection  connection() {
try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection ;
    }
    
}
