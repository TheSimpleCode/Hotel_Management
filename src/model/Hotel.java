package model;


import java.io.Serializable;
import java.time.Year;

public class Hotel implements Serializable {
	
	/**
	 * 
	 */
	// Variablen
	private static final long serialVersionUID = 3461580805996466207L;
	private String nameHotel;	
	private String nameInhaber;	
	private Year gruendungsJahr;	
	private String strasse;	
	private int hausNummer;	
	private int plz;	
	private String ort;
	private String land;
	private String email;
	
	// Konstruktor
	public Hotel(){
		nameHotel = "Hotelname";	
		nameInhaber = "Inhabername";	
		gruendungsJahr = Year.now();	
		strasse = "Straße";	
		hausNummer = -1;	
		plz = -12345;	
		ort = "Ort";
		land = "Land";
		email = "email@adresse.de";
	}
	
	
	// Methoden
	
	@Override
	public String toString() {
		return "Hotel \n[nameHotel=" + nameHotel + ", \nnameInhaber=" + nameInhaber + ", \ngruendungsJahr=" + gruendungsJahr
				+ ", \nstrasse=" + strasse + ", hausNummer=" + hausNummer + ", \nplz=" + plz + ", ort=" + ort + ", land="
				+ land + ", \nemail=" + email + "]";
	}
	
	
	
	public void infoAnzeigen() {
		System.out.println("Hotelname: " + nameHotel 
							+ "\nGründungsjahr: " + gruendungsJahr
							+ "\nInhaber: " + nameInhaber 
							+ "\nAnschrift:\n" + strasse + " " + hausNummer 
							+ "\n" + plz + " " + ort 
							+ "\n" + land 
							+ "\nEmail: " + email);
	}


	public String getNameHotel() {
		return nameHotel;
	}


	public void setNameHotel(String nameHotel) {
		this.nameHotel = nameHotel;
	}


	public String getNameInhaber() {
		return nameInhaber;
	}


	public void setNameInhaber(String nameInhaber) {
		this.nameInhaber = nameInhaber;
	}


	public Year getGruendungsJahr() {
		return gruendungsJahr;
	}


	public void setGruendungsJahr(Year gruendungsJahr) {
		this.gruendungsJahr = gruendungsJahr;
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