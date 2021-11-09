package org.hbrs.se1.ws21.uebung4.view;

import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung4.model.ComparatorMitarbeiterID;
import org.hbrs.se1.ws21.uebung4.model.Mitarbeiter;

import java.util.Comparator;
import java.util.List;

public class MitarbeiterView {
    public static void dump(List<Member> list, String abteilung) {
        String out = String.format("|%-10s|%-30s|%-30s|%-30s|%-30s|%n", "ID", "Vorname", "Nachname", "Rolle", "Abteilung");
        Comparator<Member> c = new ComparatorMitarbeiterID();
        list.sort(c);
            for (Member member : list){
                Mitarbeiter m;
                if (member instanceof Mitarbeiter){
                    m = (Mitarbeiter) member;
                } else{
                    throw new IllegalArgumentException("Es sind nur Mitarbeiter erlaubt");
                }
                if (abteilung == null){
                    out = out + String.format("|%-10s|%-30s|%-30s|%-30s|%-30s|%n", m.getID(), m.getVorname(), m.getNachname(), m.getRolle(), m.getAbteilung());
                } else if (abteilung.equals(m.getAbteilung())){
                    out = out + String.format("|%-10s|%-30s|%-30s|%-30s|%-30s|%n", m.getID(), m.getVorname(), m.getNachname(), m.getRolle(), m.getAbteilung());
                }
            }
        System.out.println(out);
    }
}
