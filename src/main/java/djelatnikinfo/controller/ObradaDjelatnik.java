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
     // kontrolaDeleteMobitelMoraBitiObrisan();
     // kontrolaDeleteSanitarnaIskaznicaMoraBitiObrisana();
     // kontrolaDeleteDjelatnikEdukacijaMoraBitiObrisan();
      //kontrolaDeleteMobitelSanitarnaIskaynicaDJelatnikEdukacijaMoraBitiObrisano();  
     
     kontrolaDeleteDjelatnikEdukacijaMoraBitiObrisanDruga();
     kontrolaDeleteMobitelMoraBitiObrisanDruga();
     kontrolaDeleteSanitarnaIskaznicaMoraBitiObrisanaDruga();
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
            throw new AppException("Ime mora sadržavati samo slova!");
        }
    }

    private void kontrolaPrezimeMoraSadrzavatiSamoSlova() throws AppException {
        if (!entitet.getPrezime().matches("\\p{L}+")) {
            throw new AppException("Prezime mora  sadržavati samo  slova!");
        }
    }

    private void kontrolaDeleteMobitelMoraBitiObrisan() throws AppException{
       if(entitet.getMobiteli()!=null && !entitet.getMobiteli().isEmpty()){
            throw new AppException("Djelatnik ima mobitel, i ne  može se obrisati dok se djelatnik ne obriše zadani mobitela ");
        }    
      }
    
     private void kontrolaDeleteSanitarnaIskaznicaMoraBitiObrisana() throws AppException{
       if(entitet.getSanitarneiskaznice()!= null && !entitet.getSanitarneiskaznice().isEmpty()){
            throw new AppException("Djelatnik ima  sanitarnu  iskaznicu, i ne može se obrisati dok se ne obriše sanitarna iskaznica zadanog djelatnika");
        }
      }

    private void kontrolaDeleteDjelatnikEdukacijaMoraBitiObrisan() throws AppException {
       if(entitet.getDjelatniciNaEdukacijama()!= null && !entitet.getDjelatniciNaEdukacijama().isEmpty()){
            throw new AppException("Djelatnik se nalazi na  edukacijama,i ne  može se obrisati dok se ne obriše sa zadane edukacije ");
        }
        
    }

//    private void kontrolaDeleteMobitelSanitarnaIskaynicaDJelatnikEdukacijaMoraBitiObrisano() throws AppException {
//       if(!entitet.isDeletable()){
//          throw new AppException("Djelatnik se nalazi na grupi Mobitel,Sanitarna iskaznica,Djelatnici na  edukacijama,i ne može se obrisati sve dok se nalazi na jednoj od grupa");
//       }
//    }

    private void kontrolaDeleteDjelatnikEdukacijaMoraBitiObrisanDruga() throws AppException {
        Integer i = session.createNativeQuery(
              "select count(*) from djelatnikedukacija where djelatnik_sifra=:p",
              Integer.class).setParameter("p", entitet.getSifra()).getSingleResult();
      
      if(i>0){
          throw new AppException("Djelatnik se nalazi na jednoj ili više edukacija");
      }
      
    }

    private void kontrolaDeleteMobitelMoraBitiObrisanDruga()throws AppException {
        Integer i = session.createNativeQuery(
              "select count(*) from mobitel where djelatnik_sifra=:p",
              Integer.class).setParameter("p", entitet.getSifra()).getSingleResult();
      
      if(i>0){
          throw new AppException("Djelatnik ima mobitel, i ne  može se obrisati dok se djelatnik ne obriše zadani mobitela ");
      }
    }

    private void kontrolaDeleteSanitarnaIskaznicaMoraBitiObrisanaDruga()throws AppException  {
       Integer i = session.createNativeQuery(
              "select count(*) from sanitarnaiskaznica where djelatnik_sifra=:p",
              Integer.class).setParameter("p", entitet.getSifra()).getSingleResult();
      
      if(i>0){
          throw new AppException("Djelatnik ima  sanitarnu  iskaznicu, i ne može se obrisati dok se ne obriše sanitarna iskaznica zadanog djelatnika ");
      } 
    }
    
    
}
