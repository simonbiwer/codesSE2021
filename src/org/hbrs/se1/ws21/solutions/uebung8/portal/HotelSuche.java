package org.hbrs.se1.ws21.solutions.uebung8.portal;

public class HotelSuche {

    public void main() {
        SuchAuftrag suchAuftrag = new SuchAuftrag();
        ExternalHotelSucheInterface service = new ReiseAnbieterAdapter();
        SuchErgebnis suchErgebnis = service.suche( suchAuftrag );
    }

}
