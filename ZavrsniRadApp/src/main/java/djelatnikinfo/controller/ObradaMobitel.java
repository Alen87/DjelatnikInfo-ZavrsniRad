/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.controller;

import java.util.List;
import djelatnikinfo.model.Mobitel;
import djelatnikinfo.util.AppException;

/**
 *
 * @author Alen
 */
public class ObradaMobitel extends Obrada<Mobitel> {

    @Override
    public List<Mobitel> read() {
        return session.createQuery("from Mobitel", Mobitel.class).list();
    }

    @Override
    protected void kontrolaCreate() throws AppException {
       kontrolaNaziv();
    }

    @Override
    protected void kontrolaUpdate() throws AppException {
       
    }

    @Override
    protected void kontrolaDelete() throws AppException {
    }

    @Override
    protected String getNazivEntiteta() {
       return "Mobitel";
    }

    private void kontrolaNaziv()throws AppException {
        kontrolaNazivObvezno();
       
    }

    private void kontrolaNazivObvezno()throws AppException {
        if(entitet.getNaziv() == null || entitet.getNaziv().trim().isEmpty()){
            throw new AppException("Naziv mobitela obvezno");
        }
    }
    
}
