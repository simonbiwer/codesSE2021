package org.hbrs.se1.ws21.uebung8;

public class Hotelsuche {

    public SuchErgebnis suche(SuchAuftrag suchAuftrag){
        Adapter adapterRA = new AdapterRA();
        return adapterRA.processSuche(suchAuftrag);
    }
}
