/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.controller;

import djelatnikinfo.model.Djelatnik;
import djelatnikinfo.model.DjelatnikEdukacija;
import java.util.List;
import djelatnikinfo.model.Edukacija;
import djelatnikinfo.util.AppException;
import djelatnikinfo.util.Pomocno;

/**
 *
 * @author Alen
 */
public class ObradaEdukacija extends Obrada<Edukacija>{

    @Override
    public List<Edukacija> read() {
        return session.createQuery("from Edukacija",Edukacija.class).list();
    }

    @Override
    protected void kontrolaCreate() throws AppException {
       kontrolaNaziv();
       kontrolaDatum();
    }

    @Override
    protected void kontrolaUpdate() throws AppException {
      
    }

    @Override
    protected void kontrolaDelete() throws AppException {
        
        
    }

    @Override
    protected String getNazivEntiteta() {
        return "Edukacija";
    }

    private void kontrolaNaziv()throws AppException {
        kontrolaNazivMoraBitiUnesen();
    }

    private void kontrolaNazivMoraBitiUnesen() throws AppException {
        if(entitet.getNaziv()==null || entitet.getNaziv().trim().isEmpty()){
            throw new AppException("Naziv  mora biti  unesen");
        }
    }

    private void kontrolaDatum()throws AppException {
        kontrolaDatumObvezno();
    }

    private void kontrolaDatumObvezno() throws AppException {
        if(entitet.getDatum() == null){
            throw new AppException("Unos datum obavljenog pregleda obvezan , npr ... " + Pomocno.getPrimjerDatuma());
        }
        
    }
    
}
