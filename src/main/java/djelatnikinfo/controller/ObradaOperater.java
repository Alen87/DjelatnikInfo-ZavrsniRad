/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.controller;

import djelatnikinfo.model.Operater;
import djelatnikinfo.util.AppException;
import jakarta.persistence.NoResultException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Alen
 */
public class ObradaOperater extends Obrada<Operater> {

    public Operater autoriziraj(String email, char[] lozinka) {
        Operater o;
        try {
            o = session.createQuery("from Operater where email=:email",
                    Operater.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

       
   
    if( BCrypt.checkpw(new String(lozinka), o.getLozinka())){
        Operater vrati = new Operater();
        vrati.setSifra(o.getSifra());
        vrati.setIme(o.getIme());
        vrati.setPrezime(o.getPrezime());
        vrati.setEmail(o.getEmail());
        // ne  postavljamo  loziku  da  ne  bude  u  memoriji
        return vrati;
        
    }
    return null;

    }

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    @Override
    protected void kontrolaCreate() throws AppException {

    }

    @Override
    protected void kontrolaUpdate() throws AppException {

    }

    @Override
    protected void kontrolaDelete() throws AppException {

    }

    @Override
    protected String getNazivEntiteta() {
        return "Operater";
    }

}

