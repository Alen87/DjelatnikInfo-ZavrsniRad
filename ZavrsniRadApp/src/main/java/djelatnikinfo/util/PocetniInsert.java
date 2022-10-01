/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.util;

import com.github.javafaker.Faker;
import djelatnikinfo.controller.ObradaDjelatnik;
import djelatnikinfo.model.Djelatnik;
import djelatnikinfo.model.Edukacija;
import djelatnikinfo.model.Mobitel;
import djelatnikinfo.model.Operater;
import djelatnikinfo.model.SanitarnaIskaznica;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        kreirajMobitele(1);
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
        // datum
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
        //a.setPocetakRada();
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
        //a.setPocetakRada();
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
        //a.setPocetakRada();
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
        //a.setPocetakRada();
        e.setLoyalityKartica("76895048905");
        e.setRadnaOdjecaObuca("Zimsko odjelo br.56,čizme br.44,majica kratki rukav XL");
        e.setUgovor("Na određeno do 15.12.2022");
        e.setZavrsenoZanimanje("Prehrambeni  tehničar");

        sess.persist(e);
        return e;

    }

    private void kreirajEdukacije() {
        edukacije.add(kreirajPrvuEdukaciju());

    }

    private Edukacija kreirajPrvuEdukaciju() {
        Edukacija a = new Edukacija();
        a.setNaziv("Sigurnost hrane");
        // datum
        a.setVoditeljEdukacije("Igor Đuza");
        a.setTrajanjeEdukacijeMin(BigDecimal.valueOf(38.00));
        sess.persist(a);
        return a;

    }

    private void kreirajMobitele(int broj) {
        
            mobiteli.add(kreirajMobitel());
        
    }

    private Mobitel kreirajMobitel() {
        Mobitel m = new Mobitel();
        m.setNaziv(faker.funnyName().name());
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
        sanitarneIskaznice.add(kreirajTrecuSanitarnuIskaznicu());
        sanitarneIskaznice.add(kreirajCetvrtuSanitarnuIskaznicu());
        sanitarneIskaznice.add(kreirajPetuSanitarnuIskaznicu());
    }

    private SanitarnaIskaznica kreirajPrvuSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica a = new SanitarnaIskaznica();
        a.setBrojIskaznice("6574");
        //a.setDatumObavljenogPregleda();
        //a.setVrijediDo();
        a.setCijenaKn(BigDecimal.valueOf(200.00));
        a.setDjelatnik(djelatnici.get(2));
        sess.persist(a);
        return a;
    }

    private SanitarnaIskaznica kreirajDruguSanitarnuIskaznicu(List<Djelatnik>djelatnici) {
        SanitarnaIskaznica b = new SanitarnaIskaznica();
        b.setBrojIskaznice("7563");
        //b.setDatumObavljenogPregleda();
        //b.setVrijediDo();
        b.setCijenaKn(BigDecimal.valueOf(200.00));
        b.setDjelatnik(djelatnici.get(4));
        sess.persist(b);
        return b;
    }

    private SanitarnaIskaznica kreirajTrecuSanitarnuIskaznicu() {
        SanitarnaIskaznica c = new SanitarnaIskaznica();
        c.setBrojIskaznice("2365");
        //c.setDatumObavljenogPregleda();
        //c.setVrijediDo();
        c.setCijenaKn(BigDecimal.valueOf(200.00));
        sess.persist(c);
        return c;
    }

    private SanitarnaIskaznica kreirajCetvrtuSanitarnuIskaznicu() {
        SanitarnaIskaznica d = new SanitarnaIskaznica();
        d.setBrojIskaznice("8965");
        //d.setDatumObavljenogPregleda();
        //d.setVrijediDo();
        d.setCijenaKn(BigDecimal.valueOf(200.00));
        sess.persist(d);
        return d;
    }

    private SanitarnaIskaznica kreirajPetuSanitarnuIskaznicu() {
        SanitarnaIskaznica e = new SanitarnaIskaznica();
        e.setBrojIskaznice("8453");
        //e.setDatumObavljenogPregleda();
        //e.setVrijediDo();
        e.setCijenaKn(BigDecimal.valueOf(200.00));
        sess.persist(e);
        return e;
    }

}
