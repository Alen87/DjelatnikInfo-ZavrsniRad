/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djelatnikinfo.model;

import jakarta.persistence.Entity;

/**
 *
 * @author Alen
 */
@Entity
public class Operater extends Entitet {

    private String ime;
    private String prezime;
    private String email;
    private String oib;
    private String lozinka;

    public Operater(String ime, String prezime, String email, String oib, String lozinka, Integer sifra) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.oib = oib;
        this.lozinka = lozinka;
    }

    public Operater() {
        super();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

}
