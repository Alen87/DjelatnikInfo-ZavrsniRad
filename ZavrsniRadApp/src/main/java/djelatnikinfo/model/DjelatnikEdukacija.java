package djelatnikinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class DjelatnikEdukacija extends Entitet {

    @ManyToOne
    private Djelatnik djelatnik;
    @ManyToOne
    private Edukacija edukacija;
    private String ocijena;

    public DjelatnikEdukacija() {
        super();
    }

    public DjelatnikEdukacija(Integer sifra, Djelatnik djelatnik, Edukacija edukacija, String ocijena) {
        super(sifra);
        this.djelatnik = djelatnik;
        this.edukacija = edukacija;
        this.ocijena = ocijena;
    }

    public Djelatnik getDjelatnik() {
        return djelatnik;
    }

    public void setDjelatnik(Djelatnik djelatnik) {
        this.djelatnik = djelatnik;
    }

    public Edukacija getEdukacija() {
        return edukacija;
    }

    public void setEdukacija(Edukacija edukacija) {
        this.edukacija = edukacija;
    }

    public String getOcijena() {
        return ocijena;
    }

    public void setOcijena(String ocijena) {
        this.ocijena = ocijena;
    }

    @Override
    public String toString() {
        return djelatnik.getIme() + " " + djelatnik.getPrezime();

    }
    
    
    

}
