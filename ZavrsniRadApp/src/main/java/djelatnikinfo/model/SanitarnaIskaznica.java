package djelatnikinfo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;
@Entity
public class SanitarnaIskaznica extends Entitet {
	
	private String brojIskaznice;
	private Date datumObavljenogPregleda;
	private Date vrijediDo;
	private BigDecimal cijenaKn;
	
        @ManyToOne
	private Djelatnik djelatnik; 

	public SanitarnaIskaznica() {
		super();
	}

	

	public SanitarnaIskaznica(Integer sifra, String brojIskaznice, Date datumObavljenogPregleda, Date vrijediDo,
			BigDecimal cijenaKn, Djelatnik djelatnik) {
		super(sifra);
		this.brojIskaznice = brojIskaznice;
		this.datumObavljenogPregleda = datumObavljenogPregleda;
		this.vrijediDo = vrijediDo;
		this.cijenaKn = cijenaKn;
		this.djelatnik = djelatnik;
	}



	public String getBrojIskaznice() {
		return brojIskaznice;
	}

	public void setBrojIskaznice(String brojIskaznice) {
		this.brojIskaznice = brojIskaznice;
	}

	public Date getDatumObavljenogPregleda() {
		return datumObavljenogPregleda;
	}

	public void setDatumObavljenogPregleda(Date datumObavljenogPregleda) {
		this.datumObavljenogPregleda = datumObavljenogPregleda;
	}

	public Date getVrijediDo() {
		return vrijediDo;
	}

	public void setVrijediDo(Date vrijediDo) {
		this.vrijediDo = vrijediDo;
	}

	public BigDecimal getCijenaKn() {
		return cijenaKn;
	}

	public void setCijenaKn(BigDecimal cijenaKn) {
		this.cijenaKn = cijenaKn;
	}

	public Djelatnik getDjelatnik() {
		return djelatnik;
	}

	public void setDjelatnik(Djelatnik djelatnik) {
		this.djelatnik = djelatnik;
	}

}
