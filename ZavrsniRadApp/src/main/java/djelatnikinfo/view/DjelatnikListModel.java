/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.view;

import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Alen
 */
public class DjelatnikListModel<T> extends DefaultListModel<T> {

    public DjelatnikListModel(List<T>podaci) {
        super();
        addAll(podaci);
        
    }

    
    
  
    
}
