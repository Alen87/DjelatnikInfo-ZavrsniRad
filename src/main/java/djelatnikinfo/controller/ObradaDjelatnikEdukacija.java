/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.controller;

import java.util.List;
import djelatnikinfo.model.DjelatnikEdukacija;
import djelatnikinfo.util.AppException;

/**
 *
 * @author Alen
 */
public class ObradaDjelatnikEdukacija extends Obrada<DjelatnikEdukacija>{

    @Override
    public List<DjelatnikEdukacija> read() {
        return session.createQuery("from Djelatnikedukacija", DjelatnikEdukacija.class).list();
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

    @Override
    protected String getNazivEntiteta() {
       return "DjelatnikEdukacija";
    }
    
}
