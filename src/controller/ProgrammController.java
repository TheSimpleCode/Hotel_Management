package controller;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

import model.Hotel;
import model.Kunde;
import model.Reservierung;
import model.Zimmer;

public class ProgrammController {
	
	
	// Variablen
	private String textProgrammStart = "Hotelverwaltung [Programm Start]";
	private String textProgrammEnde = "Hotelverwaltung [Programm Ende]";
	
	private String textBegruessung = "\nHerzlich Willkommen zum Programm 'Hotelverwaltung' (V1.0)." 
			+ "\nDiese Anwendungs entstand als meine Projektarbeit im Java Grundkurs im September 2020" 
			+ "\nund ist in der vorliegenden Version noch eine reine Konsolenanwendung." 
			+ "\n\nZiel dieser App ist die einfache Verwaltung eines Hotels" 
			+ "\nmit vorerst noch jeweils nur einem Zimmer, Kunden und einer Reservierung." 
			+ "\nBei der ersten Verwendung muss der Benutzer zuerst Hotel-, Zimmer-, Kunden-" 
			+ "\nund Reservierungsdaten eingeben und speichern." 
			+ "\nErst wenn diese Daten hinterlegt/gespeichert sind können alle weiteren Kunden und Reservierungs-" 
			+ "\nfunktionen genutzt und die Daten über die Laden-Funktion bei einem Programmneustart" 
			+ "\nwieder eingelesen und verwendet werden." 
			+ "\n\nDas Programm kann inklusive Quelltext frei genutzt und vervielfältigt werden." 
			+ "\nBei kommerzieller Nutzung oder Weiterentwicklung ist zwingend" 
			+ "\nder Hinweis auf den Urheber in den Credits aufzuführen." 
			+ "\n\nFulda, der 01.10.2020, Benjamin Will\n";
			
	private String textHauptmenue = "Hotelverwaltung [1=Laden 2=Anzeigen/Editieren 3=Speichern 4=Ende] >";
	private String textAnzeigenEditierenMenue = "Anzeigen/Editieren [1=Hotel 2=Zimmer 3=Kunde 4=Reservierung 5=Zurück] >";
	private String textHoteldatenMenue = "Hoteldaten [1=Anzeigen 2=Editieren 3=Speichern 4=Zurück] >";
	private String textZimmerdatenMenue = "Zimmerdaten [1=Anzeigen 2=Editieren  3=Speichern 4=Zurück] >";
	private String textKundendatenMenue = "Kundendaten [1=Anzeigen 2=Editieren 3=Speichern 4=Auspacken 5=Würfeln 6=Zurück] >";
	private String textReservierungsdatenMenue = "Reservierungsdaten [1=Anzeigen 2=Editieren 3=Speichern 4=Rechnung 5=Zurück] >";
	private String textSpeichernMenue = "Datensätze speichern [1=Auswahl 2=Alle 3=Zurück] >";
	private String textSpeichernDatensaetzeAuswahlMenue = "Auswahl speichern [1=Hotel 2=Zimmer 3=Kunden 4=Reservierungen 5=Zurück] >";
	
	private String textKeineDatenHinterlegtAnfang = "Aktuell sind keine ";
	private String textKeineDatenHinterlegtEnde = "daten hinterlegt." 
			+ "\nBitte legen Sie die Daten an und speichern Sie diese oder laden Sie bereits bestehende Daten.";
	
	private String textKeineHoteldatenHinterlegt = textKeineDatenHinterlegtAnfang
											+ "Hotel"
											+ textKeineDatenHinterlegtEnde;
	
	private String textKeineZimmerdatenHinterlegt = textKeineDatenHinterlegtAnfang
											+ "Zimmer"
											+ textKeineDatenHinterlegtEnde;
			
	private String textKeineKundendatenHinterlegt = textKeineDatenHinterlegtAnfang
											+ "Kunden"
											+ textKeineDatenHinterlegtEnde;
	
	private String textKeineReservierungsdatenHinterlegt = textKeineDatenHinterlegtAnfang
											+ "Reservierungs"
											+ textKeineDatenHinterlegtEnde;
		
	private String textFalscheingabeBody =  "[Falsche Eingabe!]";
	private String textFalscheingabeHoteldatenMenu = "Hoteldaten" + textFalscheingabeBody;
	private String textFalscheingabeZimmerdatenMenu = "Zimmerdaten" + textFalscheingabeBody;
	private String textFalscheingabeKundendatenMenu = "Kundendaten" + textFalscheingabeBody;
	private String textFalscheingabeReservierungsdatenMenu = "Reservierungsdaten" + textFalscheingabeBody;
	private String textFalscheingabeAnzeigenEditierenMenu = "Anzeigen/Editieren" + textFalscheingabeBody;
	private String textFalscheingabeSpeichernMenue = "Datensätze speichern" + textFalscheingabeBody;
	private String textFalscheingabeHauptMenue = "Hotelverwaltung" + textFalscheingabeBody;

	private Scanner scanner;
	
	// Konstruktor
	public ProgrammController(){
		try {
			System.out.println(textProgrammStart);
			System.out.println(textBegruessung);
			
			// Hier startet der Programmablauf in die Menünavigation auf der Konsole
			scanner = new Scanner(System.in);
			boolean nochmalHauptmenue = true;
			while (nochmalHauptmenue) {
				System.out.print(textHauptmenue);
				int auswahl = scanner.nextInt();
				if (auswahl ==1) {
					laden();
				} else if (auswahl ==2) {
					boolean nochmalAnzeigenEditierenMenue = true;
					while (nochmalAnzeigenEditierenMenue) {
						System.out.print(textAnzeigenEditierenMenue);
						auswahl = scanner.nextInt();
						if (auswahl ==1) {
							boolean nochmalHoteldatenMenue = true;
							while (nochmalHoteldatenMenue) {
								System.out.print(textHoteldatenMenue);
								auswahl = scanner.nextInt();
								if (auswahl ==1) {
									if (Daten.getHotel() != null) {
										hotelDatenAnzeigen();
									} else {
										System.out.println(textKeineHoteldatenHinterlegt);
									}
								} else if (auswahl ==2) {
									Daten.setHotel(new Hotel());
									hotelDatenEditieren();
								} else if (auswahl ==3) { 	
									if (Daten.getHotel() != null) {
										Daten.hotelSpeichern(Daten.getHotel());
									} else {
										System.out.println(textKeineHoteldatenHinterlegt);
									}
								} else if (auswahl ==4) {
									nochmalHoteldatenMenue = false;
								} else {
									System.out.println(textFalscheingabeHoteldatenMenu);
								}
							}
						} else if (auswahl ==2) {
							boolean nochmalZimmerdatenMenue = true;
							while (nochmalZimmerdatenMenue) {
								System.out.print(textZimmerdatenMenue);
								auswahl = scanner.nextInt();
								if (auswahl ==1) {
									if (Daten.getZimmer() != null) {
										zimmerDatenAnzeigen();
									} else {
										System.out.println(textKeineZimmerdatenHinterlegt);
									}
								} else if (auswahl ==2) {
									Daten.setZimmer(new Zimmer());
									zimmerDatenEditieren();
								} else if (auswahl ==3) { 	
									if (Daten.getZimmer() != null) {
										Daten.zimmerSpeichern(Daten.getZimmer());
									} else {
										System.out.println(textKeineZimmerdatenHinterlegt);
									}
								} else if (auswahl ==4) {
									nochmalZimmerdatenMenue = false;
								} else {
									System.out.println(textFalscheingabeZimmerdatenMenu);
								}
							}
						} else if (auswahl ==3) {
							boolean nochmalKundendatenMenue = true;
							while (nochmalKundendatenMenue) {
								System.out.print(textKundendatenMenue);
								auswahl = scanner.nextInt();
								if (auswahl ==1) {
									if (Daten.getKunde() != null) {
										kundenDatenAnzeigen();
									} else {
										System.out.println(textKeineKundendatenHinterlegt);
									}
								} else if (auswahl ==2) {
									Daten.setKunde(new Kunde());
									kundenDatenEditieren();
								} else if (auswahl ==3) { 	
									if (Daten.getKunde() != null) {
										Daten.kundenSpeichern(Daten.getKunde());
									} else {
										System.out.println(textKeineKundendatenHinterlegt);
									}
								} else if (auswahl ==4) {
									if (Daten.getKunde() != null) {
										Daten.getKunde().kofferAuspacken();
									} else {
										System.out.println(textKeineKundendatenHinterlegt);
									}
								} else if (auswahl ==5) {
									if (Daten.getKunde() != null) {
										Daten.getKunde().wuerfeln();
									} else {
										System.out.println(textKeineKundendatenHinterlegt);
									}
								} else if (auswahl ==6) {
									nochmalKundendatenMenue = false;
								} else {
									System.out.println(textFalscheingabeKundendatenMenu);
								}
							}
						} else if (auswahl ==4) {
							boolean nochmalReservierungsdatenMenue = true;
							while (nochmalReservierungsdatenMenue) {
								System.out.print(textReservierungsdatenMenue);
								auswahl = scanner.nextInt();
								if (auswahl ==1) {
									if (Daten.getReservierung() != null) {
										reservierungAnzeigen();
									} else {
										System.out.println(textKeineReservierungsdatenHinterlegt);
									}
								} else if (auswahl ==2) {
									Daten.setReservierung(new Reservierung());
									reservierungEditieren();
								} else if (auswahl ==3) { 	
									if (Daten.getReservierung() != null) {
										Daten.reservierungSpeichern(Daten.getReservierung());
									} else {
										System.out.println(textKeineReservierungsdatenHinterlegt);
									}
								} else if (auswahl ==4) {
									if (Daten.getReservierung() != null
											&& Daten.getHotel() != null
											&& Daten.getZimmer() != null
											&& Daten.getKunde() != null
										) {
										Daten.getReservierung().rechnungAnzeigen();
									} else {
										System.out.println(textKeineReservierungsdatenHinterlegt);
									}
								} else if (auswahl ==5) {
									nochmalReservierungsdatenMenue = false;
								} else {
									System.out.println(textFalscheingabeReservierungsdatenMenu);
								}
							}
						} else if (auswahl ==5) {
							nochmalAnzeigenEditierenMenue = false;
						} else {
							System.out.println(textFalscheingabeAnzeigenEditierenMenu);
						}
					}
				} else if (auswahl ==3) {
					boolean speichernMenue = true;
					while (speichernMenue) {
						System.out.print(textSpeichernMenue);
						auswahl = scanner.nextInt();
						if (auswahl ==1) {
							boolean datensaetzeAuswahlMenue = true;
							while (datensaetzeAuswahlMenue) {
								System.out.print(textSpeichernDatensaetzeAuswahlMenue);
								auswahl = scanner.nextInt();
								if (auswahl ==1) {
									datensaetzeAuswahlSpeichern(auswahl);
								} else if (auswahl ==2) {
									datensaetzeAuswahlSpeichern(auswahl);
								} else if (auswahl ==3) {
									datensaetzeAuswahlSpeichern(auswahl);
								} else if (auswahl ==4) {
									datensaetzeAuswahlSpeichern(auswahl);
								} else if (auswahl ==5) {
									datensaetzeAuswahlMenue = false;
								} else {
									System.out.println(textFalscheingabeSpeichernMenue);
								}
							}
						} else if (auswahl ==2) {
							datensaetzeAlleSpeichern();
						} else if (auswahl ==3) {
							speichernMenue = false;
						} else {
							System.out.println(textFalscheingabeSpeichernMenue);
						}
					}
				} else if (auswahl ==4) {
					nochmalHauptmenue = false;
				} else {
					System.out.println(textFalscheingabeHauptMenue);
				}
			}
			System.out.println(textProgrammEnde);

		} catch (Exception e) {
			System.out.println(textFalscheingabeBody + "!!! Bitte in Menüs nur Zahlen von 0 bis 9 verwenden !!!");
			@SuppressWarnings("unused")
			ProgrammController pg = new ProgrammController();
		} finally {
			scanner.close();
		}
	}


	// Methoden
	
	private void laden() {
		// Datensätze aus externen Dateien laden
		Daten.hotelLaden();
		Daten.zimmerLaden();
		Daten.kundenLaden();
		Daten.reservierungLaden();
	}
	
	private void hotelDatenAnzeigen() {
		Daten.getHotel().infoAnzeigen();
	}

	private void hotelDatenEditieren() {
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Bitte Hotelname eingeben:>");
				Daten.getHotel().setNameHotel(scanner.nextLine());
				System.out.println("Bitte Gründungsjahr eingeben:>");
				Daten.getHotel().setGruendungsJahr(Year.of(scanner.nextInt()));
				scanner.nextLine();
				System.out.println("Bitte Inhabername eingeben:>");
				Daten.getHotel().setNameInhaber(scanner.nextLine());
				System.out.println("Bitte Straßennamen eingeben:>");
				Daten.getHotel().setStrasse(scanner.nextLine());
				System.out.println("Bitte Hausnummer eingeben:>");
				Daten.getHotel().setHausNummer(scanner.nextInt());
				System.out.println("Bitte Postleitzahl eingeben:>");
				Daten.getHotel().setPlz(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Bitte Ortsnamen eingeben:>");
				Daten.getHotel().setOrt(scanner.nextLine());
				System.out.println("Bitte Land eingeben:>");
				Daten.getHotel().setLand(scanner.nextLine());
				System.out.println("Bitte Emailadresse eingeben:>");
				Daten.getHotel().setEmail(scanner.nextLine());
			} catch (Exception e) {
				System.out.println(textFalscheingabeBody);
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				scanner.nextLine();
			}
	}
	
	private void zimmerDatenAnzeigen() {
		Daten.getZimmer().infoAnzeigen();
	}
	
	private void zimmerDatenEditieren() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte Zimmernummer eingeben:>");
		Daten.getZimmer().setZimmerNummer(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Bitte Zimmername eingeben:>");
		Daten.getZimmer().setZimmerName(scanner.nextLine());
		System.out.println("Bitte Tagespreis eingeben:>");
		Daten.getZimmer().setTagesPreis(scanner.nextInt());
	}

	private void kundenDatenAnzeigen() {
		Daten.getKunde().infoAnzeigen();
	}
	
	private void kundenDatenEditieren() {
		int year = 0, month = 0, dayOfMonth = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte Kundennummer eingeben:>");
		Daten.getKunde().setKundenNummer(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Bitte Vorname eingeben:>");
		Daten.getKunde().setVorname(scanner.nextLine());
		System.out.println("Bitte Nachnamen eingeben:>");
		Daten.getKunde().setNachname(scanner.nextLine());
		System.out.println("Bitte Geburtsjahr eingeben:>");
		year = scanner.nextInt();
		System.out.println("Bitte Geburtmonat eingeben:>");
		month = scanner.nextInt();
		System.out.println("Bitte Geburtstag eingeben:>");
		dayOfMonth = scanner.nextInt();
		Daten.getKunde().setGeburtsDatum(LocalDate.of(year, month, dayOfMonth));
		scanner.nextLine();
		System.out.println("Bitte Straße eingeben:>");
		Daten.getKunde().setStrasse(scanner.nextLine());
		System.out.println("Bitte Hausnummer eingeben:>");
		Daten.getKunde().setHausNummer(scanner.nextInt());
		System.out.println("Bitte Postleitzahl eingeben:>");
		Daten.getKunde().setPlz(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Bitte Ort eingeben:>");
		Daten.getKunde().setOrt(scanner.nextLine());
		System.out.println("Bitte Land eingeben:>");
		Daten.getKunde().setLand(scanner.nextLine());
		System.out.println("Bitte Email eingeben:>");
		Daten.getKunde().setEmail(scanner.nextLine());
		
	}


	private void reservierungAnzeigen() {
		Daten.getReservierung().infoAnzeigen();
	}
	
	private void reservierungEditieren() {
		int year = 0, month = 0, dayOfMonth = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte Reservierungsnummer eingeben:>");
		Daten.getReservierung().setReservierungsnummer(scanner.nextInt());
		System.out.println("Bitte Jahr des Reservierungsbeginns eingeben:>");
		year = scanner.nextInt();
		System.out.println("Bitte Monat des Reservierungsbeginns eingeben:>");
		month = scanner.nextInt();
		System.out.println("Bitte Tag des Reservierungsbeginns eingeben:>");
		dayOfMonth = scanner.nextInt();
		Daten.getReservierung().setReservierungsbeginn(LocalDate.of(year, month, dayOfMonth));
		System.out.println("Bitte Jahr des Reservierungsendes eingeben:>");
		year = scanner.nextInt();
		System.out.println("Bitte Monat des Reservierungsendes eingeben:>");
		month = scanner.nextInt();
		System.out.println("Bitte Tag des Reservierungsendes eingeben:>");
		dayOfMonth = scanner.nextInt();
		Daten.getReservierung().setReservierungsende(LocalDate.of(year, month, dayOfMonth));
	}

	// Ausgewählten Datensatz in externe Datei speichern ( 1=Hotel ... 4=Reservierungen)
	private void datensaetzeAuswahlSpeichern(int auswahl) {
		switch (auswahl) {
		case 1:
			Daten.hotelSpeichern(Daten.getHotel());
			break;

		case 2:
			Daten.zimmerSpeichern(Daten.getZimmer());
			break;
			
		case 3:
			Daten.kundenSpeichern(Daten.getKunde());
			break;
			
		case 4:
			Daten.reservierungSpeichern(Daten.getReservierung());
			break;
			
		default:
			break;
		}
	}

	// Alle Datensätze in externe Dateien speichern
	private void datensaetzeAlleSpeichern() {
		Daten.hotelSpeichern(Daten.getHotel());
		Daten.zimmerSpeichern(Daten.getZimmer());
		Daten.kundenSpeichern(Daten.getKunde());
		Daten.reservierungSpeichern(Daten.getReservierung());
	}
	
	
	
}
