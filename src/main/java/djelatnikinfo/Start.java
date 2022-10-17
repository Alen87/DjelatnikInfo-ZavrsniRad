/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package djelatnikinfo;

import djelatnikinfo.controller.ObradaDjelatnik;
import djelatnikinfo.controller.ObradaDjelatnikEdukacija;
import djelatnikinfo.controller.ObradaEdukacija;
import djelatnikinfo.controller.ObradaSanitarnaIskaznica;
import djelatnikinfo.model.Djelatnik;
import djelatnikinfo.model.DjelatnikEdukacija;
import djelatnikinfo.model.Edukacija;
import djelatnikinfo.model.SanitarnaIskaznica;
import djelatnikinfo.util.AppException;
import djelatnikinfo.util.PocetniInsert;
import djelatnikinfo.util.Pomocno;
import djelatnikinfo.view.SplashScreen;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alen
 */
public class Start {

    public Start() {
        
        new SplashScreen().setVisible(true);
        
        
        
        
        

    }

    public static void main(String[] args) {
        new Start();
    }

    private void testiranje() {
        //   new PocetniInsert();
        ObradaDjelatnik od = new ObradaDjelatnik();
        Djelatnik d = new Djelatnik();
        d.setIme("Pero");
        d.setPrezime("Perić");
        d.setOib("52696585235");
        od.setEntitet(d);
        try {
            od.create();
            System.out.println("Uspijesno spremanje u djelatnik");
        } catch (AppException ex) {
            System.out.println(ex.getPoruka());
        }

        ObradaEdukacija oe = new ObradaEdukacija();
        Edukacija e = new Edukacija();
        e.setNaziv("Metal detektor");
        SimpleDateFormat df = new SimpleDateFormat(Pomocno.FORMAT_DATUMA);
        try {
            e.setDatum(df.parse("15.09.2022"));
        } catch (ParseException ex) {
            e.setDatum(null);
            System.out.println("Datum nije  spremljen");
        }
        oe.setEntitet(e);
        try {
            oe.create();
            System.out.println("Uspijesno spremanje u edukacija");
        } catch (AppException ex) {
            System.out.println(ex.getPoruka());
        }

        ObradaSanitarnaIskaznica osi = new ObradaSanitarnaIskaznica();
        SanitarnaIskaznica si = new SanitarnaIskaznica();
        si.setBrojIskaznice("2304");
        SimpleDateFormat sd = new SimpleDateFormat(Pomocno.FORMAT_DATUMA);
        try {
            si.setDatumObavljenogPregleda(sd.parse("10.09.2022"));
        } catch (ParseException ex) {
            si.setDatumObavljenogPregleda(null);
            System.out.println("Datum nije unesen");
        }

        try {
            si.setVrijediDo(sd.parse("10.09.2023"));
        } catch (ParseException ex) {
            si.setVrijediDo(null);
            System.out.println("Datum nije unesen");
        }

        osi.setEntitet(si);
        try {
            osi.create();
            System.out.println("Uspijesno spremanje  u  Sanitarna iskaznica");
        } catch (AppException ex) {
            System.out.println(ex.getPoruka());
        }

    }
}
