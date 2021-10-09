package org.hbrs.se1.ws21.uebung1.control;

import java.util.HashMap;

public class GermanTranslator implements Translator {

	private HashMap<Integer, String> zahlInString;

	public GermanTranslator(){
		zahlInString = new HashMap<>();
		zahlInString.put(1, "eins");
		zahlInString.put(2, "zwei");
		zahlInString.put(3, "drei");
		zahlInString.put(4, "vier");
		zahlInString.put(5, "fuenf");
		zahlInString.put(6, "sechs");
		zahlInString.put(7, "sieben");
		zahlInString.put(8, "acht");
		zahlInString.put(9, "neun");
		zahlInString.put(10, "zehn");
	}

	public String date = "Okt/2021"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]
		return zahlInString.getOrDefault(number, "Übersetzung der Zahl " + number +  " nicht möglich" + " (" + version + ")");
	}
		
	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Okt/2021))
	 * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
