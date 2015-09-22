/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.ConnectDB.res;
import static data.ConnectDB.stm;
import entity.OrderTaxi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hanna
 */
public class DAO_Ord implements DAO<OrderTaxi>{

    @Override
    public ArrayList<OrderTaxi> select() {
        ArrayList<OrderTaxi> result = new ArrayList<>();
        int elem=0;
        
        try {     
            res =  stm.executeQuery("SELECT * FROM 'OrderTaxi';");
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ord.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
        try {
            while (res.next()) {
                result.add(new OrderTaxi());
                result.get(elem).setPhone(res.getInt("Phone"));
                result.get(elem).setName(res.getString("Name"));
                result.get(elem).setMarka(res.getString("Marka"));
                elem++;
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

     public ArrayList<OrderTaxi> select2(int pho) {
        ArrayList<OrderTaxi> result = new ArrayList<>();
        int elem=0;
        
        try {     
            res =  stm.executeQuery("SELECT * FROM 'OrderTaxi' Where 'OrderTaxi'.'Phone'="+pho);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ord.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
        try {
            while (res.next()) {
                result.add(new OrderTaxi());
                result.get(elem).setId(res.getInt("ID"));
                result.get(elem).setPhone(res.getInt("Phone"));
                result.get(elem).setName(res.getString("Name"));
                result.get(elem).setMarka(res.getString("Marka"));
                elem++;
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public void insert(OrderTaxi t) {
        try {
//            res = stm.executeQuery("select max('OrderTaxi'.'ID') from 'OrderTaxi'");
//            t.setId(res.getInt(1)+1001);
            stm.execute("INSERT INTO 'OrderTaxi' VALUES(" +t.getId()+","+t.getPhone()+",'"+t.getName()+"','"+t.getMarka()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void update(int id, OrderTaxi t) {
        try {
            stm.execute("UPDATE 'OrderTaxi' set"
                   
                    + "'Marka'='"+t.getMarka()+"'"
                    + "WHERE 'OrderTaxi'.'Phone' ="+id                 
            );
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void delete(int id) {
        try {
            stm.execute("Delete FROM 'OrderTaxi' where 'OrderTaxi'.'ID' = " + id   );
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
