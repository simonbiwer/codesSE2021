package org.hbrs.se1.ws21.solutions.uebung10;

public class TestClient {
	
	public void run() {
		
		ComplexDocument doc0 = new ComplexDocument();
		doc0.setID(1);
		
		Document doc2 = new TextDocument("Die Klausur im Fach SE findet bald statt!" , TextDocument.Encoding.UTF8  );
		doc2.setID(3);
		
		ComplexDocument doc3 = new ComplexDocument();
		doc3.setID(1);
		
		Document doc4 = new GraficDocument( "localhost:8080" );
		doc4.setID(2);

		Document doc5 = new TextDocument("Software Engineering I ist eine Vorlesung in den Studiengaengen BIS und BCS" , TextDocument.Encoding.UTF32  );
		doc5.setID(3);
		
		doc3.addDocument(doc4);
		doc3.addDocument(doc5);
		
		doc0.addDocument(doc3);
		doc0.addDocument(doc2);
		
		System.out.println("Size of Docs: " +  doc0.size() + " Bytes" );
	}

	public static void main(String[] args) {
		TestClient c = new TestClient();
		c.run();
	}

}
