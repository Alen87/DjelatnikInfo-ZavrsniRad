/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.controller;

import java.util.List;
import djelatnikinfo.model.SanitarnaIskaznica;
import djelatnikinfo.util.AppException;
import djelatnikinfo.util.Pomocno;

/**
 *
 * @author Alen
 */
public class ObradaSanitarnaIskaznica extends Obrada<SanitarnaIskaznica> {

    @Override
    public List<SanitarnaIskaznica> read() {
        return session.createQuery("from SanitarnaIskaznica", SanitarnaIskaznica.class).list();
    }

    @Override
    protected void kontrolaCreate() throws AppException {
        kontrolaBrojIskaznice();
        kontrolaDatumObavljenogPregleda();
        kontrolaDatumVrijediDo();
    }

    @Override
    protected void kontrolaUpdate() throws AppException {

    }

    @Override
    protected void kontrolaDelete() throws AppException {

    }

    @Override
    protected String getNazivEntiteta() {
        return "SanitarnaIskaznica";
    }

    private void kontrolaBrojIskaznice() throws AppException {
        kontrolaBrojIskazniceObavezno();
    }

    private void kontrolaBrojIskazniceObavezno() throws AppException {
        if (entitet.getBrojIskaznice() == null || entitet.getBrojIskaznice().trim().isEmpty()) {
            throw new AppException("Broj  iskaznice  obavezno");
        }
    }

    private void kontrolaDatumObavljenogPregleda() throws AppException {
        kontrolaDatumObavljenogPregledaObavezno();
    }

    private void kontrolaDatumObavljenogPregledaObavezno() throws AppException {
        if (entitet.getDatumObavljenogPregleda() == null) {
            throw new AppException("Datum obavljenog  pregleda obavezno" + Pomocno.getPrimjerDatuma());
        }
    }

    private void kontrolaDatumVrijediDo() throws AppException {
        kontrolaDatumVrijediDoObavezno();

    }

    private void kontrolaDatumVrijediDoObavezno() throws AppException {
        if(entitet.getVrijediDo() == null ){
            throw new AppException("Datum vrijedi do obavezno" + Pomocno.getPrimjerDatuma());
        }
    }

}
