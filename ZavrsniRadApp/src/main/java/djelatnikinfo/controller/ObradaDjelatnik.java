/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.controller;

import java.util.List;
import djelatnikinfo.model.Djelatnik;
import djelatnikinfo.util.AppException;
import djelatnikinfo.util.Pomocno;

/**
 *
 * @author Alen
 */
public class ObradaDjelatnik extends Obrada<Djelatnik> {

    @Override
    public List<Djelatnik> read() {
        return session.createQuery("from Djelatnik", Djelatnik.class).list();
    }

 
    public List<Djelatnik> read(String uvjet) {
         
                return session.createQuery("from Djelatnik p where "
                + " lower(concat(p.ime,' ',p.prezime)) like :uvjet", Djelatnik.class)
                .setParameter("uvjet", "%" + uvjet.toLowerCase() + "%")
                .setMaxResults(5)
                .list();
                
                
    }

    @Override
    protected void kontrolaCreate() throws AppException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
    }

    @Override
    protected void kontrolaUpdate() throws AppException {
        kontrolaCreate();
        
        

    }

    @Override
    protected void kontrolaDelete() throws AppException {
       kontrolaDeleteMobitelMoraBitiObrisan();
       kontrolaDeleteSanitarnaIskaznicaMoraBitiObrisana();
        
       
    }

    @Override
    protected String getNazivEntiteta() {
        return "Djelatnik";
    }

    private void kontrolaIme() throws AppException {
        kontrolaImeMoraBitiUneseno();
        kontrolaImeMoraSadrzavatiSamoSlova();
    }

    private void kontrolaImeMoraBitiUneseno() throws AppException {
        if (entitet.getIme() == null || entitet.getIme().trim().isEmpty()) {
            throw new AppException("Ime obavezno");
        }

    }

    private void kontrolaPrezime() throws AppException {
        kontrolaPrezimeMoraBitiUneseno();
        kontrolaPrezimeMoraSadrzavatiSamoSlova();
    }

    private void kontrolaPrezimeMoraBitiUneseno() throws AppException {
        if (entitet.getPrezime() == null || entitet.getPrezime().trim().isEmpty()) {
            throw new AppException("Prezime obavezno");
        }
    }

    private void kontrolaOib() throws AppException {
        kontrolaOibMoraBitiUneseno();
        kontrolaOibIspravanOib();

    }

    private void kontrolaOibIspravanOib() throws AppException {
        if (!Pomocno.kontrolaOib(entitet.getOib())) {
            throw new AppException("OIB nije ispravan");
        }
    }

    private void kontrolaOibMoraBitiUneseno() throws AppException {
        if (entitet.getOib() == null || entitet.getOib().trim().isEmpty()) {
            throw new AppException("Unos OIB-a obvezan");
        }

    }

    private void kontrolaImeMoraSadrzavatiSamoSlova() throws AppException {
        if (!entitet.getIme().matches("\\p{L}+")) {
            throw new AppException("Ime mora sadrzavati samo slova!");
        }
    }

    private void kontrolaPrezimeMoraSadrzavatiSamoSlova() throws AppException {
        if (!entitet.getPrezime().matches("\\p{L}+")) {
            throw new AppException("Prezime mora  sadrzavati samo  slova!");
        }
    }

    private void kontrolaDeleteMobitelMoraBitiObrisan() throws AppException{
       if(entitet.getMobiteli()!=null && !entitet.getMobiteli().isEmpty()){
            throw new AppException("Djelatnik ima mobitel i ne  moze se obrisati dok se  ne  obrisu  mobiteli na ovom djelatniku ");
        }    
      }
    
     private void kontrolaDeleteSanitarnaIskaznicaMoraBitiObrisana() throws AppException{
       if(entitet.getSanitarneiskaznice()!= null && !entitet.getSanitarneiskaznice().isEmpty()){
            throw new AppException("Djelatnik ima  sanitarnu  iskaznicu i ne  mooze se obrisati  dok se ne  obrisu saniitarne iskaznice  na  ovom  djelatniku");
        }
      }
    
    
}
