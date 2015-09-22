/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1st.apple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

 

/**
 *
 * @author Hanna
 */
public class Apple   {
    
    /**
     * @param args the command line arguments
     */
   public static Connection conn;
   public static Statement statmt;
   public static ResultSet resSet;
   
   // connect
   public static void connect() throws ClassNotFoundException, SQLDataException, SQLException{
       conn = null;
       Class.forName("org.sqlite.JDBC");
       conn = DriverManager.getConnection("jdbc:sqlite:TEST1.sdb");
       System.out.println("Data Base Connected");
   }
   // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
       {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
        
        System.out.println("Таблица создана или уже существует.");
       }
    
    // --------Заполнение таблицы--------
    public static void WriteDB() throws SQLException
    {
           statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
           statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
           statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");
          
           System.out.println("Таблица заполнена");
    }
    
    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException
       {
        resSet = statmt.executeQuery("SELECT * FROM users");
        
        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  name = resSet.getString("name");
            String  phone = resSet.getString("phone");
             System.out.println( "ID = " + id );
             System.out.println( "name = " + name );
             System.out.println( "phone = " + phone );
             System.out.println();
        }	
        
        System.out.println("Таблица выведена");
        }
    
        // --------Закрытие--------
        public static void CloseDB() throws ClassNotFoundException, SQLException
           {
            conn.close();
            statmt.close();
            resSet.close();
            
            System.out.println("Соединения закрыты");
           }

   
            
    
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        
        Apple.connect();
        Apple.CreateDB();
        Apple.WriteDB();
        Apple.ReadDB();
        Apple.CloseDB();
// TODO code application logic here
    }
    
}
