/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.controller;

import java.util.List;
import djelatnikinfo.model.Djelatnik;
import djelatnikinfo.util.AppException;

/**
 *
 * @author Alen
 */
public class ObradaDjelatnik extends Obrada<Djelatnik> {

    @Override
    public List<Djelatnik> read() {
       return session.createQuery("from Djelatnik", Djelatnik.class).list();
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
