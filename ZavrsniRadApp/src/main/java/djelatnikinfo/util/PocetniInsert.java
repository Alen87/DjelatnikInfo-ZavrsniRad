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
import java.util.Date;
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
    }

    private void kreirajDjelatnike() {
        djelatnici.add(kreirajPrvogDjelatnika());
        djelatnici.add(kreirajDrugogDjelatnika());
        djelatnici.add(kreirajTrecegDjelatnika());
        djelatnici.add(kreirajCetvrtogDjelatnika());
        djelatnici.add(kreirajPetogDjelatnika());
    }

    private Djelatnik kreirajPrvogDjelatnika() {
        Djelatnik d = new Djelatnik();
        d.setIme("Danko");
        d.setPrezime("Štefančić");
        d.setOib("28247397961");
        d.setKontakt("091/3423456");
        d.setEmail("danko.stefancic@gmail.com");
        d.setPocetakRada(new Date());
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
        a.setPocetakRada(new Date());
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
        b.setPocetakRada(new Date());
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
        c.setPocetakRada(new Date());
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
        e.setPocetakRada(new Date());
        e.setLoyalityKartica("76895048905");
        e.setRadnaOdjecaObuca("Zimsko odjelo br.56,čizme br.44,majica kratki rukav XL");
        e.setUgovor("Na određeno do 15.12.2022");
        e.setZavrsenoZanimanje("Prehrambeni  tehničar");

        sess.persist(e);
        return e;

    }

    private void kreirajEdukacije() {
        edukacije.add(kreirajPrvuEdukaciju(djelatnici));
        edukacije.add(kreirajDruguEdukaciju(djelatnici));
        edukacije.add(kreirajTrecuEdukaciju(djelatnici));
    }

    private Edukacija kreirajPrvuEdukaciju(List<Djelatnik>djelatnici) {
        Edukacija a = new Edukacija();
        a.setNaziv("Sigurnost hrane");
        a.setDatum(new Date());
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
        a.setDatum(new Date());
        a.setVoditeljEdukacije("Mario Šteko");
        a.setTrajanjeEdukacijeMin(60);
       
        sess.persist(a);
        
       DjelatnikEdukacija de = new DjelatnikEdukacija();
       de.setEdukacija(a);
       de.setDjelatnik(djelatnici.get(1));
       DjelatnikEdukacija ed = new DjelatnikEdukacija();
       ed.setEdukacija(a);
       ed.setDjelatnik(djelatnici.get(2));
       DjelatnikEdukacija ad = new DjelatnikEdukacija();
       ad.setEdukacija(a);
       ad.setDjelatnik(djelatnici.get(4));
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
        a.setDatum(new Date());
        a.setVoditeljEdukacije("Igor Đuza");
        a.setTrajanjeEdukacijeMin(45);
       
        sess.persist(a);
        
       DjelatnikEdukacija de = new DjelatnikEdukacija();
       de.setEdukacija(a);
       de.setDjelatnik(djelatnici.get(2));
       DjelatnikEdukacija ed = new DjelatnikEdukacija();
       ed.setEdukacija(a);
       ed.setDjelatnik(djelatnici.get(3));
       DjelatnikEdukacija ad = new DjelatnikEdukacija();
       ad.setEdukacija(a);
       ad.setDjelatnik(djelatnici.get(4));
       sess.persist(de);
       sess.persist(ed);
       sess.persist(ad);
       a.getDjelatniciNaEdukacijama().add(de);
       a.getDjelatniciNaEdukacijama().add(ed);
       a.getDjelatniciNaEdukacijama().add(ad);
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
        m.setDatumZaprimanja(new Date());
        m.setPravoNaSlijedeci(new Date());
        m.setSerijskiBroj("B19V3CELCO2011Y");
        m.setDjelatnik(djelatnici.get(1));
        sess.persist(m);
        return m;
    }
    
    private Mobitel kreirajDrugiMobitel(List<Djelatnik>djelatnici) {
        Mobitel m = new Mobitel();
        m.setNaziv("HUAWEI Nova Y90 Black");
        m.setBroj("091/267 5331");
        m.setDatumZaprimanja(new Date());
        m.setPravoNaSlijedeci(new Date());
        m.setSerijskiBroj("B23V4CELCO8311Y");
        m.setDjelatnik(djelatnici.get(0));
        sess.persist(m);
        return m;
    }
    
    private Mobitel kreirajTreciMobitel(List<Djelatnik>djelatnici) {
        Mobitel m = new Mobitel();
        m.setNaziv("SAMSUNG Galaxy A13 White");
        m.setBroj("091/267 5330");
        m.setDatumZaprimanja(new Date());
        m.setPravoNaSlijedeci(new Date());
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
    }

    private SanitarnaIskaznica kreirajPrvuSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica a = new SanitarnaIskaznica();
        a.setBrojIskaznice("6574");
        a.setDatumObavljenogPregleda(new Date());
        a.setVrijediDo(new Date());
        a.setCijenaKn(BigDecimal.valueOf(200.00));
        a.setDjelatnik(djelatnici.get(2));
        sess.persist(a);
        return a;
    }

    private SanitarnaIskaznica kreirajDruguSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica b = new SanitarnaIskaznica();
        b.setBrojIskaznice("7563");
        b.setDatumObavljenogPregleda(new Date());
        b.setVrijediDo(new Date());
        b.setCijenaKn(BigDecimal.valueOf(200.00));
        b.setDjelatnik(djelatnici.get(4));
        sess.persist(b);
        return b;
    }

    private SanitarnaIskaznica kreirajTrecuSanitarnuIskaznicu( List<Djelatnik>djelatnici ) {
        SanitarnaIskaznica c = new SanitarnaIskaznica();
        c.setBrojIskaznice("2365");
        c.setDatumObavljenogPregleda(new Date());
        c.setVrijediDo(new Date());
        c.setCijenaKn(BigDecimal.valueOf(200.00));
        c.setDjelatnik(djelatnici.get(0));
        sess.persist(c);
        return c;
    }

    private SanitarnaIskaznica kreirajCetvrtuSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica d = new SanitarnaIskaznica();
        d.setBrojIskaznice("8965");
        d.setDatumObavljenogPregleda(new Date());
        d.setVrijediDo(new Date());
        d.setCijenaKn(BigDecimal.valueOf(200.00));
        d.setDjelatnik(djelatnici.get(1));
        sess.persist(d);
        return d;
    }

    private SanitarnaIskaznica kreirajPetuSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica e = new SanitarnaIskaznica();
        e.setBrojIskaznice("8453");
        e.setDatumObavljenogPregleda(new Date());
        e.setVrijediDo(new Date());
        e.setCijenaKn(BigDecimal.valueOf(200.00));
        e.setDjelatnik(djelatnici.get(3));
        sess.persist(e);
        return e;
    }

}
