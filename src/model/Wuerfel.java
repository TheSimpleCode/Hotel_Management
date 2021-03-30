package model;


import java.util.Random;

public class Wuerfel {

	private Random ran = new Random();
	private int zufallszahl;
	
	
	public void wuerfeln() {
		zufallszahl = (ran.nextInt(6)+1);
		wuerfelAnzeigen(zufallszahl);
	}

	public void wuerfelAnzeigen(int zufallszahl) {
		System.out.println("Du hast eine " + zufallszahl + " gewürfelt.");
	}
}
