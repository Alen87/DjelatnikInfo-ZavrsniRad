/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsniradapp.util;

import org.hibernate.Session;

/**
 *
 * @author Alen
 */
public class PocetniInsert {
    
    
      public static void izvedi() {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        
        
        
        
        s.getTransaction().commit();

    }
    
    
}
