/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Hanna
 */
public class ConnectDB {
    public static Connection con;
    public static Statement stm;
    public static ResultSet res;
    
   public static void Connect() throws ClassNotFoundException, SQLException  {
      con = null;
       Class.forName("org.sqlite.JDBC");
       con = DriverManager.getConnection("jdbc:sqlite:Orders.sqlite");
       stm = con.createStatement();
   }
    
}
