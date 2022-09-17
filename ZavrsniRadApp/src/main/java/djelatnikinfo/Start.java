/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package djelatnikinfo;

import djelatnikinfo.util.HibernateUtil;
import djelatnikinfo.util.PocetniInsert;

/**
 *
 * @author Alen
 */
public class Start {

    public Start() {
        
        PocetniInsert.izvedi();
        
        
    }
    
    
    
    
    
    
    

    public static void main(String[] args) {
       new Start();
    }
}
