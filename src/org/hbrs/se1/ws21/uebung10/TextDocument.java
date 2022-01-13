package org.hbrs.se1.ws21.uebung10;

import java.io.UnsupportedEncodingException;

public class TextDocument extends CoreDocument{

    private String inhalt;
    private Encoding encoding;

    public TextDocument(String inhalt, Encoding encoding){
        this.inhalt = inhalt;
        this.encoding = encoding;
    }

    public int size(){
        byte[] bytes = {};
        try{
            bytes = inhalt.getBytes(encoding.name());
        } catch(UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }
        return bytes.length;
    }

    public enum Encoding {
        UTF8, UTF16, UTF32
    }
}
