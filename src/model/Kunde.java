package model;


import java.io.Serializable;
import java.time.LocalDate;

import controller.Daten;

public class Kunde extends Person implements Serializable {

	/**
	 * 
	 */
	// Variablen
	private static final long serialVersionUID = 6994151685820447855L;
	private int kundenNummer;
	private String[] koffer = {"Jeans", "Pullover", "Wanderschuhe", "Kulturbeutel", "3x Unterw‰sche"}; 

	// Konstruktor
	public Kunde(){
		Daten.kundenummer++;
		kundenNummer = Daten.kundenummer;
		super.setVorname("Vorname");
		super.setNachname("Nachname");
		super.setGeburtsDatum(LocalDate.now());
		super.setStrasse("Straﬂe");
		super.setHausNummer(-1);
		super.setPlz(-12345);
		super.setOrt("Ort");
		super.setLand("Land");
		super.setEmail("email@adresse.de");
	}
	
	// Methoden
	
	public int getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(int kundenNummer) {
		this.kundenNummer = kundenNummer;
	}

	public String[] getKoffer() {
		return koffer;
	}

	public void setKoffer(String[] koffer) {
		this.koffer = koffer;
	}


	@Override
	public String toString() {
		return "Kunde \n[kundenNummer=" + kundenNummer 
				+ ", \nvorname=" + getVorname() + ", nachname=" + getNachname()
				+ ", \ngeburtsDatum=" + getGeburtsDatum() 
				+ ", \nemail=" + getEmail() + "]";
	}

	public void infoAnzeigen() {
		System.out.println("Kundennummer: " + kundenNummer
							+ "\nName: " + getVorname() + " " + getNachname()
							+ "\nGeburtsdatum: " + getGeburtsDatum()
							+ "\nAnschrift:" 
							+ "\n" + getStrasse() + " " + getHausNummer()
							+ "\n" + getPlz() + " " + getOrt()
							+ "\n" + getLand()
							+ "\nEmail: " + getEmail());
	}
	
	public void kofferAuspacken() {
		for (String gegenstand : koffer) {
			System.out.println(gegenstand);
		}
	}
	
	public void wuerfeln() {
		Wuerfel wuerfel = new Wuerfel();
		wuerfel.wuerfeln();
	}

}