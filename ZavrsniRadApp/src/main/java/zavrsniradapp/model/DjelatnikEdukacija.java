package zavrsniradapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class DjelatnikEdukacija extends Entitet {

    @ManyToOne
    private Djelatnik djelatnik;
    @ManyToOne
    private Edukacija edukacija;
    private BigDecimal ocijena;

    public DjelatnikEdukacija() {
        super();
    }

    public DjelatnikEdukacija(Integer sifra, Djelatnik djelatnik, Edukacija edukacija, BigDecimal ocijena) {
       
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

    public BigDecimal getOcijena() {
        return ocijena;
    }

    public void setOcijena(BigDecimal ocijena) {
        this.ocijena = ocijena;
    }

}
