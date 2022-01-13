package org.hbrs.se1.ws21.uebung10;

public class GraficDocument extends CoreDocument{

    private String inhalt;

    public GraficDocument(String url){
        this.inhalt = url;
    }

    public int size(){
        return 1200;
    }
}
