package djelatnikinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Djelatnik extends Entitet {

    private String ime;
    private String prezime;
    private String oib;
    private String kontakt;
    private String email;
    private Date pocetakRada;
    private String loyalityKartica;
    private String radnaOdjecaObuca;
    private String ugovor;
    private String zavrsenoZanimanje;

    @OneToMany(mappedBy = "djelatnik")
    private List<Mobitel> mobiteli;
    @OneToMany(mappedBy = "djelatnik")
    private List<SanitarnaIskaznica> sanitarneiskaznice;
    @OneToMany(mappedBy = "djelatnik")
    private List<DjelatnikEdukacija> djelatniciNaEdukacijama;

    public Djelatnik(String ime, String prezime, String oib, String kontakt, String email, Date pocetakRada, String loyalityKartica, String radnaOdjecaObuca, String ugovor, String zavrsenoZanimanje, List<Mobitel> mobiteli, List<SanitarnaIskaznica> sanitarneiskaznice, List<DjelatnikEdukacija> djelatniciNaEdukacijama, Integer sifra) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.kontakt = kontakt;
        this.email = email;
        this.pocetakRada = pocetakRada;
        this.loyalityKartica = loyalityKartica;
        this.radnaOdjecaObuca = radnaOdjecaObuca;
        this.ugovor = ugovor;
        this.zavrsenoZanimanje = zavrsenoZanimanje;
        this.mobiteli = mobiteli;
        this.sanitarneiskaznice = sanitarneiskaznice;
        this.djelatniciNaEdukacijama = djelatniciNaEdukacijama;
    }

   

    public Djelatnik() {
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

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getPocetakRada() {
        return pocetakRada;
    }

    public void setPocetakRada(Date pocetakRada) {
        this.pocetakRada = pocetakRada;
    }

    public String getLoyalityKartica() {
        return loyalityKartica;
    }

    public void setLoyalityKartica(String loyalityKartica) {
        this.loyalityKartica = loyalityKartica;
    }

    public String getRadnaOdjecaObuca() {
        return radnaOdjecaObuca;
    }

    public void setRadnaOdjecaObuca(String radnaOdjecaObuca) {
        this.radnaOdjecaObuca = radnaOdjecaObuca;
    }

    public String getUgovor() {
        return ugovor;
    }

    public void setUgovor(String ugovor) {
        this.ugovor = ugovor;
    }

    public String getZavrsenoZanimanje() {
        return zavrsenoZanimanje;
    }

    public void setZavrsenoZanimanje(String zavrsenoZanimanje) {
        this.zavrsenoZanimanje = zavrsenoZanimanje;
    }

    public List<Mobitel> getMobiteli() {
        return mobiteli;
    }

    public void setMobiteli(List<Mobitel> mobiteli) {
        this.mobiteli = mobiteli;
    }

    public List<SanitarnaIskaznica> getSanitarneiskaznice() {
        return sanitarneiskaznice;
    }

    public void setSanitarneiskaznice(List<SanitarnaIskaznica> sanitarneiskaznice) {
        this.sanitarneiskaznice = sanitarneiskaznice;
    }

    public List<DjelatnikEdukacija> getDjelatniciNaEdukacijama() {
        return djelatniciNaEdukacijama;
    }

    public void setDjelatniciNaEdukacijama(List<DjelatnikEdukacija> djelatniciNaEdukacijama) {
        this.djelatniciNaEdukacijama = djelatniciNaEdukacijama;
    }

    @Override
    public String toString() {
        return this.ime + " " + this.prezime;
    }

//    public boolean isDeletable(){
//        return 
//               (this.djelatniciNaEdukacijama==null ||
//                this.djelatniciNaEdukacijama.isEmpty())
//                && (this.mobiteli==null
//                || this.mobiteli.isEmpty())
//               && (this.sanitarneiskaznice==null
//                || this.sanitarneiskaznice.isEmpty());
//    }
    
    
    
    
}
