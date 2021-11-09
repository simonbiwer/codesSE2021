package org.hbrs.se1.ws21.uebung4.model;

import org.hbrs.se1.ws21.uebung2.Member;

import java.util.Comparator;

public class ComparatorMitarbeiterID implements Comparator<Member> {

    @Override
    public int compare(Member o1, Member o2) {
        return o1.getID() - o2.getID();
    }
}
