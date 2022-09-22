/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.util;

import com.github.javafaker.Faker;
import djelatnikinfo.model.Djelatnik;
import djelatnikinfo.model.Edukacija;
import djelatnikinfo.model.Mobitel;
import djelatnikinfo.model.Operater;
import java.util.ArrayList;
import java.util.List;
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
    private Session sess;
    private Faker faker;

    public PocetniInsert() {
        djelatnici = new ArrayList<>();
        edukacije = new ArrayList<>();
        mobiteli = new ArrayList<>();
        sess = HibernateUtil.getSession();
        faker = new Faker();
        sess.beginTransaction();
        kreirajDjelatnike(10);
        kreirajEdukacije(20);
        kreirajMobitele(15);
        kreirajOperatera();
        sess.getTransaction().commit();
    }

    private void kreirajDjelatnike(int broj) {
       for(int i=0;i<broj;i++){
           djelatnici.add(kreirajDjelatnika());
       }
    }

    private Djelatnik kreirajDjelatnika() {
       Djelatnik d = new Djelatnik() ;
       d.setIme(faker.address().firstName());
       d.setPrezime(faker.address().lastName());
       sess.persist(d);
       return d;
    }

    private void kreirajEdukacije(int broj) {
      for(int i=0;i<broj;i++){
          edukacije.add(kreirajEdukaciju());
      }
    }

    private Edukacija kreirajEdukaciju() {
        Edukacija e = new Edukacija();
        e.setNaziv(faker.book().title());
        sess.persist(e);
        return e;
    }

    private void kreirajMobitele(int broj) {
       for (int i = 0;i<broj;i++){
           mobiteli.add(kreirajMobitel());
       }
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
       o.setPrezime("Boric");
       o.setEmail("boricalen@live.com");
       o.setLozinka(BCrypt.hashpw("DjelatnikInfo", BCrypt.gensalt()));
       sess.persist(o);
    }

}
