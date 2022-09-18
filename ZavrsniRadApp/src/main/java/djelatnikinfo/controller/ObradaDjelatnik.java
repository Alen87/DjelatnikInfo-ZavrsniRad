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

    @Override
    protected void kontrolaCreate() throws AppException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
    }

    @Override
    protected void kontrolaUpdate() throws AppException {

    }

    @Override
    protected void kontrolaDelete() throws AppException {

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

}
