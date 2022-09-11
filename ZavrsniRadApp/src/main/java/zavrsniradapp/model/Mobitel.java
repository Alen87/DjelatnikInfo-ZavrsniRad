package zavrsniradapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Mobitel extends Entitet {
	private String naziv;
	private String broj;
	private Date datumZaprimanja;
	private Date pravoNaSlijedeci;
	private String serijskiBroj;
        @ManyToOne
	private Djelatnik djelatnik;

	public Mobitel() {
		super();
	}

	public Mobitel(Integer sifra, String naziv, String broj, Date datumZaprimanja, Date pravoNaSlijedeci,
			String serijskiBroj, Djelatnik djelatnik) {
		
		this.naziv = naziv;
		this.broj = broj;
		this.datumZaprimanja = datumZaprimanja;
		this.pravoNaSlijedeci = pravoNaSlijedeci;
		this.serijskiBroj = serijskiBroj;
		this.djelatnik = djelatnik;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Date getDatumZaprimanja() {
		return datumZaprimanja;
	}

	public void setDatumZaprimanja(Date datumZaprimanja) {
		this.datumZaprimanja = datumZaprimanja;
	}

	public Date getPravoNaSlijedeci() {
		return pravoNaSlijedeci;
	}

	public void setPravoNaSlijedeci(Date pravoNaSlijedeci) {
		this.pravoNaSlijedeci = pravoNaSlijedeci;
	}

	public String getSerijskiBroj() {
		return serijskiBroj;
	}

	public void setSerijskiBroj(String serijskiBroj) {
		this.serijskiBroj = serijskiBroj;
	}

	public Djelatnik getDjelatnik() {
		return djelatnik;
	}

	public void setDjelatnik(Djelatnik djelatnik) {
		this.djelatnik = djelatnik;
	}

}
