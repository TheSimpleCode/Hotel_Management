package model;


import java.io.Serializable;
import java.time.LocalDate;


public abstract class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2647835387732239173L;
	private String vorname;
	private String nachname;
	private LocalDate geburtsDatum;
	private String strasse;
	private int hausNummer;
	private int plz;
	private String ort;
	private String land;
	private String email;

	public Person() {
		super();
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public LocalDate getGeburtsDatum() {
		return geburtsDatum;
	}

	public void setGeburtsDatum(LocalDate geburtsDatum) {
		this.geburtsDatum = geburtsDatum;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getHausNummer() {
		return hausNummer;
	}

	public void setHausNummer(int hausNummer) {
		this.hausNummer = hausNummer;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}