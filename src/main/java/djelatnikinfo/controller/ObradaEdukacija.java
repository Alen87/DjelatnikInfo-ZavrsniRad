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
import java.util.ArrayList;

/**
 *
 * @author Alen
 */
public class ObradaEdukacija extends Obrada<Edukacija> {

    private List<DjelatnikEdukacija> noviDjelatniciNaEdukacijama;
    

    @Override
    public void create() throws AppException {

        kontrolaCreate();
        session.beginTransaction();
        session.persist(entitet);
        
        List<DjelatnikEdukacija> djelatniciNaEdukacijama = new ArrayList<>();
        DjelatnikEdukacija novi;
        for (DjelatnikEdukacija de : noviDjelatniciNaEdukacijama) {
          
            novi = new DjelatnikEdukacija();
            novi.setEdukacija(entitet);
            novi.setDjelatnik(de.getDjelatnik());
            novi.setOcijena(de.getOcijena());
            session.persist(novi);
            djelatniciNaEdukacijama.add(novi);
            
        }

        entitet.setDjelatniciNaEdukacijama(djelatniciNaEdukacijama);
        session.getTransaction().commit();

    }

    @Override
    public void update() throws AppException {
        kontrolaUpdate();
        session.beginTransaction();

        for (DjelatnikEdukacija de : entitet.getDjelatniciNaEdukacijama()) {
            session.remove(de);

        }
        for (DjelatnikEdukacija de : noviDjelatniciNaEdukacijama) {
            session.persist(de);
        }

        entitet.setDjelatniciNaEdukacijama(noviDjelatniciNaEdukacijama);
        session.persist(entitet);
        session.getTransaction().commit();
        for(DjelatnikEdukacija de : noviDjelatniciNaEdukacijama){
            session.refresh(de);
        }

    }

    @Override
    public void delete() throws AppException {
        kontrolaDelete();
          session.beginTransaction();

        for (DjelatnikEdukacija de : entitet.getDjelatniciNaEdukacijama()) {
            session.remove(de);

        }
       

        
        session.remove(entitet);
        session.getTransaction().commit();
        
    }
    
    
    
    
    

    @Override
    public List<Edukacija> read() {
        return session.createQuery("from Edukacija", Edukacija.class).list();
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
      if(!noviDjelatniciNaEdukacijama.isEmpty()){
          throw new AppException("Ne može se obrisati edukacija koja  ima  djelatnike ");
      }
    }

    @Override
    protected String getNazivEntiteta() {
        return "Edukacija";
    }

    private void kontrolaNaziv() throws AppException {
        kontrolaNazivMoraBitiUnesen();
    }

    private void kontrolaNazivMoraBitiUnesen() throws AppException {
        if (entitet.getNaziv() == null || entitet.getNaziv().trim().isEmpty()) {
            throw new AppException("Naziv obavezno");
        }
    }

    private void kontrolaDatum() throws AppException {
        kontrolaDatumObvezno();
    }

    private void kontrolaDatumObvezno() throws AppException {
        if (entitet.getDatum() == null) {
            throw new AppException("Unos datum obavljenog pregleda obvezan , npr ... " + Pomocno.getPrimjerDatuma());
        }

    }

    public List<DjelatnikEdukacija> getNoviDjelatniciNaEdukacijama() {
        return noviDjelatniciNaEdukacijama;
    }

    public void setNoviDjelatniciNaEdukacijama(List<DjelatnikEdukacija> noviDjelatniciNaEdukacijama) {
        this.noviDjelatniciNaEdukacijama = noviDjelatniciNaEdukacijama;
    }

   
}
