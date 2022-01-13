package org.hbrs.se1.ws21.uebung10;

public class TestClient {
    public static void main(String[] args){
        ComplexDocument doc0 = new ComplexDocument();
        CoreDocument doc2 = new TextDocument("Die Klausur im Fach SE findet bald statt!", TextDocument.Encoding.UTF8);
        doc0.addComponent(doc2);
        ComplexDocument doc3 = new ComplexDocument();
        CoreDocument doc5 = new TextDocument("Software Engineering 1 ist eine Vorlesung in den Studiengaengen BIS und BCS", TextDocument.Encoding.UTF32);
        CoreDocument doc4 = new GraficDocument("localhost:8080");
        doc3.addComponent(doc4);
        doc3.addComponent(doc5);
        doc0.addComponent(doc3);
        int gesamtgroesse = doc0.size();
        System.out.println(gesamtgroesse);
    }
}
