package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung2.Member;

import java.util.Arrays;
import java.util.HashMap;

public class Mitarbeiter implements Member {

    private int id;
    private String vorname;
    private String nachname;
    private String rolle;
    private String abteilung;
    private HashMap<String, Integer> expertisen;

    public Mitarbeiter(int id, String vorname, String nachname, String rolle, String abteilung, HashMap<String, Integer> expertisen){
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.rolle = rolle;
        this.abteilung = abteilung;
        this.expertisen = expertisen;
    }

    @Override
    public Integer getID() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getRolle() {
        return rolle;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public HashMap<String, Integer> getExpertisen() {
        return expertisen;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", rolle='" + rolle + '\'' +
                ", abteilung='" + abteilung + '\'' +
                ", expertisen=" + expertisen.toString() +
                '}';
    }
}
