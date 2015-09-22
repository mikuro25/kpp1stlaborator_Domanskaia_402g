/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Users_1;
import java.util.ArrayList;
import static data.ConnectDB.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hanna
 * 
 */
public class UserDAO implements DAO<Users_1>{

    @Override
    public ArrayList select() {
        ArrayList<Users_1> res_sell = new ArrayList<>();
        int elem=0;
        try {
            res =  stm.executeQuery("SELECT * FROM 'Users';");     
                       
            while (res.next()) {
                res_sell.add(new Users_1());
                res_sell.get(elem).setId(res.getInt("ID"));
                res_sell.get(elem).setNikname(res.getString("Nikname"));
                res_sell.get(elem).setPassword(res.getString("Password"));
                elem++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return res_sell;
   }

    @Override
    public void insert(Users_1 t) {
        try {
            res = stm.executeQuery("SELECT MAX('Users'.'ID') from 'Users'");
    
            t.setId(res.getInt(1)+1);
            stm.execute("INSERT INTO 'Users' VALUES(" +t.getId()+",'"+t.getNikname()+"','"+t.getPassword()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void delete(int id) {
  
        try {
            stm.execute("Delete FROM 'Users' where 'Users'.'ID' = " + id   );
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void update(int id, Users_1 t) {
        try {
            stm.execute("UPDATE 'Users' set"
                    + "'Nikname'='"+t.getNikname()+"',"
                     + "'Password'='"+t.getPassword()+"'"
                    + "WHERE 'Users'.'ID' ="+id                 
            );
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
