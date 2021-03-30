package model;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import controller.Daten;

public class Reservierung implements Serializable {

	/**
	 * 
	 */
	// Variablen
	private static final long serialVersionUID = 4691335666594586214L;
	private int reservierungsnummer;
	private LocalDate reservierungsbeginn;
	private LocalDate reservierungsende;
	private LocalDate rechnungsdatum = LocalDate.now();
	private Period mietdauerBerechnung;
	private int mietdauer;
	private int mieteGesamt = 0;
	
	
	// Methoden
	
	public int getReservierungsnummer() {
		return reservierungsnummer;
	}

	public void setReservierungsnummer(int reservierungsnummer) {
		this.reservierungsnummer = reservierungsnummer;
	}

	public LocalDate getReservierungsbeginn() {
		return reservierungsbeginn;
	}

	public void setReservierungsbeginn(LocalDate reservierungsbeginn) {
		this.reservierungsbeginn = reservierungsbeginn;
	}

	public LocalDate getReservierungsende() {
		return reservierungsende;
	}

	public void setReservierungsende(LocalDate reservierungsende) {
		this.reservierungsende = reservierungsende;
	}

	public LocalDate getRechnungsdatum() {
		return rechnungsdatum;
	}

	public void setRechnungsdatum(LocalDate rechnungsdatum) {
		this.rechnungsdatum = rechnungsdatum;
	}

	public int getMietdauer() {
		return mietdauer;
	}

	public void setMietdauer(int mietdauer) {
		this.mietdauer = mietdauer;
	}

	public int getMieteGesamt() {
		return mieteGesamt;
	}

	public void setMieteGesamt(int mieteGesamt) {
		this.mieteGesamt = mieteGesamt;
	}



	@Override
	public String toString() {
		return "Reservierung [reservierungsnummer=" + reservierungsnummer + ", reservierungsbeginn="
				+ reservierungsbeginn + ", reservierungsende=" + reservierungsende + "]";
	}

	public void infoAnzeigen() {
		mietdauerBerechnen();
		System.out.println("Reservierungsnummer: " + reservierungsnummer
				+ "\nDatum: von " + reservierungsbeginn + " bis " + reservierungsende
				+ "\nMietdauer: " + mietdauer + " Tage");
	}
	
	
	public void mietdauerBerechnen() {
		if (reservierungsbeginn != null && reservierungsende != null) {
			setMietdauerBerechnung(Period.between(reservierungsbeginn, reservierungsende));
			mietdauer = mietdauerBerechnung.getDays();
		}
	}
	
	public void preisBerechnen(Zimmer zimmer, int mietdauer) {
		if(mietdauer >= 0 && zimmer.getTagesPreis() >= 0) {
			mieteGesamt = mietdauer * zimmer.getTagesPreis(); 
		} else {
			mieteGesamt = 0;
		}	
	}
	
	public void mietpreisAnzeigen() {
		preisBerechnen(Daten.getZimmer(), mietdauer);
		System.out.println("Die Gesamtmiete beträgt " + mieteGesamt + "€");
	}
	
	
	public void rechnungAnzeigen() {
		if (Daten.getHotel() != null 
				&& Daten.getZimmer() != null 
				&& Daten.getKunde() != null 
				&& Daten.getReservierung() != null) {
			preisBerechnen(Daten.getZimmer(), Daten.getReservierung().getMietdauer());
			System.out.print("\033[H\033[2J"); // sollte bei Ausführung in der Konsole den cls Befehl ausführen
			System.out.println("\nHotel " + Daten.getHotel().getNameHotel() 
								+ "\n" +  Daten.getHotel().getStrasse() + " " +  Daten.getHotel().getHausNummer()
								+ "\n" +  Daten.getHotel().getPlz() + " " +  Daten.getHotel().getOrt()
								+ "\n\nRechnungsdatum:" + Daten.getReservierung().getRechnungsdatum()
								+ "\nRechnungsnummer: " + Daten.getReservierung().getReservierungsnummer());
			
			System.out.println();
			System.out.println();
			
			System.out.println("Sehr geehrte(r) " + Daten.getKunde().getVorname() + " " + Daten.getKunde().getNachname() + "," 
								+ "\n\nWir hoffen, dass Sie Ihren Aufenhalt vom "+ Daten.getReservierung().getReservierungsbeginn() 
								+ " bis " + Daten.getReservierung().getReservierungsende() + " in unserem Hause genossen haben." 
			                    + "\nFür die Mietdauer von " + Daten.getReservierung().getMietdauer() + " Tagen in unserem Zimmer " 
								+ Daten.getZimmer().getZimmerName() + " (Tagespreis " + Daten.getZimmer().getTagesPreis() + "€)" 
								+ " erlauben wir uns \nIhnen insgesamt " + Daten.getReservierung().getMieteGesamt() + "€ in Rechnung zu stellen."
			                    + "\nDer Rechnungsbetrag ist bei Abreise fällig und kann bar oder mit EC bezahlt werden."
								+ "\n\nDas Hotelteam bedankt sich für Ihren Besuch und wir hoffen Sie bald wieder bei uns begrüßen zu dürfen."
			                    + "\n\nMit freundlichen Grüßen,"
								+ "\n" + Daten.getHotel().getNameInhaber());
			

			System.out.println();	
			System.out.println(Daten.getHotel().getOrt() + ", den " + Daten.getReservierung().getRechnungsdatum() + "\n");
			
		} else {
			System.out.println("Bitte vervollständigen Sie die Hotel/Zimmer/Kunden/Reservierungsdaten und speichern Sie diese."
					 			+ "Anschließend können Sie sich hier die Rechnung anzeigen lassen.");
		}
	}

	public Period getMietdauerBerechnung() {
		return mietdauerBerechnung;
	}

	public void setMietdauerBerechnung(Period mietdauerBerechnung) {
		this.mietdauerBerechnung = mietdauerBerechnung;
	}
	
}
