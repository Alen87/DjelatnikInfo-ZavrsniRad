/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.util;

import com.github.javafaker.Faker;
import djelatnikinfo.controller.ObradaDjelatnik;
import djelatnikinfo.model.Djelatnik;
import djelatnikinfo.model.DjelatnikEdukacija;
import djelatnikinfo.model.Edukacija;
import djelatnikinfo.model.Mobitel;
import djelatnikinfo.model.Operater;
import djelatnikinfo.model.SanitarnaIskaznica;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Alen
 */
public class PocetniInsert {

    private List<Djelatnik> djelatnici;
    private List<Edukacija> edukacije;
    private List<Mobitel> mobiteli;
    private List<SanitarnaIskaznica> sanitarneIskaznice;
    private Session sess;
    private Faker faker;

    public PocetniInsert() {
        djelatnici = new ArrayList<>();
        edukacije = new ArrayList<>();
        mobiteli = new ArrayList<>();
        sanitarneIskaznice = new ArrayList<>();
        sess = HibernateUtil.getSession();
        faker = new Faker();
        sess.beginTransaction();
        kreirajDjelatnike();
        kreirajEdukacije();
        kreirajMobitele();
        kreirajSanitarneIskaznice();
        kreirajOperatera();
        sess.getTransaction().commit();
        HibernateUtil.reset();
    }

    private void kreirajDjelatnike() {
        djelatnici.add(kreirajPrvogDjelatnika());
        djelatnici.add(kreirajDrugogDjelatnika());
        djelatnici.add(kreirajTrecegDjelatnika());
        djelatnici.add(kreirajCetvrtogDjelatnika());
        djelatnici.add(kreirajPetogDjelatnika());
        djelatnici.add(kreirajSestogDjelatnika());
        djelatnici.add(kreirajSedmogDjelatnika());
    }

    private Djelatnik kreirajPrvogDjelatnika() {
        Djelatnik d = new Djelatnik();
        d.setIme("Danko");
        d.setPrezime("Štefančić");
        d.setOib("28247397961");
        d.setKontakt("091/3423456");
        d.setEmail("danko.stefancic@gmail.com");
        d.setPocetakRada(Pomocno.createDate(2015, 8, 17));
        d.setLoyalityKartica("5647893054728");
        d.setRadnaOdjecaObuca("hlače 2kom 52,majica 3kom L,papuče 42");
        d.setUgovor("Neodređeno");
        d.setZavrsenoZanimanje("Autoelektričar");

        sess.persist(d);
        return d;

    }

    private Djelatnik kreirajDrugogDjelatnika() {
        Djelatnik a = new Djelatnik();
        a.setIme("Josip");
        a.setPrezime("Nađ");
        a.setOib("33313572379");
        a.setKontakt("091/2233456");
        a.setEmail("josip.nad@gmail.com");
        a.setPocetakRada(Pomocno.createDate(2018, 9, 25));
        a.setLoyalityKartica("8455674893485");
        a.setRadnaOdjecaObuca("hlače 2kom 52,majica 3kom M,papuče 41");
        a.setUgovor("Neodređeno");
        a.setZavrsenoZanimanje("Pekar");

        sess.persist(a);
        return a;

    }

    private Djelatnik kreirajTrecegDjelatnika() {
        Djelatnik b = new Djelatnik();
        b.setIme("Matej");
        b.setPrezime("Cindrić");
        b.setOib("75894763546");
        b.setKontakt("098/2233456");
        b.setEmail("matej.cindric@gmail.com");
        b.setPocetakRada(Pomocno.createDate(2010, 3, 25));
        b.setLoyalityKartica("48933506200");
        b.setRadnaOdjecaObuca("hlače 2kom 46,majica 3kom M,papuče 43");
        b.setUgovor("Neodređeno");
        b.setZavrsenoZanimanje("Pekar");

        sess.persist(b);
        return b;
    }

    private Djelatnik kreirajCetvrtogDjelatnika() {
        Djelatnik c = new Djelatnik();
        c.setIme("Stjepan");
        c.setPrezime("Biljuš");
        c.setOib("46738926735");
        c.setKontakt("091/4353456");
        c.setEmail("stjepan.biljus@live.com");
        c.setPocetakRada(Pomocno.createDate(2016, 3, 22));
        c.setLoyalityKartica("47835674856");
        c.setRadnaOdjecaObuca("hlače 2kom 46,majica 3kom L,papuče 44");
        c.setUgovor("Neodređeno");
        c.setZavrsenoZanimanje("Trgovac");

        sess.persist(c);
        return c;
    }

    private Djelatnik kreirajPetogDjelatnika() {
        Djelatnik e = new Djelatnik();
        e.setIme("Dino");
        e.setPrezime("Pavić");
        e.setOib("21007996506");
        e.setKontakt("091/7689456");
        e.setEmail("dino.pavic@gmail.com");
        e.setPocetakRada(Pomocno.createDate(2015, 5, 10));
        e.setLoyalityKartica("76895048905");
        e.setRadnaOdjecaObuca("Zimsko odjelo br.56,čizme br.44,majica kratki rukav XL");
        e.setUgovor("Na određeno do 15.12.2022");
        e.setZavrsenoZanimanje("Prehrambeni  tehničar");

        sess.persist(e);
        return e;

    }
    
    private Djelatnik kreirajSestogDjelatnika() {
        Djelatnik e = new Djelatnik();
        e.setIme("Andrej");
        e.setPrezime("Hmura");
        e.setOib("16150747941");
        e.setKontakt("091/7684956");
        e.setEmail("andrej.hmura@gmail.com");
        e.setPocetakRada(Pomocno.createDate(2020, 11, 2));
        e.setLoyalityKartica("76895587405");
        e.setRadnaOdjecaObuca("hlače 2kom 46,majica 3kom L,papuče 44");
        e.setUgovor("Neodređeno");
        e.setZavrsenoZanimanje("Pekar");

        sess.persist(e);
        return e;

    }
     private Djelatnik kreirajSedmogDjelatnika() {
        Djelatnik e = new Djelatnik();
        e.setIme("Antonio");
        e.setPrezime("Marinović");
        e.setOib("46134905702");
        e.setKontakt("091/2224956");
        e.setEmail("antonio.marinovic@gmail.com");
        e.setPocetakRada(Pomocno.createDate(2020, 3, 3));
        e.setLoyalityKartica("76899857640");
        e.setRadnaOdjecaObuca("hlače 2kom 54,majica 3kom XL,papuče 44");
        e.setUgovor("Neodređeno");
        e.setZavrsenoZanimanje("Ekonomist");

        sess.persist(e);
        return e;

    }
    
    
    
    
    
    
    

    private void kreirajEdukacije() {
        edukacije.add(kreirajPrvuEdukaciju(djelatnici));
        edukacije.add(kreirajDruguEdukaciju(djelatnici));
        edukacije.add(kreirajTrecuEdukaciju(djelatnici));
        edukacije.add(kreirajCetvrtuEdukaciju(djelatnici));
    }

    private Edukacija kreirajPrvuEdukaciju(List<Djelatnik>djelatnici) {
        Edukacija a = new Edukacija();
        a.setNaziv("Sigurnost hrane");
        a.setDatum(Pomocno.createDate(2022, 3, 21));
        a.setVoditeljEdukacije("Igor Đuza");
        a.setTrajanjeEdukacijeMin(38);
       
        sess.persist(a);
        
       DjelatnikEdukacija de = new DjelatnikEdukacija();
       de.setEdukacija(a);
       de.setDjelatnik(djelatnici.get(0));
       de.setOcijena("Odličan");
       DjelatnikEdukacija ed = new DjelatnikEdukacija();
       ed.setEdukacija(a);
       ed.setDjelatnik(djelatnici.get(1));
       ed.setOcijena("Vrlo dobar");
       DjelatnikEdukacija ad = new DjelatnikEdukacija();
       ad.setEdukacija(a);
       ad.setDjelatnik(djelatnici.get(3));
       ad.setOcijena("Dobar");
       sess.persist(de);
       sess.persist(ed);
       sess.persist(ad);
       a.getDjelatniciNaEdukacijama().add(de);
       a.getDjelatniciNaEdukacijama().add(ed);
       a.getDjelatniciNaEdukacijama().add(ad);
       sess.persist(a);

       return a;
    }
    
    
     private Edukacija kreirajDruguEdukaciju(List<Djelatnik>djelatnici) {
        Edukacija a = new Edukacija();
        a.setNaziv("Metal detektor");
        a.setDatum(Pomocno.createDate(2022, 5, 20));
        a.setVoditeljEdukacije("Mario Šteko");
        a.setTrajanjeEdukacijeMin(60);
       
        sess.persist(a);
        
       DjelatnikEdukacija de = new DjelatnikEdukacija();
       de.setEdukacija(a);
       de.setDjelatnik(djelatnici.get(1));
       de.setOcijena("Dobar");
       DjelatnikEdukacija ed = new DjelatnikEdukacija();
       ed.setEdukacija(a);
       ed.setDjelatnik(djelatnici.get(2));
       ed.setOcijena("Odličan");
       DjelatnikEdukacija ad = new DjelatnikEdukacija();
       ad.setEdukacija(a);
       ad.setDjelatnik(djelatnici.get(4));
       ad.setOcijena("Vrlo dobar");
       sess.persist(de);
       sess.persist(ed);
       sess.persist(ad);
       a.getDjelatniciNaEdukacijama().add(de);
       a.getDjelatniciNaEdukacijama().add(ed);
       a.getDjelatniciNaEdukacijama().add(ad);
       sess.persist(a);

       return a;
    }
     
      private Edukacija kreirajTrecuEdukaciju(List<Djelatnik>djelatnici) {
        Edukacija a = new Edukacija();
        a.setNaziv("Alergeni");
        a.setDatum(Pomocno.createDate(2022, 7, 15));
        a.setVoditeljEdukacije("Igor Đuza");
        a.setTrajanjeEdukacijeMin(45);
       
        sess.persist(a);
        
       DjelatnikEdukacija de = new DjelatnikEdukacija();
       de.setEdukacija(a);
       de.setDjelatnik(djelatnici.get(2));
       de.setOcijena("Odličan");
       DjelatnikEdukacija ed = new DjelatnikEdukacija();
       ed.setEdukacija(a);
       ed.setDjelatnik(djelatnici.get(3));
       ed.setOcijena("Vrlo dobar");
       DjelatnikEdukacija ad = new DjelatnikEdukacija();
       ad.setEdukacija(a);
       ad.setDjelatnik(djelatnici.get(4));
       ad.setOcijena("Odličan");
       sess.persist(de);
       sess.persist(ed);
       sess.persist(ad);
       a.getDjelatniciNaEdukacijama().add(de);
       a.getDjelatniciNaEdukacijama().add(ed);
       a.getDjelatniciNaEdukacijama().add(ad);
        sess.persist(a);

       return a;
    }
     
      private Edukacija kreirajCetvrtuEdukaciju(List<Djelatnik>djelatnici) {
        Edukacija a = new Edukacija();
        a.setNaziv("Sigurnost upravljanja strojeva");
        a.setDatum(Pomocno.createDate(2022, 8, 10));
        a.setVoditeljEdukacije("Igor Đuza");
        a.setTrajanjeEdukacijeMin(60);
       
        sess.persist(a);
        
       DjelatnikEdukacija de = new DjelatnikEdukacija();
       de.setEdukacija(a);
       de.setDjelatnik(djelatnici.get(5));
       de.setOcijena("Odličan");
       DjelatnikEdukacija ed = new DjelatnikEdukacija();
       ed.setEdukacija(a);
       ed.setDjelatnik(djelatnici.get(6));
       ed.setOcijena("Dobar");
       DjelatnikEdukacija ad = new DjelatnikEdukacija();
       ad.setEdukacija(a);
       ad.setDjelatnik(djelatnici.get(0));
       ad.setOcijena("Vrlo dobar");
       DjelatnikEdukacija da = new DjelatnikEdukacija();
       da.setEdukacija(a);
       da.setDjelatnik(djelatnici.get(2));
       da.setOcijena("Dovoljan");
       sess.persist(de);
       sess.persist(ed);
       sess.persist(ad);
       sess.persist(da);
       a.getDjelatniciNaEdukacijama().add(de);
       a.getDjelatniciNaEdukacijama().add(ed);
       a.getDjelatniciNaEdukacijama().add(ad);
       a.getDjelatniciNaEdukacijama().add(da);
        sess.persist(a);

       return a;
    }
      
      
      
      
      
      
      
      
      
     
     

    private void kreirajMobitele() {
        
            mobiteli.add(kreirajPrviMobitel(djelatnici));
            mobiteli.add(kreirajDrugiMobitel(djelatnici));
            mobiteli.add(kreirajTreciMobitel(djelatnici));
        
    }

    private Mobitel kreirajPrviMobitel(List<Djelatnik>djelatnici) {
        Mobitel m = new Mobitel();
        m.setNaziv("SAMSUNG Galaxy A52S 5G White");
        m.setBroj("091/267 5332");
        m.setDatumZaprimanja(Pomocno.createDate(2021, 4, 21));
        m.setPravoNaSlijedeci(Pomocno.createDate(2023, 4, 21));
        m.setSerijskiBroj("B19V3CELCO2011Y");
        m.setDjelatnik(djelatnici.get(1));
        sess.persist(m);
        return m;
    }
    
    private Mobitel kreirajDrugiMobitel(List<Djelatnik>djelatnici) {
        Mobitel m = new Mobitel();
        m.setNaziv("HUAWEI Nova Y90 Black");
        m.setBroj("091/267 5331");
        m.setDatumZaprimanja(Pomocno.createDate(2022, 8, 17));
        m.setPravoNaSlijedeci(Pomocno.createDate(2024, 8, 17));
        m.setSerijskiBroj("B23V4CELCO8311Y");
        m.setDjelatnik(djelatnici.get(0));
        sess.persist(m);
        return m;
    }
    
    private Mobitel kreirajTreciMobitel(List<Djelatnik>djelatnici) {
        Mobitel m = new Mobitel();
        m.setNaziv("SAMSUNG Galaxy A13 White");
        m.setBroj("091/267 5330");
        m.setDatumZaprimanja(Pomocno.createDate(2022, 3, 17));
        m.setPravoNaSlijedeci(Pomocno.createDate(2024, 3, 17));
        m.setSerijskiBroj("B23V4CELCO7856Y");
        m.setDjelatnik(djelatnici.get(4));
        sess.persist(m);
        return m;
    }
    
    
    
    

    private void kreirajOperatera() {
        Operater o = new Operater();
        o.setIme("Alen");
        o.setPrezime("Borić");
        o.setEmail("boricalen@live.com");
        o.setLozinka(BCrypt.hashpw("DjelatnikInfo", BCrypt.gensalt()));
        sess.persist(o);
    }

    private void kreirajSanitarneIskaznice() {
        sanitarneIskaznice.add(kreirajPrvuSanitarnuIskaznicu(djelatnici));
        sanitarneIskaznice.add(kreirajDruguSanitarnuIskaznicu(djelatnici));
        sanitarneIskaznice.add(kreirajTrecuSanitarnuIskaznicu(djelatnici));
        sanitarneIskaznice.add(kreirajCetvrtuSanitarnuIskaznicu(djelatnici));
        sanitarneIskaznice.add(kreirajPetuSanitarnuIskaznicu(djelatnici));
        sanitarneIskaznice.add(kreirajSestuSanitarnuIskaznicu(djelatnici));
    }

    private SanitarnaIskaznica kreirajPrvuSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica a = new SanitarnaIskaznica();
        a.setBrojIskaznice("6574");
        a.setDatumObavljenogPregleda(Pomocno.createDate(2022, 8, 17));
        a.setVrijediDo(Pomocno.createDate(2023, 8, 17));
        a.setCijenaKn(BigDecimal.valueOf(200.00));
        a.setDjelatnik(djelatnici.get(2));
        sess.persist(a);
        return a;
    }

    private SanitarnaIskaznica kreirajDruguSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica b = new SanitarnaIskaznica();
        b.setBrojIskaznice("7563");
        b.setDatumObavljenogPregleda(Pomocno.createDate(2022, 5, 20));
        b.setVrijediDo(Pomocno.createDate(2023, 5, 20));
        b.setCijenaKn(BigDecimal.valueOf(200.00));
        b.setDjelatnik(djelatnici.get(4));
        sess.persist(b);
        return b;
    }

    private SanitarnaIskaznica kreirajTrecuSanitarnuIskaznicu( List<Djelatnik>djelatnici ) {
        SanitarnaIskaznica c = new SanitarnaIskaznica();
        c.setBrojIskaznice("2365");
        c.setDatumObavljenogPregleda(Pomocno.createDate(2021, 12, 12));
        c.setVrijediDo(Pomocno.createDate(2022, 12, 12));
        c.setCijenaKn(BigDecimal.valueOf(200.00));
        c.setDjelatnik(djelatnici.get(0));
        sess.persist(c);
        return c;
    }

    private SanitarnaIskaznica kreirajCetvrtuSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica d = new SanitarnaIskaznica();
        d.setBrojIskaznice("8965");
        d.setDatumObavljenogPregleda(Pomocno.createDate(2021, 12, 20));
        d.setVrijediDo(Pomocno.createDate(2022, 12, 20));
        d.setCijenaKn(BigDecimal.valueOf(200.00));
        d.setDjelatnik(djelatnici.get(1));
        sess.persist(d);
        return d;
    }

    private SanitarnaIskaznica kreirajPetuSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica e = new SanitarnaIskaznica();
        e.setBrojIskaznice("8453");
        e.setDatumObavljenogPregleda(Pomocno.createDate(2022, 9, 12));
        e.setVrijediDo(Pomocno.createDate(2023, 9, 12));
        e.setCijenaKn(BigDecimal.valueOf(200.00));
        e.setDjelatnik(djelatnici.get(3));
        sess.persist(e);
        return e;
    }
    
     private SanitarnaIskaznica kreirajSestuSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica e = new SanitarnaIskaznica();
        e.setBrojIskaznice("8454");
        e.setDatumObavljenogPregleda(Pomocno.createDate(2022, 12, 12));
        e.setVrijediDo(Pomocno.createDate(2023, 12, 12));
        e.setCijenaKn(BigDecimal.valueOf(200.00));
        e.setDjelatnik(djelatnici.get(6));
        sess.persist(e);
        return e;
    }
    
    
    
    
    
    

}
