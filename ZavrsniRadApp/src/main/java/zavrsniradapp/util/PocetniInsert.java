/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsniradapp.util;

import com.github.javafaker.Faker;
import org.hibernate.Session;
import zavrsniradapp.model.Djelatnik;

/**
 *
 * @author Alen
 */
public class PocetniInsert {
    
    
      public static void izvedi() {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        Faker f =new Faker();
        Djelatnik djelatnik;
        
        for(int i =0;i<10;i++){
            djelatnik=new Djelatnik();
            djelatnik.setIme(f.address().firstName());
            djelatnik.setPrezime(f.address().lastName());
            s.persist(djelatnik);
        }
        
        
        
        s.getTransaction().commit();

    }
    
    
}
