package zavrsniradapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Edukacija extends Entitet {
	private String naziv;
	private Date datum;
	private String voditeljEdukacije;
	private BigDecimal trajanjeEdukacijeMin;
        
        
       // @OnetoMany(mappedBy = "grupa")
	private List<DjelatnikEdukacija> djelatniciNaEdukacijama = new ArrayList();

	public Edukacija() {
		super();
	}

	public Edukacija(Integer sifra, String naziv, Date datum, String voditeljEdukacije, BigDecimal trajanjeEdukacijeMin,
			List<DjelatnikEdukacija> djelatniciNaEdukacijama) {
		super(sifra);
		this.naziv = naziv;
		this.datum = datum;
		this.voditeljEdukacije = voditeljEdukacije;
		this.trajanjeEdukacijeMin = trajanjeEdukacijeMin;
		this.djelatniciNaEdukacijama = djelatniciNaEdukacijama;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getVoditeljEdukacije() {
		return voditeljEdukacije;
	}

	public void setVoditeljEdukacije(String voditeljEdukacije) {
		this.voditeljEdukacije = voditeljEdukacije;
	}

	public BigDecimal getTrajanjeEdukacijeMin() {
		return trajanjeEdukacijeMin;
	}

	public void setTrajanjeEdukacijeMin(BigDecimal trajanjeEdukacijeMin) {
		this.trajanjeEdukacijeMin = trajanjeEdukacijeMin;
	}

	public List<DjelatnikEdukacija> getDjelatniciNaEdukacijama() {
		return djelatniciNaEdukacijama;
	}

	public void setDjelatniciNaEdukacijama(List<DjelatnikEdukacija> djelatniciNaEdukacijama) {
		this.djelatniciNaEdukacijama = djelatniciNaEdukacijama;
	}

}
