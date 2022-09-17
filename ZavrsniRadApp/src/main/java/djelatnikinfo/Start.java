/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package djelatnikinfo;


import djelatnikinfo.controller.ObradaDjelatnik;
import djelatnikinfo.model.Djelatnik;
import djelatnikinfo.util.AppException;
import djelatnikinfo.util.PocetniInsert;



/**
 *
 * @author Alen
 */
public class Start {

    public Start() {
        
//   new PocetniInsert();
   ObradaDjelatnik od = new ObradaDjelatnik();
   Djelatnik d = new Djelatnik();
   d.setIme("Pero");
   d.setPrezime("Perić");
   d.setOib("52696585235");
   od.setEntitet(d);
        try {
            od.create();
        } catch (AppException ex) {
            System.out.println(ex.getPoruka());
        }

   
        
    }
    
    
    
    
    
    
    

    public static void main(String[] args) {
       new Start();
    }
}
