package djelatnikinfo.model;


import jakarta.persistence.Entity;
import java.util.Date;




@Entity
public  class Djelatnik extends Entitet {
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
	
	
	
	
	
	public Djelatnik(String ime, String prezime, String oib, String kontakt, String email, Date pocetakRada,
			String loyalityKartica, String radnaOdjecaObuca, String ugovor, String zavrsenoZanimanje) {
		super();
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
	
	
	

}
