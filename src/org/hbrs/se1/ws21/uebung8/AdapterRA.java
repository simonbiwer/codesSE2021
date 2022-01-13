package org.hbrs.se1.ws21.uebung8;

public class AdapterRA implements Adapter{

    @Override
    public SuchErgebnis processSuche(SuchAuftrag suchAuftrag) {
        QueryObject o = auftragZuObject(suchAuftrag);
        ReiseAnbieter reiseAnbieter = new ReiseAnbieter();
        QueryResult queryResult = reiseAnbieter.executeQuery(o);
        return resultZuErgebnis(queryResult);
    }

    private QueryObject auftragZuObject(SuchAuftrag suchAuftrag){
        return new QueryObject();
    }
    private SuchErgebnis resultZuErgebnis(QueryResult queryResult){
        return new SuchErgebnis();
    }
}
