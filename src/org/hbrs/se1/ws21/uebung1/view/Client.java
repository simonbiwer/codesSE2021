package org.hbrs.se1.ws21.uebung1.view;

import org.hbrs.se1.ws21.uebung1.control.Translator;
import org.hbrs.se1.ws21.uebung1.control.TranslatorFactory;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */

	//Möglichkeit verschiedene Translator vom Client ausgeben zu lassen und bei Erstellung zu übergeben

	private Translator translator;

	public Client(Translator translator){
		this.translator = translator;
	}

	public void display( int aNumber ) {
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		//
		// Strenge Implementierung gegen das Interface Translator gewuenscht!

		//Verwendung des Design Pattern "Factory Method"

		Translator translator = TranslatorFactory.createGermanTranslator();

		System.out.println("Das Ergebnis der Berechnung: " +
				translator.translateNumber(aNumber));
	}
}




