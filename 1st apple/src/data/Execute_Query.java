/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.ConnectDB.*;

import entity.OrderTaxi;
import java.util.Scanner;
import java.sql.SQLException;

/**
 *
 * @author Hanna
 */
public class Execute_Query {
public static Scanner sc = new Scanner(System.in,"cp1251");
public static Scanner sc2 = new Scanner(System.in,"cp1251");


 

/**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectDB.Connect();
        OrderTaxi odrertaxi = new OrderTaxi();
         
        DAO_Ord order_entity= new DAO_Ord();
        System.out.println("Приветствуем Вас! \n Выберите меню\n 1.Если хотите заказать такси\n2. Если хотите просмотреть заказы");
        int chous1 = sc.nextInt();
        if (chous1==1){
            System.out.println("\nName: ");
            odrertaxi.setMarka(sc.next());
            System.out.println("\nPhone: ");
            odrertaxi.setPhone(sc.nextInt());  
            System.out.println("Выберите автомобиль:\n1. Aston Martin\n2. Aston Martin\n3. Audi\n4. BMW");
            int chouseAuto = sc.nextInt();
             
            switch (chouseAuto){
                case 1:
                    odrertaxi.setMarka("Alfa Romeo");
                    System.out.println("Alfa");
                    break;
                case 2:
                   odrertaxi.setMarka("Aston Martin");break;
                case 3:
                   odrertaxi.setMarka("Audi");break;
                case 4:
                   odrertaxi.setMarka("BMW");break;    
            }
            order_entity.insert(odrertaxi);
            System.out.println(order_entity.select());            
        }
        else if (chous1==2){
            System.out.println("1.Просмотреть заказ\n2. Удалить заказ\n3. Обновить запись");
            int cases=sc2.nextInt();
            switch(cases){
                case 1:
                    System.out.println("Введите ном. телефона");
                    int text = sc.nextInt();
                    odrertaxi.getMarka();
                    odrertaxi.getId();
                    odrertaxi.getName();
                    odrertaxi.getPhone();
                    
                    System.out.println(order_entity.select2(text));
                    break;
                case 2: 
                    order_entity.select();
                    System.out.println("Введите номер вашего заказа");
                    order_entity.delete(sc.nextInt());
                    break;
                case 3:
                    order_entity.select();
                    System.out.println("Выбери номер заказа");
                    int idnom = sc.nextInt();
                    
                    System.out.println("Выберите автомобиль:\n1. Aston Martin\n2. Aston Martin\n3. Audi\n4. BMW");
                    int chouseAuto = sc.nextInt();

                    switch (chouseAuto){
                        case 1:
                            odrertaxi.setMarka("Alfa Romeo");
                            
                            break;
                        case 2:
                            odrertaxi.setMarka("Aston Martin");break;
                        case 3:
                            odrertaxi.setMarka("Audi");break;
                        case 4:
                            odrertaxi.setMarka("BMW");break;    
                    }
                    //
                     
                     
                    order_entity.update(idnom, odrertaxi);
                    order_entity.select();
                    break;
                        
            }
        }
//        Users_1 new_us = new Users_1();
        
//        switch (select1){
//        case 1:        
//            //insert
//            System.out.println("\nName: ");
//            new_us.setNikname(sc.next());
//            System.out.println("\nPassword: ");
//            new_us.setPassword(sc.next());   
//            us.insert(new_us);
//            System.out.println(us.select());
//            break;
//        case 2:
//           // update            
//            System.out.println("Insert users ID for update");
//            int idnom = sc.nextInt();
//            System.out.println("\nName: ");
//            new_us.setNikname(sc.next());
//                    
//            System.out.println("\nPassword: ");
//            new_us.setPassword(sc.next());   
//            us.update(idnom,new_us);
//            break;
//        case 3:
//            //delete
//            System.out.println("Insert ID fo Delete");
//            us.delete(sc.nextInt());
//            System.out.println(us.select());
//    
//}
    }
   
    
}
