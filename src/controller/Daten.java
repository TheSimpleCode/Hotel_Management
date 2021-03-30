package controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import model.Hotel;
import model.Kunde;
import model.Reservierung;
import model.Zimmer;

public class Daten implements Serializable {

	/**
	 * 
	 */
	// Variablen
	private static final long serialVersionUID = 4046211161162040642L;
	
	public static int zimmernummer;
	public static int kundenummer;
 	public static int reservierungen;
 	
	private static Hotel hotel;	
	private static Zimmer zimmer;
	private static Kunde kunde;
	private static Reservierung reservierung;
	
	private static String textLadefehlerBody = "daten konnten nicht geladen werden!"
												+ "\nBitte legen Sie die Daten an und speichern Sie diese.";
	private static String textLadefehlerHoteldaten = "Hotel" + textLadefehlerBody;
	private static String textLadefehlerZimmerdaten = "Zimmer" + textLadefehlerBody;
	private static String textLadefehlerKundendaten = "Kunden" + textLadefehlerBody;
	private static String textLadefehlerReservierungsdaten = "Reservierungs" + textLadefehlerBody;

	
	
	// Methoden
	
	public static void hotelSpeichern(Hotel hotel) {
		if (Daten.getHotel() != null) {
			try (ObjectOutputStream oos = 
					new ObjectOutputStream(
							new BufferedOutputStream(
									new FileOutputStream("src/hotel.dat")))) {
				oos.writeObject(Daten.getHotel());
				System.out.println("Hoteldaten wurden gespeichert");
			} catch (FileNotFoundException e) {
				System.out.println("Hoteldaten konnten nicht gespeichert werden");
			} catch (IOException e) {
				System.out.println("Hoteldaten konnten nicht gespeichert werden");
			} 
		} else {
			System.out.println("Hoteldaten sind leer und wurden nicht gespeichert");
		}
	}
	
	public static void hotelLaden() {
		try (ObjectInputStream ois = 
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream("src/hotel.dat")))) {
			setHotel((Hotel) ois.readObject());
			System.out.println("Hoteldaten wurden geladen");
		} catch (FileNotFoundException e) {
			System.out.println(textLadefehlerHoteldaten);
		} catch (IOException e) {
			System.out.println("Hoteldaten konnten nicht geladen werden");
		} catch (ClassNotFoundException e) {
			System.out.println("Hoteldaten konnten nicht geladen werden");
		}
	}
	
	public static void zimmerSpeichern(Zimmer zimmer) {
		if (Daten.getZimmer() != null) {
			try (ObjectOutputStream oos = 
					new ObjectOutputStream(
							new BufferedOutputStream(
									new FileOutputStream("src/zimmer.dat")))) {
				oos.writeObject(Daten.getZimmer());
				System.out.println("Zimmerdaten wurden gespeichert");
			} catch (FileNotFoundException e) {
				System.out.println("Zimmerdaten konnten nicht gespeichert werden");
			} catch (IOException e) {
				System.out.println("Zimmerdaten konnten nicht gespeichert werden");
			} 
		} else {
			System.out.println("Zimmerdaten sind leer und wurden nicht gespeichert");
		}
	}
	
	public static void zimmerLaden() {
		try (ObjectInputStream ois = 
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream("src/zimmer.dat")))) {
			setZimmer((Zimmer) ois.readObject());
			System.out.println("Zimmerdaten wurden geladen");
		} catch (FileNotFoundException e) {
			System.out.println(textLadefehlerZimmerdaten);
		} catch (IOException e) {
			System.out.println("Zimmerdaten konnten nicht geladen werden");
		} catch (ClassNotFoundException e) {
			System.out.println("Zimmerdaten konnten nicht geladen werden");
		}
	}
	
	public static void kundenSpeichern(Kunde kunde) {
		if (Daten.getKunde() != null) {
			try (ObjectOutputStream oos = 
					new ObjectOutputStream(
							new BufferedOutputStream(
									new FileOutputStream("src/kunden.dat")))) {
				oos.writeObject(Daten.getKunde());
				System.out.println("Kundendaten wurden gespeichert");
			} catch (FileNotFoundException e) {
				System.out.println("Kundendaten konnten nicht gespeichert werden");
			} catch (IOException e) {
				System.out.println("Kundendaten konnten nicht gespeichert werden");
			} 
		} else {
			System.out.println("Kundendaten sind leer und wurden nicht gespeichert");
		}
	}
	
	public static void kundenLaden() {
		try (ObjectInputStream ois = 
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream("src/kunden.dat")))) {
			setKunde((Kunde) ois.readObject());
			System.out.println("Kundendaten wurden geladen");
		} catch (FileNotFoundException e) {
			System.out.println(textLadefehlerKundendaten);
		} catch (IOException e) {
			System.out.println("Kundendaten konnten nicht geladen werden");
		} catch (ClassNotFoundException e) {
			System.out.println("Kundendaten konnten nicht geladen werden");
		}
	}
	
	public static void reservierungSpeichern(Reservierung reservierung) {
		if (Daten.getReservierung() != null) {
			try (ObjectOutputStream oos = 
					new ObjectOutputStream(
							new BufferedOutputStream(
									new FileOutputStream("src/reservierungen.dat")))) {
				oos.writeObject(Daten.getReservierung());
				System.out.println("Reservierungsdaten wurden gespeichert");
			} catch (FileNotFoundException e) {
				System.out.println("Reservierungsdaten konnten nicht gespeichert werden");
			} catch (IOException e) {
				System.out.println("Reservierungsdaten konnten nicht gespeichert werden");
			} 
		} else {
			System.out.println("Reservierungsdaten sind leer und wurden nicht gespeichert");
		}
	}
	
	public static void reservierungLaden() {
		try (ObjectInputStream ois = 
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream("src/reservierungen.dat")))) {
			setReservierung((Reservierung) ois.readObject());
			System.out.println("Reservierungsdaten wurden geladen");
		} catch (FileNotFoundException e) {
			System.out.println(textLadefehlerReservierungsdaten);
		} catch (IOException e) {
			System.out.println("Reservierungsdaten konnten nicht geladen werden");
		} catch (ClassNotFoundException e) {
			System.out.println("Reservierungsdaten konnten nicht geladen werden");
		}
	}

	public static Hotel getHotel() {
		return hotel;
	}

	public static void setHotel(Hotel hotel) {
		Daten.hotel = hotel;
	}
	
	public static Zimmer getZimmer() {
		return zimmer;
	}

	public static void setZimmer(Zimmer zimmer) {
		Daten.zimmer = zimmer;
	}

	public static Kunde getKunde() {
		return kunde;
	}

	public static void setKunde(Kunde kunde) {
		Daten.kunde = kunde;
	}

	public static Reservierung getReservierung() {
		return reservierung;
	}

	public static void setReservierung(Reservierung reservierung) {
		Daten.reservierung = reservierung;
	}
	
}
