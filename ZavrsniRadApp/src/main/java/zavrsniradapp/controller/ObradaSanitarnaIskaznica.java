/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsniradapp.controller;

import java.util.List;
import zavrsniradapp.model.SanitarnaIskaznica;
import zavrsniradapp.util.AppException;

/**
 *
 * @author Alen
 */
public class ObradaSanitarnaIskaznica extends Obrada<SanitarnaIskaznica>{

    @Override
    public List<SanitarnaIskaznica> read() {
     return session.createQuery("from SanitarnaIskaznica", SanitarnaIskaznica.class).list();
    }

    @Override
    protected void kontrolaCreate() throws AppException {
        
    }

    @Override
    protected void kontrolaUpdate() throws AppException {
       
    }

    @Override
    protected void kontrolaDelete() throws AppException {
        
    }
    
    
}
