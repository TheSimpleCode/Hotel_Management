package model;


import java.io.Serializable;

import controller.Daten;

public class Zimmer implements Serializable {

	/**
	 * 
	 */
	// Variablen
	private static final long serialVersionUID = 3836330131809598611L;
	private int zimmerNummer;	
	private String zimmerName;	
	private int tagesPreis;


	// Konstruktor
	public Zimmer() {
		Daten.zimmernummer++;
		zimmerNummer = Daten.zimmernummer;
		zimmerName = "Zimmername";
		tagesPreis = -1;
	}

	
	// Methoden
	
		@Override
		public String toString() {
			return "Zimmer \n[zimmerNummer=" + zimmerNummer + ", \nzimmerName=" + zimmerName + ", \ntagesPreis="
					+ tagesPreis + "]";
		}


		public void infoAnzeigen() {
			System.out.println("Zimmernummer: " + zimmerNummer
								+ "\nZimmername: " + zimmerName
								+ "\nZimmerpreis: " + tagesPreis + "€");
		}


		public int getZimmerNummer() {
			return zimmerNummer;
		}


		public void setZimmerNummer(int zimmerNummer) {
			this.zimmerNummer = zimmerNummer;
		}


		public String getZimmerName() {
			return zimmerName;
		}


		public void setZimmerName(String zimmerName) {
			this.zimmerName = zimmerName;
		}


		public int getTagesPreis() {
			return tagesPreis;
		}


		public void setTagesPreis(int tagesPreis) {
			this.tagesPreis = tagesPreis;
		}


}
